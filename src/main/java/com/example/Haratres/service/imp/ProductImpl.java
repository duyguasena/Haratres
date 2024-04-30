package com.example.Haratres.service.imp;

import com.example.Haratres.dto.ProductRequest;
import com.example.Haratres.dto.ProductResponse;
import com.example.Haratres.exception.ProductNotFoundException;
import com.example.Haratres.model.ColorProductVariant;
import com.example.Haratres.model.SizeProductVariant;
import com.example.Haratres.model.Stock;
import com.example.Haratres.repository.ColorProductRepository;
import com.example.Haratres.repository.SizeProductRepository;
import com.example.Haratres.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;


@Service
public class ProductImpl implements ProductService {
    @Autowired
    private ColorProductRepository colorProductRepository;
    @Autowired
    private SizeProductRepository sizeProductRepository;
@Override
public ColorProductVariant addProduct(ProductRequest productRequest) {
    ColorProductVariant colorProduct = new ColorProductVariant();
    colorProduct.setColor(productRequest.getColor());
    colorProduct.setProductName(productRequest.getProductName());
    colorProduct.setPrice(productRequest.getPrice());
    colorProduct.setColorVariantCode(productRequest.getColorVariantCode());
    List<SizeProductVariant> sizeProductVariants=new ArrayList<>();
    final Logger logger = LoggerFactory.getLogger(this.getClass());
    for(SizeProductVariant size : productRequest.getProductSize()) {
        SizeProductVariant sizeProduct = new SizeProductVariant();
        sizeProduct.setSizeCode(size.getSizeCode());
        sizeProduct.setSize(size.getSize());
        sizeProduct.setSizeVariantCode(size.getSizeVariantCode());
        size.setColorProductVariant(colorProduct);
        try {
            sizeProductRepository.save(sizeProduct);
            sizeProductVariants.add(sizeProduct);
        } catch (Exception e) {
            logger.error("Error saving size product variant:  {}", e.getMessage());
        }
    }
    colorProduct.setSizeProductVariants(sizeProductVariants);
    Stock stockProduct = new Stock();
    stockProduct.setStockQuantity(productRequest.getStock().getStockQuantity());
    try {
        colorProductRepository.save(colorProduct);
    } catch (Exception e) {
        logger.error("Error saving color product variant: {}", e.getMessage());
    }
    return colorProduct;
}
    @Override
    public ColorProductVariant getProductById(Long id) {
        ColorProductVariant colorProduct=colorProductRepository.findById(id)
                .orElseThrow(()->new ProductNotFoundException("Product not found"));
        ProductResponse productResponse=new ProductResponse();
        productResponse.setProductName(productResponse.getProductName());
        productResponse.setPrice(productResponse.getPrice());
        productResponse.setProductColor(productResponse.getProductColor());
        productResponse.setProductSize(productResponse.getProductSize());
        productResponse.setStock(productResponse.getStock());
        return colorProduct;
    }
    @Override
    public void deleteProductById(Long id) {
        final Logger logger = LoggerFactory.getLogger(this.getClass());
        try {
            ColorProductVariant product = colorProductRepository.findById(id)
                    .orElseThrow(() -> new ProductNotFoundException("Product not found with ID: " + id));
            colorProductRepository.deleteById(id);
        } catch (ProductNotFoundException e) {
            logger.error("Error deleting product: {}", e.getMessage());
        }
    }
    @Override
    public ColorProductVariant updateProduct(Long id, ProductRequest productRequest) {
        final Logger logger = LoggerFactory.getLogger(this.getClass());
        try {
            ColorProductVariant realProduct = colorProductRepository.findById(id)
                    .orElseThrow(() -> new ProductNotFoundException("Product not found with ID: " + id));
            realProduct.setProductName(productRequest.getProductName());
            realProduct.setPrice(productRequest.getPrice());
            realProduct.setColor(productRequest.getColor());
            realProduct.setColorVariantCode(productRequest.getColorVariantCode());
            colorProductRepository.save(realProduct);
            return realProduct;
        } catch (ProductNotFoundException e) {
            logger.error("Error updating product: {}", e.getMessage());
            throw e;
        }
    }

    @Override
    public boolean existsById(Long id) {
        return colorProductRepository.existsById(id);
    }

    @Override
    public List<ColorProductVariant> allProducts() {
        return colorProductRepository.findAll();
    }


}
