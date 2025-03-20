package com.pm.smallbusinessmanagement.controller;

import com.pm.smallbusinessmanagement.model.SalesMetrics;
import com.pm.smallbusinessmanagement.service.SalesMetricsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/metrics")
@RequiredArgsConstructor
public class SalesMetricsController {

    private final SalesMetricsService salesMetricsService;

    @GetMapping("/get")
    public ResponseEntity<List<SalesMetrics>> getMetricsByPeriod(
            @RequestParam("startDate") LocalDateTime startDate,
            @RequestParam("endDate") LocalDateTime endDate) {
        List<SalesMetrics> metrics = salesMetricsService.getMetricsByPeriod(startDate, endDate);
        return ResponseEntity.ok(metrics);
    }

    @PostMapping("/calculate")
    public ResponseEntity<SalesMetrics> calculateMetrics(
            @RequestParam("startDate") LocalDateTime startDate,
            @RequestParam("endDate") LocalDateTime endDate) {
        SalesMetrics salesMetrics = salesMetricsService.calculateAndSaveMetrics(startDate, endDate);
        return ResponseEntity.ok(salesMetrics);
    }
}