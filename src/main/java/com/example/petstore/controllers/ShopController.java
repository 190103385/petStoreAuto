package com.example.petstore.controllers;

import com.example.petstore.entities.Product;
import com.example.petstore.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class ShopController {
    @Autowired
    ProductService productService;

    @GetMapping("/shop.html")
    public String shop(Model model){
        model.addAttribute("products", productService.getAll());
        return "shop";
    }

    @GetMapping("/single-product.html/{product_id}")
    public String getSingleProduct(@PathVariable Integer product_id, Model model){
        Optional<Product> product = productService.getById(product_id);
        model.addAttribute("product", product);
        return "single-product";
    }
}

