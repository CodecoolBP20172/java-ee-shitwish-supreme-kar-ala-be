package com.codecool.enterprise.orderservice.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderServiceREST {

    @GetMapping("/")
    public String getIndex() {
        return "welcome to ShitWish OrderService";
    }
}
