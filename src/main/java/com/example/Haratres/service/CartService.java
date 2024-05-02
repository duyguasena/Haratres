package com.example.Haratres.service;

import com.example.Haratres.dto.CartResponse;
import com.example.Haratres.model.Cart;

public interface CartService {
    CartResponse createCart(String token);

}
