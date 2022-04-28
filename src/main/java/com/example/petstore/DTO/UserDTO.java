package com.example.petstore.DTO;

import com.sun.istack.NotNull;
import lombok.Data;

@Data
public class UserDTO{
    @NotNull
    private Integer user_id;
    @NotNull
    private String user_password;
    @NotNull
    private String username;
    @NotNull
    private String address;
    @NotNull
    private String city;
    @NotNull
    private String country;
    @NotNull
    private String email;
    @NotNull
    private String full_name;
    @NotNull
    private String phone_number;
}
