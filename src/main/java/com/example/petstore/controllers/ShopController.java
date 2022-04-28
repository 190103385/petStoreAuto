package com.example.petstore.controllers;

import com.example.petstore.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShopController {
    @Autowired
    ProductService productService;

    @GetMapping("/shop.html")
    public String shop(Model model){
        model.addAttribute("products", productService.getAll());
        return "shop";
    }
}

