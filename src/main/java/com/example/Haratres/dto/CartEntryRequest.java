package com.example.Haratres.dto;

import lombok.Data;

@Data
public class CartEntryRequest {
    private String sizeVariantCode;
    private int quantity;
}
