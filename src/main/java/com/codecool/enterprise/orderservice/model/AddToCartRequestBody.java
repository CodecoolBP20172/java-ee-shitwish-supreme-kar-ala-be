package com.codecool.enterprise.orderservice.model;

public class AddToCartRequestBody {

    private long userId;
    private long productId;

    public long getUserId() {
        return userId;
    }

    public long getProductId() {
        return productId;
    }
}
