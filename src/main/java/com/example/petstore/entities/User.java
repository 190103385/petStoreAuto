package com.example.petstore.entities;

import lombok.*;

import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;
import static javax.persistence.GenerationType.SEQUENCE;

@Entity(name = "AppUser")
@Table(name = "users")
public class User {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(
            strategy = IDENTITY
    )
    private Long id;

    @Getter private String username;
    @Getter private String user_password;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles", joinColumns = @JoinColumn (name="user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    @Getter private Set<Role> roles = new HashSet<>();

    @OneToMany(mappedBy = "user", targetEntity = Order.class, cascade = CascadeType.ALL)
    private Set<Order> orders;

    @OneToMany(mappedBy = "user", targetEntity = Review.class, cascade = CascadeType.ALL)
    private Set<Review> reviews;
}
