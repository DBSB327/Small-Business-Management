package com.pm.smallbusinessmanagement.controller;

import com.pm.smallbusinessmanagement.model.Sale;
import com.pm.smallbusinessmanagement.service.SaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/sales")
@RequiredArgsConstructor
public class SaleController {

    private final SaleService saleService;

    @GetMapping("/getAll")
    public ResponseEntity<List<Sale>> getAllSales() {
        return ResponseEntity.ok(saleService.getAllSales());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Optional<Sale>> getSaleById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(saleService.getSaleById(id));
    }

    @PostMapping("/add")
    public ResponseEntity<Sale> addSale(@RequestBody Sale sale) {
        return ResponseEntity.ok(saleService.createSale(sale));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Sale> updateSale(@PathVariable("id") Long id, @RequestBody Sale sale) {
        Sale updatedSale = saleService.updateSale(id, sale);
        if (updatedSale != null) {
            return ResponseEntity.ok(updatedSale);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteSale(@PathVariable("id") Long id) {
        saleService.deleteSaleById(id);
        return ResponseEntity.ok("Sale deleted successfully");
    }
}