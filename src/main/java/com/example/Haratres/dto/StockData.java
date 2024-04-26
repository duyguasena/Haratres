package com.example.Haratres.dto;

import com.example.Haratres.model.Stock;
import lombok.Data;

@Data
public class StockData extends Stock {
    private String productCode;
    private int stockQuantity;
}
