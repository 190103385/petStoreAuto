package com.example.petstore.controllers;

import com.example.petstore.entities.User;
import com.example.petstore.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/admin/users")
    public String getAll(Model model){
        List<User> users = userService.getAll();
        model.addAttribute("users", users);
        return "admin";
    }

    @GetMapping("/admin/users/add")
    public String addUsers(){
        return "addUsers";
    }

    @PostMapping("/admin/users")
    public String save(User user){
        userService.save(user);
        return "redirect:/admin/users";
    }

}
