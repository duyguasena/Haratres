package com.example.Haratres.service;

import com.example.Haratres.dto.CartEntryRequest;
import com.example.Haratres.dto.CartEntryResponse;
import com.example.Haratres.dto.CartResponse;
import org.springframework.http.ResponseEntity;

public interface CartService {
    CartResponse createCart(String token);

    ResponseEntity<CartEntryResponse> createCartEntry(String cartId, CartEntryRequest cartEntryRequest);


}
