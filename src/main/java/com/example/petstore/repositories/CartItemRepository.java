package com.example.petstore.repositories;

import com.example.petstore.entities.CartItem;
import com.example.petstore.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem, Integer> {
    public List<CartItem> findByUser(User user);
}
