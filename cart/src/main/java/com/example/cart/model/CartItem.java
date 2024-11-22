package com.example.cart.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "`cart`")
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String product;
    private Integer quantity;

    // Constructors, Getters, and Setters
}
