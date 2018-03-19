package com.codecool.enterprise.orderservice.model;

import javax.persistence.*;

@Entity
@Table(name = "todo")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private long userId;
    private long productId;

}
