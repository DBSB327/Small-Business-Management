package com.pm.smallbusinessmanagement.service;

import com.pm.smallbusinessmanagement.model.Document;
import com.pm.smallbusinessmanagement.model.User;
import com.pm.smallbusinessmanagement.repository.DocumentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DocumentService {

    private final DocumentRepository documentRepository;
    private final String uploadDir = "uploads/";

    public void uploadFile(MultipartFile file) throws IOException {

        Path path = Paths.get(uploadDir + file.getOriginalFilename());
        Files.createDirectories(path.getParent());
        Files.write(path, file.getBytes());

        Document metadata = new Document();
        metadata.setFileName(file.getOriginalFilename());
        metadata.setFilePath(path.toString());
        metadata.setFileSize(file.getSize());
        metadata.setUploadedAt(LocalDateTime.now());
        documentRepository.save(metadata);
    }

    public List<Document> getAllDocuments() {
        return documentRepository.findAll();
    }

    public List<Document> findDocumentByFileName(String fileName) {
        return documentRepository.findByFileName(fileName);
    }

    public void deleteDocument(Long documentId) {
        documentRepository.deleteById(documentId);
    }
}

