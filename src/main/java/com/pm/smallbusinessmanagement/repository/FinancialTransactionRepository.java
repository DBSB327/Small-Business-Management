package com.pm.smallbusinessmanagement.repository;

import com.pm.smallbusinessmanagement.model.FinancialTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FinancialTransactionRepository extends JpaRepository<FinancialTransaction, Long> {
    List<FinancialTransaction> findByType(String type);

    List<FinancialTransaction> findByClientId(Long clientId);
}
