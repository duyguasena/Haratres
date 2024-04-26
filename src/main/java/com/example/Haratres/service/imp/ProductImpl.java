package com.example.Haratres.service.imp;

import com.example.Haratres.dto.ProductRequest;
import com.example.Haratres.dto.ProductResponse;
import com.example.Haratres.model.ColorProductVariant;
import com.example.Haratres.model.SizeProductVariant;
import com.example.Haratres.model.Stock;
import com.example.Haratres.repository.ColorProductRepository;
import com.example.Haratres.repository.SizeProductRepository;
import com.example.Haratres.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductImpl implements ProductService {
    @Autowired
    private ColorProductRepository colorProductRepository;
    @Autowired
    private SizeProductRepository sizeProductRepository;

@Override
public ColorProductVariant addProduct(ProductRequest productRequest) {
    SizeProductVariant sizeProduct= new SizeProductVariant();
    sizeProduct.setSizeCode(productRequest.getProductSize().getSizeCode());
    sizeProduct.setSize(productRequest.getProductSize().getSize());
    ColorProductVariant colorProduct=new ColorProductVariant();
    colorProduct.setColor(productRequest.getProductColor().getColor());
    colorProduct.setProductName(productRequest.getProductName());
    colorProduct.setPrice(productRequest.getPrice());
    sizeProduct.setColorProductVariant(colorProduct);
    Stock stockProduct=new Stock();
    stockProduct.setStockQuantity(productRequest.getStock().getStockQuantity());
    stockProduct.setProductCode(productRequest.getStock().getProductCode());
    colorProductRepository.save(colorProduct);
    sizeProductRepository.save(sizeProduct);
    return colorProduct;
}
    @Override
    public ProductResponse getProductById(Long id) {
        ColorProductVariant product=colorProductRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Product not found"));
        ProductResponse productResponse=new ProductResponse();
        productResponse.setProductName(productResponse.getProductName());
        productResponse.setPrice(productResponse.getPrice());
        productResponse.setProductColor(productResponse.getProductColor());
        productResponse.setProductSize(productResponse.getProductSize());
        productResponse.setStock(productResponse.getStock());
        return productResponse;
    }
    @Override
    public void  deleteProductById(Long id) {
        colorProductRepository.deleteById(id);
    }
    @Override
    public ColorProductVariant updateProduct(Long id, ProductRequest productRequest) {
        ColorProductVariant realProduct=colorProductRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Id bulunamadı"));
        realProduct.setProductName(productRequest.getProductName());
        realProduct.setPrice(productRequest.getPrice());
        colorProductRepository.save(realProduct);
        return realProduct;
    }

    @Override
    public boolean existsById(Long id) {
        return colorProductRepository.existsById(id);
    }
}
