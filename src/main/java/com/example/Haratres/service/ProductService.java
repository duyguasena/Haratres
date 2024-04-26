package com.example.Haratres.service;

import com.example.Haratres.dto.ProductRequest;
import com.example.Haratres.dto.ProductResponse;
import com.example.Haratres.model.ColorProductVariant;

public interface ProductService {
    ColorProductVariant addProduct(ProductRequest productRequest);

    ProductResponse getProductById(Long id);

    void deleteProductById(Long id);
    ColorProductVariant updateProduct(Long id, ProductRequest productRequest);

    boolean existsById(Long id);
}
