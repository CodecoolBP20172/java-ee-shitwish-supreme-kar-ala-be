package com.codecool.enterprise.orderservice.model;

import javax.persistence.*;

@Entity
@Table(name = "`ORDER`")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long userId;

    @OneToOne(cascade = CascadeType.ALL)
    OrderDetails orderDetails;

    public Order(long userId) {
        this.userId = userId;
    }
}
