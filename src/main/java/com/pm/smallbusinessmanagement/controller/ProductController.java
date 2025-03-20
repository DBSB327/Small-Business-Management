package com.pm.smallbusinessmanagement.controller;


import com.pm.smallbusinessmanagement.model.Product;
import com.pm.smallbusinessmanagement.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/getAll")
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Optional<Product>> getProductById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @PostMapping("/add/{warehouseId}")
    public ResponseEntity<Product> addProduct(@RequestBody Product product, @PathVariable("warehouseId") Long warehouseId) {
        return ResponseEntity.ok(productService.createProduct(product, warehouseId));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") Long id, @RequestBody Product updatedProduct) {
        return ResponseEntity.ok(productService.updateProduct(id, updatedProduct));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") Long id) {
        productService.deleteProductById(id);
        return ResponseEntity.ok("Product deleted successfully");
    }

    @PutMapping("/updateWarehouse/{productId}/{warehouseId}")
    public ResponseEntity<Product> updateProductWarehouse(@PathVariable("productId") Long productId,
                                                          @PathVariable("warehouseId") Long warehouseId) {
        Product updatedProduct = productService.updateProductWarehouse(productId, warehouseId);
        return ResponseEntity.ok(updatedProduct);
    }
}
