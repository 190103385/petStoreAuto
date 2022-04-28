package com.example.petstore.services;

import com.example.petstore.DTO.UserDTO;
import com.example.petstore.entities.User;
import com.example.petstore.repositories.UserRepository;
import com.example.petstore.security.AppUserDetails;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserServiceCheck{
    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

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

    @Override
    public void register(UserDTO user) throws Exception {
        if(checkIfUserExist(user.getEmail())){
            throw new Exception("User already exists for this email");
        }
        User userEntity = new User();
        BeanUtils.copyProperties(user, userEntity);
        encodePassword(userEntity, user);
        userRepository.save(userEntity);
    }

    @Override
    public boolean checkIfUserExist(String email) {
        return userRepository.findByEmail(email) != null;
    }

    private void encodePassword(User userEntity, UserDTO user){
        userEntity.setUser_password(passwordEncoder.encode(user.getUser_password()));
    }
}
