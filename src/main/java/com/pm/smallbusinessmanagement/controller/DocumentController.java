package com.pm.smallbusinessmanagement.controller;

import com.pm.smallbusinessmanagement.model.Document;
import com.pm.smallbusinessmanagement.service.DocumentService;
import com.pm.smallbusinessmanagement.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/documents")
@RequiredArgsConstructor
public class DocumentController {

    private final DocumentService documentService;

    //todo uploaded_by

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        documentService.uploadFile(file); ;
        return ResponseEntity.ok("File uploaded successfully");
    }

    @GetMapping
    public ResponseEntity<List<Document>> getAllDocuments() {
        return ResponseEntity.ok(documentService.getAllDocuments());
    }

    @GetMapping("/search")
    public ResponseEntity<List<Document>> searchDocuments(@RequestParam("fileName") String fileName) {
        return ResponseEntity.ok(documentService.findDocumentByFileName(fileName));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDocument(@PathVariable Long id) {
        documentService.deleteDocument(id);
        return ResponseEntity.ok("Документ удалён.");
    }
}