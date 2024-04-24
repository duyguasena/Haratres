package com.example.Haratres.controller;

import com.example.Haratres.dto.ProductRequest;
import com.example.Haratres.dto.ProductResponse;
import com.example.Haratres.model.Product;
import com.example.Haratres.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;
    @Secured("ROLE_ADMIN")
    @PostMapping
    public ResponseEntity<Long> addProduct(@RequestBody ProductRequest productRequest){
        Long productId=productService.addProduct(productRequest);
        return new ResponseEntity<>(productId, HttpStatus.OK);
    }
    @Secured("ROLE_ADMIN")
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProduct(@PathVariable ("id") Long productId){
        ProductResponse response=productService.getProductById(productId);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @Secured("ROLE_ADMIN")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
        if (!productService.existsById(id)) {
            return new ResponseEntity<>("ID not found", HttpStatus.NOT_FOUND);
        }
        productService.deleteProductById(id);
        return new ResponseEntity<>("The product has been deleted",HttpStatus.OK);
    }
    @Secured("ROLE_ADMIN")
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody ProductRequest productRequest) {
        return productService.updateProduct(id,productRequest);

    }
}
