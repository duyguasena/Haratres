package com.example.Haratres.service.imp;

import com.example.Haratres.dto.ProductRequest;
import com.example.Haratres.dto.ProductResponse;
import com.example.Haratres.model.Product;
import com.example.Haratres.repository.ProductRepository;
import com.example.Haratres.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Override
    public Product addProduct(ProductRequest productRequest) {
        Product product=Product.builder()
                        .productName(productRequest.getProductName())
                                .price(productRequest.getPrice())
                                        .build();
        productRepository.save(product);
        return product;
    }
    @Override
    public ProductResponse getProductById(Long productId) {
        Product product=productRepository.findById(productId)
                .orElseThrow(()->new RuntimeException("Product not found"));
        ProductResponse productResponse=ProductResponse.builder()
                .productName(product.getProductName())
                .price(product.getPrice())
                .build();
        return productResponse;
    }
    @Override
    public void  deleteProductById(Long id) {
        productRepository.deleteById(id);
    }
    @Override
    public Product updateProduct(Long id, ProductRequest productRequest) {
        Product realProduct=productRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Id bulunamadı"));
        realProduct.setProductName(productRequest.getProductName());
        realProduct.setPrice(productRequest.getPrice());
        productRepository.save(realProduct);
        return realProduct;
    }

    @Override
    public boolean existsById(Long id) {
        return productRepository.existsById(id);
    }
}
