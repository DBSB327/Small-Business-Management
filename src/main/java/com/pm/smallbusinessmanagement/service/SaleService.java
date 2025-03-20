package com.pm.smallbusinessmanagement.service;

import com.pm.smallbusinessmanagement.model.Sale;
import com.pm.smallbusinessmanagement.repository.SaleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SaleService {

    private final SaleRepository saleRepository;

    public List<Sale> getAllSales() {
        return saleRepository.findAll();
    }

    public Optional<Sale> getSaleById(Long id) {
        return saleRepository.findById(id);
    }

    public Sale createSale(Sale sale) {
        return saleRepository.save(sale);
    }

    public void deleteSaleById(Long id) {
        saleRepository.deleteById(id);
    }

    public Sale updateSale(Long id, Sale sale) {
        if (saleRepository.existsById(id)) {
            sale.setId(id);
            return saleRepository.save(sale);
        }
        return null;
    }
}