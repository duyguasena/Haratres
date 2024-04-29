package com.example.Haratres.dto;

import com.example.Haratres.model.SizeProductVariant;
import lombok.Data;

import java.util.List;

@Data
public class SizeProductVariantData extends SizeProductVariant {
    private String size;
    private String productSize;


}
