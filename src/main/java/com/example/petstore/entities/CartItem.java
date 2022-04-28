package com.example.petstore.entities;

import lombok.*;

import javax.persistence.*;

@Entity
public class CartItem {
    @Id
    @Column(name = "cart_item_id", nullable = false)
    @Getter @Setter private Integer cart_item_id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    @Getter @Setter private Product product;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @Getter @Setter private User user;

    @Getter @Setter private int quantity;
}
