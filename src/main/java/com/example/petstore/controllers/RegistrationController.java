package com.example.petstore.controllers;

import com.example.petstore.DTO.UserDTO;
import com.example.petstore.services.UserServiceCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {
    @Autowired
    private UserServiceCheck userService;

    @GetMapping("/register")
    public String showRegistrationForm(Model model){
        UserDTO userDTO = new UserDTO();
        model.addAttribute("userDto", userDTO);
        return "register";
    }

    @PostMapping("/register")
    public String userRegistration(UserDTO userDto, final BindingResult bindingResult, final Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("userDto", userDto);
            return "register";
        }
        try{
            userService.register(userDto);
        } catch (Exception e) {
            bindingResult.rejectValue("email", "userDto.email", "An account already exists for this email");
            model.addAttribute("userDto", userDto);
            return "register";
        }
        return "redirect:index";
    }
}
