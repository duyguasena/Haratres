package com.example.Haratres.dto;

import com.example.Haratres.model.SizeProductVariant;
import lombok.Data;

@Data
public class CartEntryRequest {
    private String sizeVariantCode;
    private int quantity;
}
