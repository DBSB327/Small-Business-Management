package com.pm.smallbusinessmanagement.controller;

import com.pm.smallbusinessmanagement.model.FinancialTransaction;
import com.pm.smallbusinessmanagement.service.FinancialTransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/transactions")
@RequiredArgsConstructor
public class FinancialTransactionController {

    private final FinancialTransactionService financialTransactionService;

    @GetMapping("/getAll")
    public ResponseEntity<List<FinancialTransaction>> getAllTransactions() {
        return ResponseEntity.ok(financialTransactionService.getAllTransactions());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Optional<FinancialTransaction>> getTransactionById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(financialTransactionService.getTransactionById(id));
    }

    @PostMapping("/add")
    public ResponseEntity<FinancialTransaction> addTransaction(@RequestBody FinancialTransaction transaction) {
        return ResponseEntity.ok(financialTransactionService.createTransaction(transaction));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTransaction(@PathVariable("id") Long id) {
        financialTransactionService.deleteTransactionById(id);
        return ResponseEntity.ok("Transaction deleted successfully");
    }

    @GetMapping("/getByType/{type}")
    public ResponseEntity<List<FinancialTransaction>> getTransactionsByType(@PathVariable("type") String type) {
        return ResponseEntity.ok(financialTransactionService.getTransactionsByType(type));
    }

    @GetMapping("/getByClient/{clientId}")
    public ResponseEntity<List<FinancialTransaction>> getTransactionsByClient(@PathVariable("clientId") Long clientId) {
        return ResponseEntity.ok(financialTransactionService.getTransactionsByClient(clientId));
    }
}
