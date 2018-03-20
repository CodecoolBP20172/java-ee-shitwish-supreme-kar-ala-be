package com.codecool.enterprise.orderservice.model;

import javax.persistence.*;

@Entity
@Table(name = "`ORDER`")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long userId;
    private long productId;

    public Order() {
    }

    public Order(long userId, long productId) {
        this.userId = userId;
        this.productId = productId;
    }
}
