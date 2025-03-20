package com.pm.smallbusinessmanagement.repository;

import com.pm.smallbusinessmanagement.model.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> {
    List<Document> findByFileName(String fileName);
}
