package com.codecool.enterprise.orderservice.repository;

import com.codecool.enterprise.orderservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> deleteOrderByProductId(Order order);

    Order findByProductId(Long productId);

}
