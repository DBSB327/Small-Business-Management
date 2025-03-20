package com.pm.smallbusinessmanagement.controller;

import com.pm.smallbusinessmanagement.model.Warehouse;
import com.pm.smallbusinessmanagement.service.WarehouseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/warehouses")
@RequiredArgsConstructor
public class WarehouseController {

    private final WarehouseService warehouseService;

    @GetMapping("/getAll")
    public ResponseEntity<List<Warehouse>> getAllWarehouses() {
        return ResponseEntity.ok(warehouseService.getAllWarehouses());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Optional<Warehouse>> getWarehouseById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(warehouseService.getWarehouseById(id));
    }

    @PostMapping("/add")
    public ResponseEntity<Warehouse> addWarehouse(@RequestBody Warehouse warehouse) {
        return ResponseEntity.ok(warehouseService.createWarehouse(warehouse));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteWarehouse(@PathVariable("id") Long id) {
        warehouseService.deleteWarehouseById(id);
        return ResponseEntity.ok("Warehouse deleted successfully");
    }
}