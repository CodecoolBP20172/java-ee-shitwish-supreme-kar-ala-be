package com.codecool.enterprise.orderservice.api;

import com.codecool.enterprise.orderservice.model.Order;
import com.codecool.enterprise.orderservice.service.OrderService;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class OrderServiceREST {

    OrderService orderservice;

    public OrderServiceREST(OrderService orderService) {
        this.orderservice = orderService;
    }

    @GetMapping("/")
    public String getIndex() {
        return "welcome to ShitWish OrderService";
    }

    @GetMapping("/get-cart/{userId}")
    public JSONObject getCart(@PathVariable("userId") Long userId) {

        List<Long> productIds = new ArrayList<>();

        for (Order order : orderservice.getProductIds(userId)) {
            productIds.add(order.getProductId());
        }

        JSONObject object = new JSONObject();

        object.put("productIdList", productIds);

        return object;
    }

}
