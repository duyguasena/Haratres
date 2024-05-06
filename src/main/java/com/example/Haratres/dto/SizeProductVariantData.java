package com.example.Haratres.dto;

import com.example.Haratres.model.SizeProductVariant;
import com.example.Haratres.model.Stock;
import lombok.Data;

import java.util.List;

@Data
public class SizeProductVariantData {
    private String size;
    private String productSize;
    private Stock stock;


}
