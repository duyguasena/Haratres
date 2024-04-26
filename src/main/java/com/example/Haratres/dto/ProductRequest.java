package com.example.Haratres.dto;

import com.example.Haratres.model.ColorProductVariant;
import com.example.Haratres.model.SizeProductVariant;
import com.example.Haratres.model.Stock;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class ProductRequest {
    private String productName;
    private double price;
    private ColorProductVariant productColor;
    private SizeProductVariant productSize;
    private Stock stock;
}
