package com.example.Haratres.controller;

import com.example.Haratres.dto.CartEntryRequest;
import com.example.Haratres.dto.CartEntryResponse;
import com.example.Haratres.dto.CartResponse;
import com.example.Haratres.model.Cart;
import com.example.Haratres.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth/carts")
public class CartController {
    @Autowired
    private CartService cartService;
    @Secured("ROLE_CUSTOMER")
    @PostMapping
    public CartResponse createCart(String token) {
        return cartService.createCart(token);
    }

    @Secured("ROLE_CUSTOMER")
    @PostMapping("/{cartId}")
    public ResponseEntity<CartEntryResponse> createCartEntry(@PathVariable String cartId, @RequestBody CartEntryRequest cartEntryRequest) {
        return cartService.createCartEntry(cartId,cartEntryRequest);
    }
}
