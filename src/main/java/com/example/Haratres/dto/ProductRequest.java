package com.example.Haratres.dto;

import com.example.Haratres.model.ColorProductVariant;
import com.example.Haratres.model.SizeProductVariant;
import com.example.Haratres.model.Stock;
import lombok.*;

import javax.persistence.Column;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductRequest {
    private String productName;
    private double price;
    private String colorVariantCode;
    private String color;
    private ColorProductVariant productColor;
    private SizeProductVariant productSize;//Liste haline getir
    private Stock stock;

}
