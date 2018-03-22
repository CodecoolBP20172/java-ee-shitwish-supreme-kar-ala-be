package com.codecool.enterprise.orderservice.api;

import com.codecool.enterprise.orderservice.model.Order;
import com.codecool.enterprise.orderservice.service.OrderService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class OrderServiceREST {

    @Autowired
    OrderService orderService;

    @GetMapping("/")
    public String getIndex() {
        return "welcome to ShitWish OrderService";
    }

    @RequestMapping(value = "/add-to-cart", method = RequestMethod.POST)
    public ResponseEntity<String> addToCart(@RequestBody Map<String, Long> requestBody) {

        long userId = requestBody.get("userId");
        long productId = requestBody.get("productId");

        if (orderService.addToUsersOrder(userId, productId)) {
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @GetMapping("/get-cart/{userId}")
    public JSONObject getCart(@PathVariable("userId") Long userId) {

        List<Long> productIds = new ArrayList<>();

        for (Order order : orderService.findAllByUserId(userId)) {
            productIds.add(order.getProductId());
        }

        JSONObject object = new JSONObject();

        object.put("productIdList", productIds);

        return object;
    }

    @RequestMapping(value = "/post-buy/{userId}", method = RequestMethod.POST)
    public ResponseEntity<Object> postBuy(@PathVariable("userId") Long userId) {

        Order order = orderService.findOrder(userId);
        orderService.deleteOrder(order);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @RequestMapping(value = "/remove-product/{productId}", method = RequestMethod.POST)
    public ResponseEntity<Object> removeProduct(@PathVariable("productId") Long productId) {

        Order order = orderService.findOrderByProductId(productId);
        if (order == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        orderService.deleteOrder(order);
        System.out.println("Deleted order: " + order);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
