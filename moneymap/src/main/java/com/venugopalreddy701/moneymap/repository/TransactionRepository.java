package com.venugopalreddy701.moneymap.repository;

import com.venugopalreddy701.moneymap.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

    @Query("SELECT t FROM Transaction t WHERE t.user_id = :userId")
    List<Transaction> findByUserId(@Param("userId") int userId);

    @Query("SELECT t FROM Transaction t WHERE t.id = :id AND t.user_id = :userId")
    Optional<Transaction> findByTransactionIdUserId(@Param("id") int id, @Param("userId") int userId);
}
