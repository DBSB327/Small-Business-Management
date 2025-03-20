package com.pm.smallbusinessmanagement.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Double price;
    private Integer stock;
    @ManyToMany(mappedBy = "products")
    private List<Sale> sales;
    @ManyToOne
    @JoinColumn(name = "warehouse_id")
    private Warehouse warehouse;
}