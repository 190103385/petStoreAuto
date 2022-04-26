package com.example.petstore.services;

import com.example.petstore.entities.User;
import com.example.petstore.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
}
