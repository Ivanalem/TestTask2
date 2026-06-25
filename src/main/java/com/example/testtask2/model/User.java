package com.example.testtask2.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotBlank
    @Column(nullable = false)
    String userName;

    @NotBlank
    @Column(nullable = false)
    String password;

    @Email
    @NotBlank
    String email;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Order> order = new ArrayList<>();
}
