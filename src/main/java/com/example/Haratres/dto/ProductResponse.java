package com.example.Haratres.dto;

import com.example.Haratres.model.ColorProductVariant;
import com.example.Haratres.model.SizeProductVariant;
import com.example.Haratres.model.Stock;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductResponse {
    private String productName;
    private double price;
    private String colorVariantCode;
    private String color;
    private ColorProductVariant productColor;
    private List<SizeProductVariant> productSize;
    private Stock stock;

}
