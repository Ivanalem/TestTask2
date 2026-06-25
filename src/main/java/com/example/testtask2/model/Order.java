package com.example.testtask2.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "order_number", nullable = false, unique = true)
    private String orderNumber;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private OrderStatus status = OrderStatus.PENDING;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<OrderItem> items = new ArrayList<>();

    @OneToOne(mappedBy = "order", cascade = CascadeType.PERSIST)
    private Payment payment;

    //Статусы заказа
    public enum OrderStatus {
        PENDING,    // Ожидает оплаты
        PAID,       // Оплачен
        SHIPPED,    // Отправлен
        DELIVERED,  // Доставлен
        CANCELLED,  // Отменен
        FAILED      // Ошибка оплаты
    }

}
