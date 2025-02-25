package com.sangay.ecom.Repository;

import com.sangay.ecom.model.TransactionMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;


public interface TransactionRepository extends JpaRepository<TransactionMaster, Integer> {

    @Query("SELECT tm from TransactionMaster tm where tm.bfs_bfsTxnId=?1")
    Optional<TransactionMaster> findByBfsTxnId(String bfs_txn_id);
}
