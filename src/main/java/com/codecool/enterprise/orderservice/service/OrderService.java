package com.codecool.enterprise.orderservice.service;

import com.codecool.enterprise.orderservice.model.Order;
import com.codecool.enterprise.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService{

    @Autowired
    public OrderRepository orderRepository;

    public boolean add(long userId, long productId) {
        Order order = new Order(userId, productId);
        List<Order> orderDetails = findAllByUserId(userId);

        List<Order> productsByUser = orderDetails.stream()
                .filter(orderLine -> (productId == orderLine.getProductId()))
                .collect(Collectors.toList());

        System.out.println(String.format("user %s order details: ", userId) + orderDetails);
        System.out.println(String.format("product %s in user %s order details: ", productId, userId) + productsByUser);

        // check if user already has that product in their order
        if (productsByUser.isEmpty()) {
            orderRepository.save(order);
            System.out.println(String.format("saved user %s's order to order table", userId));
            return true;
        }
        System.out.println(String.format("product %s already in user %s's orders!", productId, userId));
        return false;
    }

    public List<Order> findAllByUserId(long userId) {
        return orderRepository.findAllByUserId(userId);
    }
}
