package com.example.testtask2.model;

import jakarta.persistence.*;

@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false, unique = true)
    private Order order;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PaymentStatus status = PaymentStatus.PENDING;

    @Column(name = "payment_token")
    private String paymentToken;

    public enum PaymentStatus {
        PENDING, // Ожидает
        SUCCESS , //Успешно
        FAILED //Ошибка платежа
    }


}
