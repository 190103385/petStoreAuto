package com.example.petstore.controllers;

import com.example.petstore.entities.CartItem;
import com.example.petstore.entities.Product;
import com.example.petstore.entities.User;
import com.example.petstore.repositories.CartItemRepository;
import com.example.petstore.services.ProductService;
import com.example.petstore.services.ShoppingCartService;
import com.example.petstore.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class ShoppingCartController {
    @Autowired
    private CartItemRepository cartRepo;

    @Autowired
    private ShoppingCartService cartService;

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    @GetMapping("/cart.html")
    public String showShoppingCart(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.getCurrentlyLoggedInUser(authentication);

        List<CartItem> cartItems = cartService.listCartItems(user);

        model.addAttribute("cartItems", cartItems);

        return "cart";
    }

    @GetMapping("/cart.html/addItem/{product_id}")
    public String addItemToCart(@PathVariable Integer product_id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.getCurrentlyLoggedInUser(authentication);

        Optional<Product> product = productService.getById(product_id);

        cartService.save(user, product.get(), 1);

        return "cart";
    }

    @GetMapping("/cart.html/clear")
    public String clearCart() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.getCurrentlyLoggedInUser(authentication);

        cartService.clearByUserId(user.getId());
        return "cart";
    }
}
