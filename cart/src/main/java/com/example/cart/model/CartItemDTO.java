package com.example.cart.model;

import lombok.Data;

@Data
public class CartItemDTO {
    private String product;
    private Integer quantity;

    // Constructors
    public CartItemDTO() {}

    public CartItemDTO(String product, Integer quantity) {
        this.product = product;
        this.quantity = quantity;
    }
}
