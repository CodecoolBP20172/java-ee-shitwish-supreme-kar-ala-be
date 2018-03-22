package com.codecool.enterprise.orderservice.service;

import com.codecool.enterprise.orderservice.model.Order;
import org.springframework.stereotype.Component;

//@Component
public class InitializerBean {

    public InitializerBean(OrderService orderService) {
        Order order1 = new Order(1,22222222);
        Order order2 = new Order(1,11111111);
        Order order3 = new Order(1,33333333);
        Order order4 = new Order(1,66666666);

        Order order5 = new Order(2,00);
        Order order6 = new Order(2,99);

        orderService.save(order1);
        orderService.save(order2);
        orderService.save(order3);
        orderService.save(order4);
        orderService.save(order5);
        orderService.save(order6);

    }
}
