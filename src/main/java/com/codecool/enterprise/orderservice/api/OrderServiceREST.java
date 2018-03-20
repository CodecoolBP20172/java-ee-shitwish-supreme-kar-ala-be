package com.codecool.enterprise.orderservice.api;

import com.codecool.enterprise.orderservice.model.AddToCartRequestBody;
import com.codecool.enterprise.orderservice.model.Order;
import com.codecool.enterprise.orderservice.service.OrderService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class OrderServiceREST {

    @Autowired
    OrderService orderService;

    @GetMapping("/")
    public String getIndex() {
        return "welcome to ShitWish OrderService";
    }

    @RequestMapping(value = "/add-to-cart", method = RequestMethod.POST)
    public ResponseEntity<String> addToCart(@RequestBody AddToCartRequestBody requestBody) {
        long userId = requestBody.getUserId();
        long productId = requestBody.getProductId();

        if (orderService.addToUsersOrder(userId, productId)) {
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).build();
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
}
