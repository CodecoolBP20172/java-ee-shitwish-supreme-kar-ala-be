package com.codecool.enterprise.orderservice.service;

import com.codecool.enterprise.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService{

    @Autowired
    public OrderRepository orderRepository;
}
