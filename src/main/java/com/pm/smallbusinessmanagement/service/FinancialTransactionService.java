package com.pm.smallbusinessmanagement.service;


import com.pm.smallbusinessmanagement.model.FinancialTransaction;
import com.pm.smallbusinessmanagement.repository.FinancialTransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FinancialTransactionService {

    private final FinancialTransactionRepository financialTransactionRepository;

    public List<FinancialTransaction> getAllTransactions() {
        return financialTransactionRepository.findAll();
    }

    public Optional<FinancialTransaction> getTransactionById(Long id) {
        return financialTransactionRepository.findById(id);
    }

    public FinancialTransaction createTransaction(FinancialTransaction transaction) {
        return financialTransactionRepository.save(transaction);
    }

    public void deleteTransactionById(Long id) {
        financialTransactionRepository.deleteById(id);
    }

    public List<FinancialTransaction> getTransactionsByType(String type) {
        return financialTransactionRepository.findByType(type);
    }

    public List<FinancialTransaction> getTransactionsByClient(Long clientId) {
        return financialTransactionRepository.findByClientId(clientId);
    }
}