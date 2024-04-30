package com.example.Haratres.service;

import com.example.Haratres.dto.ProductRequest;
import com.example.Haratres.model.ColorProductVariant;

import java.util.List;

public interface ProductService {
    ColorProductVariant addProduct(ProductRequest productRequest);

    ColorProductVariant getProductById(Long id);

    ColorProductVariant deleteProductById(Long id);
    ColorProductVariant updateProduct(Long id, ProductRequest productRequest);

    boolean existsById(Long id);

    List<ColorProductVariant> allProducts();
}
