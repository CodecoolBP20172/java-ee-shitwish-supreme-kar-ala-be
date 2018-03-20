package com.codecool.enterprise.orderservice.model;

import org.hibernate.engine.internal.Cascade;

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

    public long getProductId() {
        return productId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", userId=" + userId +
                ", productId=" + productId +
                '}';
    }
}
