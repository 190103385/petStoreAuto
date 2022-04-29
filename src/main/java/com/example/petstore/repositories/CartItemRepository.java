package com.example.petstore.repositories;

import com.example.petstore.entities.CartItem;
import com.example.petstore.entities.Product;
import com.example.petstore.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem, Integer> {
    List<CartItem> findByUser(User user);

    CartItem findByUserAndProduct(User user, Product product);

    @Query(value = "SELECT max(cart_item_id) FROM cart_item", nativeQuery = true)
    Integer getMaxId();

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM cart_item WHERE user_id = :user_id", nativeQuery = true)
    void clearCartByUserId(
            @Param("user_id") Integer status);
}
