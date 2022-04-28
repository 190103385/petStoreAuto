package com.example.petstore.services;

import com.example.petstore.entities.CartItem;
import com.example.petstore.entities.Product;
import com.example.petstore.entities.User;
import com.example.petstore.repositories.CartItemRepository;
import com.example.petstore.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCartService {
    @Autowired
    private CartItemRepository cartRepo;

    @Autowired
    private ProductRepository productRepo;

    public List<CartItem> listCartItems(User user) {
        return cartRepo.findByUser(user);
    }

    public Integer addItemToCart(Integer product_id, Integer quantity, User user) {
        Integer addedQuantity = quantity;

        Product product = productRepo.findById(product_id).get();

        CartItem cartItem = cartRepo.findByUserAndProduct(user, product);

        if(cartItem != null) {
            addedQuantity = cartItem.getQuantity() + quantity;
            cartItem.setQuantity(addedQuantity);
        } else {
            cartItem = new CartItem();
            cartItem.setQuantity(quantity);
            cartItem.setUser(user);
            cartItem.setProduct(product);
        }

        cartRepo.save(cartItem);

        return addedQuantity;
    }
}
