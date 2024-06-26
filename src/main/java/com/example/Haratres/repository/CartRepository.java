package com.example.Haratres.repository;

import com.example.Haratres.model.Cart;
import com.example.Haratres.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart,Long> {
    Cart findByUser(User user);

    Optional<Cart> findByCode(String cartId);
}
