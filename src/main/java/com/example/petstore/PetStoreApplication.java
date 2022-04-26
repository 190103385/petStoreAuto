package com.example.petstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication()
@EntityScan("com.example.petstore.entities")
@EnableJpaRepositories(basePackages = {"com.example.petstore.repositories"})
//@ComponentScan("com.example.petstore.repositories")
public class PetStoreApplication{
    public static void main(String[] args) {
        SpringApplication.run(PetStoreApplication.class, args);
    }
}