package com.pm.smallbusinessmanagement.service;


import com.pm.smallbusinessmanagement.model.Sale;
import com.pm.smallbusinessmanagement.model.SalesMetrics;
import com.pm.smallbusinessmanagement.repository.SaleRepository;
import com.pm.smallbusinessmanagement.repository.SalesMetricsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SalesMetricsService {

    private final SalesMetricsRepository salesMetricsRepository;
    private final SaleRepository saleRepository;


    public SalesMetrics calculateAndSaveMetrics(LocalDateTime startDate, LocalDateTime endDate) {

        List<Sale> sales = saleRepository.findBySaleDateBetween(startDate, endDate);


        Long totalSalesCount = (long) sales.size();
        Double totalSalesAmount = sales.stream().mapToDouble(Sale::getTotalAmount).sum();
        Double averageSaleAmount = totalSalesAmount / totalSalesCount;
        Double totalIncome = totalSalesAmount;
        Double totalExpenses = 0.0;

        SalesMetrics salesMetrics = new SalesMetrics();
        salesMetrics.setTotalSalesCount(totalSalesCount);
        salesMetrics.setTotalSalesAmount(totalSalesAmount);
        salesMetrics.setAverageSaleAmount(averageSaleAmount);
        salesMetrics.setTotalIncome(totalIncome);
        salesMetrics.setTotalExpenses(totalExpenses);
        salesMetrics.setStartDate(startDate);
        salesMetrics.setEndDate(endDate);

        return salesMetricsRepository.save(salesMetrics);
    }

    public List<SalesMetrics> getMetricsByPeriod(LocalDateTime startDate, LocalDateTime endDate) {
        return salesMetricsRepository.findByStartDateBetween(startDate, endDate);
    }
}
