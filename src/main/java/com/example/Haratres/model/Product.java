package com.example.Haratres.model;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name="products")
@Data
@RequiredArgsConstructor
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String productName;
    private double price;

    public Product(Long id, String productName, double price) {
        this.id = id;
        this.productName = productName;
        this.price = price;
    }
}
