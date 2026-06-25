package com.example.testtask2.model;

import jakarta.persistence.*;

@Entity
@Table(name = "order_item")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    Order order;

    @Column(name = "Item_name", nullable = false)
    private String itemName;

    @Column(name = "item_price", nullable = false)
    private Long itemPrice;

    @Column(name = "quantity",nullable = false)
    private Integer itemQuantity;

    @Column(name = "subtotal", nullable = false)
    private Long subtotal;
}
