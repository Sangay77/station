package com.sangay.ecom.service;

import com.sangay.ecom.Repository.TransactionRepository;
import com.sangay.ecom.dto.DebitRequestDTO;
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
public class DebitService {

    private final SourceStringHelper sourceStringHelper;
    private final TransactionRepository transactionRepository;
    private final PGPKIImpl pgpki;
    private final callApiHelper apiHelper;
    private static final Logger logger = LoggerFactory.getLogger(DebitService.class);

    public DebitService(SourceStringHelper sourceStringHelper, TransactionRepository transactionRepository, PGPKIImpl pgpki, callApiHelper apiHelper) {
        this.sourceStringHelper = sourceStringHelper;
        this.transactionRepository = transactionRepository;
        this.pgpki = pgpki;
        this.apiHelper = apiHelper;
    }

    public String debit(DebitRequestDTO debitRequestDTO) {
        String bfsTxnId = debitRequestDTO.getBfs_bfsTxnId();
        Optional<TransactionMaster> transactionOptional = transactionRepository.findByBfsTxnId(bfsTxnId);

        return transactionOptional.map(transaction -> {
            logger.info("Transaction found: {}", transaction);

            // Update transaction details from the DTO
            transaction.setBfs_remitterOtp(debitRequestDTO.getBfs_remitterOtp());

            // Construct the source string
            String sourceString = sourceStringHelper.constructDebitSourceString(transaction);

            try {
                // Generate checksum and update the transaction
                String checkSum = pgpki.signData(sourceString);
                transaction.setBfs_checkSum(checkSum);
                logger.info("DebitRequest Set[{}]", transaction);

                // Call the RMA API for debit request
                Map<String, String> responseMap = apiHelper.callRMADR(transaction);
                logger.info("===RMA RESPONSE {}", responseMap);

                // Save the updated transaction
                transactionRepository.save(transaction);

                return "Debit request processed successfully. Response: " + responseMap;
            } catch (Exception e) {
                logger.error("Error processing debit request: {}", e.getMessage(), e);
                throw new RuntimeException("Error processing debit request", e);
            }
        }).orElseGet(() -> {
            // Handle the case where the transaction is not found
            logger.info("No transaction found for transaction ID: {}", bfsTxnId);
            return "No transaction found for transaction ID: " + bfsTxnId;
        });
    }
}