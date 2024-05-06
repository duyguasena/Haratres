package com.example.Haratres.service.imp;

import com.example.Haratres.dto.CartEntryRequest;
import com.example.Haratres.dto.CartEntryResponse;
import com.example.Haratres.dto.CartResponse;
import com.example.Haratres.exception.CartCreationException;
import com.example.Haratres.model.*;
import com.example.Haratres.repository.CartEntryRepository;
import com.example.Haratres.repository.CartRepository;
import com.example.Haratres.repository.SizeProductRepository;
import com.example.Haratres.service.CartService;
import com.example.Haratres.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class CartImpl implements CartService {
    @Autowired
    private UserService userService;
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private SizeProductRepository sizeProductRepository;
    @Autowired
    private CartEntryRepository cartEntryRepository;

    private static final Logger logger = LoggerFactory.getLogger(CartImpl.class);



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
            logger.error("Error create cart: {}", e.getMessage());
            throw new CartCreationException("Failed to create new cart");
        }
}
    @Override
    public ResponseEntity<CartEntryResponse> createCartEntry(String cartId, CartEntryRequest cartEntryRequest) {
        //Verilen code ile cart'ı veritabanından buldum
        Optional<Cart> optionalCart = cartRepository.findByCode(cartId);
        if (optionalCart.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        // Sepet nesnesini aldım
        Cart cart = optionalCart.get();

        // Beden konuna göre ürünün olup olmadığını kontrol ettim
        Optional<SizeProductVariant> optionalProduct = sizeProductRepository.findBySizeVariantCode(cartEntryRequest.getSizeVariantCode());
        if (optionalProduct.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        SizeProductVariant sizeProductVariant = optionalProduct.get();

        //Mevcut stoğu kontrol ettim
        int availableStock = sizeProductVariant.getStock().getStockQuantity();
        if (availableStock < cartEntryRequest.getQuantity()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        CartEntry cartEntry = new CartEntry();
        cartEntry.setQuantity(cartEntryRequest.getQuantity());
        cartEntry.setSizeProductVariant(sizeProductVariant);



        // Sepetin içindekileri db ye kaydettim
        try {
            cartEntry = cartEntryRepository.save(cartEntry);
        } catch (DataAccessException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        //Carta cartentry yi setledim
        List<CartEntry> cartEntries = cart.getCartEntries();
        cartEntries.add(cartEntry);
        cart.setCartEntries(cartEntries);

        // Sepet nesnesini db ye kaydettim
        try {
            cart = cartRepository.save(cart);
        } catch (DataAccessException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        CartEntryResponse cartEntryResponse=new CartEntryResponse();
        cartEntryResponse.setId(cart.getId());
        cartEntryResponse.setCreationTime(cart.getCreationTime());
        cartEntryResponse.setCartEntries(cart.getCartEntries());
        return ResponseEntity.ok(cartEntryResponse);
    }
}






