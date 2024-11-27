package com.example.cart.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Order {
    private Long id;
    private String status;
}

