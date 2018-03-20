package com.codecool.enterprise.orderservice.service;

import com.codecool.enterprise.orderservice.model.Order;
import com.codecool.enterprise.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService{

    @Autowired
    public OrderRepository orderRepository;

    public void save(Order entity) {
        orderRepository.save(entity);
    }

    public List<Order> getProductIds(Long userId) {
        return orderRepository.findAllByUserId(userId);
    }
}
