package com.example.petstore.services;

import com.example.petstore.entities.CartItem;
import com.example.petstore.entities.User;
import com.example.petstore.repositories.CartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCartService {
    @Autowired
    private CartItemRepository cartRepo;

    public List<CartItem> listCartItems(User user) {
        return cartRepo.findByUser(user);
    }
}
