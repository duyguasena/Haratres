package com.example.Haratres.service.imp;

import com.example.Haratres.model.Cart;
import com.example.Haratres.service.CartService;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class CartImpl implements CartService {
    @Override
    public String createCart(String userId) {
        StringBuilder code = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            code.append(random.nextInt(10));
        }
        return code.toString();
    }
}
