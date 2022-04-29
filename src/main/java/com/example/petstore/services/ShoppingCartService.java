package com.example.petstore.services;

import com.example.petstore.entities.CartItem;
import com.example.petstore.entities.Product;
import com.example.petstore.entities.User;
import com.example.petstore.repositories.CartItemRepository;
import com.example.petstore.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCartService {
    @Autowired
    private CartItemRepository cartRepo;

    @Autowired
    private ProductRepository productRepo;

    @Autowired
    private UserService userService;

    public List<CartItem> listCartItems(User user) {
        return cartRepo.findByUser(user);
    }

    public void clearByUserId(Integer userId) {
        cartRepo.clearCartByUserId(userId);
    }

    public void save(User user, Product product, Integer quantity) {
        Integer maxId = cartRepo.getMaxId();
        CartItem cartItem = cartRepo.findByUserAndProduct(user, product);

        if(cartItem != null) {
            int newQuantity = cartItem.getQuantity() + 1;
            cartItem.setQuantity(newQuantity);
        }
        else {
            if(maxId == null) cartItem = new CartItem(1, product, user, quantity);
            else cartItem = new CartItem(maxId+1, product, user, quantity);
        }
        cartRepo.save(cartItem);
    }
}
