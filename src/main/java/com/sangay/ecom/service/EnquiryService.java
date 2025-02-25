package com.sangay.ecom.service;

import com.sangay.ecom.Repository.TransactionRepository;
import com.sangay.ecom.dto.AccountInquiryDTO;
import com.sangay.ecom.helper.PGPKIImpl;
import com.sangay.ecom.helper.SourceStringHelper;
import com.sangay.ecom.helper.callApiHelper;
import com.sangay.ecom.model.TransactionMaster;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class EnquiryService {

    private final SourceStringHelper sourceStringHelper;
    private final TransactionRepository transactionRepository;
    private final PGPKIImpl pgpki;
    private final callApiHelper apiHelper;
    private static final Logger logger = LoggerFactory.getLogger(EnquiryService.class);

    public EnquiryService(SourceStringHelper sourceStringHelper, TransactionRepository transactionRepository, PGPKIImpl pgpki, callApiHelper apiHelper) {
        this.sourceStringHelper = sourceStringHelper;
        this.transactionRepository = transactionRepository;
        this.pgpki = pgpki;
        this.apiHelper = apiHelper;
    }

    public String accountEnquiry(AccountInquiryDTO accountInquiryDTO) {

        String bfs_txn_id = accountInquiryDTO.getBfs_bfsTxnId();
        // Fetch the transaction by order number
        Optional<TransactionMaster> transactionOptional = transactionRepository.findByBfsTxnId(bfs_txn_id);

        // Process the transaction if it exists
        return transactionOptional.map(transaction -> {
            logger.info("Transaction found: {}", transaction);

            // Update transaction details from the DTO
            transaction.setAccountNumber(accountInquiryDTO.getBfs_remitterAccNo());
            transaction.setBfs_remitterBankId(accountInquiryDTO.getBfs_remitterBankId());

            // Construct the source string
            String sourceString = sourceStringHelper.constructEnquirySourceString(transaction);

            try {
                // Generate checksum and update the transaction
                String checkSum = pgpki.signData(sourceString);
                transaction.setBfs_checkSum(checkSum);
                logger.info("AuthoriseRequestDTO Set[{}]", transaction);

                // Save the updated transaction
                transactionRepository.save(transaction);

                // Call the RMA API
                Map<String, String> stringStringMap = apiHelper.callRMAAE(transaction);
                logger.info("===RMA RESPONSE {}", stringStringMap);

                return "Transaction processed successfully.";
            } catch (Exception e) {
                logger.error("Error processing transaction: {}", e.getMessage(), e);
                throw new RuntimeException("Error processing transaction", e);
            }
        }).orElseGet(() -> {
            // Handle the case where the transaction is not found
            logger.info("No transaction found for transaction id: {}", bfs_txn_id);
            return "No transaction found for transaction id: " + bfs_txn_id;
        });
    }
}