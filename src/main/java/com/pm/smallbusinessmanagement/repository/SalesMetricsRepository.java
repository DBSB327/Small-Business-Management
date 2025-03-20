package com.pm.smallbusinessmanagement.repository;

import com.pm.smallbusinessmanagement.model.SalesMetrics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface SalesMetricsRepository extends JpaRepository<SalesMetrics, Long> {
    List<SalesMetrics> findByStartDateBetween(LocalDateTime startDate, LocalDateTime endDate);
}
