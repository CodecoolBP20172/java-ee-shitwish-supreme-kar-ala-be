package com.codecool.enterprise.orderservice.model;

import javax.persistence.*;

@Entity
@Table(name = "ORDERDETAILS")
public class OrderDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long productId;

    @OneToOne(cascade = CascadeType.ALL)
    Order order;
}
