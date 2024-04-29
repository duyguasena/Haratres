package com.example.Haratres.controller;

import com.example.Haratres.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth/{userId}/carts")
public class CartController {
    @Autowired
    private CartService cartService;
    @Secured("ROLE_CUSTOMER")
    @PostMapping
    public String createCart(@PathVariable String userId) {
        return cartService.createCart(userId);
    }
}
