package com.example.petstore.controllers;

import com.example.petstore.entities.CartItem;
import com.example.petstore.entities.User;
import com.example.petstore.services.ShoppingCartService;
import com.example.petstore.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ShoppingCartController {
    @Autowired
    private ShoppingCartService cartService;

    @Autowired
    private UserService userService;

    @GetMapping("/cart.html")
    public String showShoppingCart(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.getCurrentlyLoggedInUser(authentication);

        List<CartItem> cartItems = cartService.listCartItems(user);

        model.addAttribute("cartItems", cartItems);

        return "cart";
    }

    @PostMapping("/cart.html/addItem/{pid}/{qty}")
    public String addItemToCart(@PathVariable("pid") Integer productId,
                              @PathVariable("qty") Integer quantity) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if(authentication == null || authentication instanceof AnonymousAuthenticationToken) return null;

        User user = userService.getCurrentlyLoggedInUser(authentication);

        if(user == null) return "";

        Integer addedQty = cartService.addItemToCart(productId, quantity, user);

        return addedQty + " item(s) added!";
    }
}
