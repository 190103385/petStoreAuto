package com.example.petstore.services;

import com.example.petstore.DTO.UserDTO;

public interface UserServiceCheck {
    void register(final UserDTO user) throws Exception;
    boolean checkIfUserExist(final String email);
}
