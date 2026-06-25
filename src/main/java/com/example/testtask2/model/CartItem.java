package com.example.testtask2.model;

import jakarta.persistence.*;

@Entity
@Table(name = "cart_items", uniqueConstraints = {
        @UniqueConstraint(
                columnNames = {"user_id", "product_id"})})
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(nullable = false)
    private Integer quantity;

}
