package com.example.Haratres.service.imp;

import com.example.Haratres.dto.CartResponse;
import com.example.Haratres.exception.CartCreationException;
import com.example.Haratres.model.Cart;
import com.example.Haratres.model.User;
import com.example.Haratres.repository.CartRepository;
import com.example.Haratres.service.CartService;
import com.example.Haratres.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Random;

@Service
public class CartImpl implements CartService {
    @Autowired
    private UserService userService;
    @Autowired
    private CartRepository cartRepository;
    Logger logger = LoggerFactory.getLogger(this.getClass());


    @Override
    public CartResponse createCart(String token) {
        try {
            User user = userService.getCurrentUser(); // Sessiondaki kullanıcıyı al
            Cart cart = cartRepository.findByUser(user); // Kullanıcıya ait sepeti bul
            if (cart != null) {  //Kart boş değilse olan kodu dön
                return new CartResponse(cart.getCode());
            } else {
                StringBuilder code = new StringBuilder();//Boşsa yeni kod oluştur
                Random random = new Random();
                for (int i = 0; i < 10; i++) {
                    code.append(random.nextInt(10));
                }
                Cart newCart = new Cart();
                newCart.setUser(user);
                newCart.setCode(code.toString());
                cartRepository.save(newCart);
                return new CartResponse(code.toString());
            }
        } catch (Exception e) {
            logger.error("Error updating address: {}", e.getMessage());
            throw new CartCreationException("Failed to create new cart");
        }
}
}
