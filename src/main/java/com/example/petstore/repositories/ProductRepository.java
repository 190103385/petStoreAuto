package com.example.petstore.repositories;

import com.example.petstore.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    //    Product findByProduct_id(Integer product_id);
}
