package com.codecool.enterprise.orderservice.api;

import com.codecool.enterprise.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderServiceREST {
    @Autowired
    private OrderService orderService;


    @GetMapping("/")
    public String getIndex() {
        return "welcome to ShitWish OrderService";
    }

    @RequestMapping(value = "/remove-product",method = RequestMethod.POST)
    public ResponseEntity<String> removeProduct(@RequestParam("productId") String productId){
        orderService.removeProduct(Long.parseLong(productId));
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
