package com.example.Haratres.service;

import com.example.Haratres.dto.ProductRequest;
import com.example.Haratres.dto.ProductResponse;
import com.example.Haratres.model.Product;

public interface ProductService {
    Product addProduct(ProductRequest productRequest);
    ProductResponse getProductById(Long productId);
    void deleteProductById(Long id);
    Product updateProduct(Long id, ProductRequest productRequest);

    boolean existsById(Long id);
}
