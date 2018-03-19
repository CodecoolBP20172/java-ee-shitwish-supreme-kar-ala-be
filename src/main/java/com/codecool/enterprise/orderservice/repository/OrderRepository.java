package com.codecool.enterprise.orderservice.repository;

import com.codecool.enterprise.orderservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
