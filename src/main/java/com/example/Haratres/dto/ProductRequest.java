package com.example.Haratres.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class ProductRequest {
    private String productName;
    private double price;
}
