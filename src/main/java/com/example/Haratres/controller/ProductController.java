package com.example.Haratres.controller;

import com.example.Haratres.dto.ProductRequest;
import com.example.Haratres.dto.ProductResponse;
import com.example.Haratres.model.ColorProductVariant;
import com.example.Haratres.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;
    @Secured("ROLE_ADMIN")
    @PostMapping
    public ResponseEntity<ColorProductVariant> addProduct(@RequestBody ProductRequest productRequest){
        ColorProductVariant newProduct=productService.addProduct(productRequest);
        return new ResponseEntity<>(newProduct, HttpStatus.OK);
    }
    @Secured("ROLE_CUSTOMER")
    @GetMapping("/{id}")
    public ResponseEntity<ColorProductVariant> getProduct(@PathVariable Long id){
        ColorProductVariant response=productService.getProductById(id);
        return new ResponseEntity<>(response,HttpStatus.OK);

    }
    @Secured("ROLE_CUSTOMER")
    @GetMapping()
    public List<ColorProductVariant> allProduct(){
        return productService.allProducts();
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
    public ColorProductVariant updateProduct(@PathVariable Long id, @RequestBody ProductRequest productRequest) {
        return productService.updateProduct(id,productRequest);

    }
}
