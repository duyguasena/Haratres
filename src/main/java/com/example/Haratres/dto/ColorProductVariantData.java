package com.example.Haratres.dto;

import com.example.Haratres.model.ColorProductVariant;
import com.example.Haratres.model.SizeProductVariant;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ColorProductVariantData extends ColorProductVariant {
    private  String color;
    List<SizeProductVariant> productSize = new ArrayList<>();
}
