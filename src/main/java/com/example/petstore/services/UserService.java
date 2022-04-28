package com.example.petstore.services;

import com.example.petstore.entities.User;
import com.example.petstore.repositories.UserRepository;
import com.example.petstore.security.AppUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<User> getAll(){
        return userRepository.findAll();
    }

    public void save(User user){
        userRepository.save(user);
    }

    public User getCurrentlyLoggedInUser(Authentication authentication) {
        if (authentication == null) return null;

        User user = null;
        Object principal = authentication.getPrincipal();

        if(principal instanceof AppUserDetails) {
            user = ((AppUserDetails) principal).getUser();
        }

        return user;
    }
}
