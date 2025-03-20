package com.pm.smallbusinessmanagement.service;

import com.pm.smallbusinessmanagement.model.Report;
import com.pm.smallbusinessmanagement.repository.ReportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class ReportService {

    private final ReportRepository reportRepository;

    public List<Report> getAllReports() {
        return reportRepository.findAll();
    }

    public Optional<Report> getReportById(Long id) {
        return reportRepository.findById(id);
    }

    public Report createReport(Report report) {
        return reportRepository.save(report);
    }

    public void deleteReportById(Long id) {
        reportRepository.deleteById(id);
    }
}
