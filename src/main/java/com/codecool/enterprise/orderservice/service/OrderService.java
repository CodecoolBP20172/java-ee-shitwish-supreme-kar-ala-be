package com.codecool.enterprise.orderservice.service;

import com.codecool.enterprise.orderservice.model.Order;
import com.codecool.enterprise.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService{

    @Autowired
    public OrderRepository orderRepository;

    public void removeProduct(Long productId){
        Order order = orderRepository.findByProductId(productId);
        orderRepository.delete(order);

    }

    public void save(Order entity){
        orderRepository.save(entity);
    }
}
