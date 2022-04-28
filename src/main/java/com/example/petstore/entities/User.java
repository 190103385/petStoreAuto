package com.example.petstore.entities;

import lombok.Data;

import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;
import static javax.persistence.GenerationType.SEQUENCE;

@Data
@Entity(name = "AppUser")
@Table(name = "users")
public class User {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(
            strategy = IDENTITY
    )
    private Long id;

    private String username;
    private String user_password;
    private String fullName;
    @Column(unique = true)
    private String email;
    private String phoneNumber;
    private String country;
    private String city;
    private String address;


    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles", joinColumns = @JoinColumn (name="user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    @OneToMany(mappedBy = "user", targetEntity = Order.class, cascade = CascadeType.ALL)
    private Set<Order> orders;

    @OneToMany(mappedBy = "user", targetEntity = Review.class, cascade = CascadeType.ALL)
    private Set<Review> reviews;
}
