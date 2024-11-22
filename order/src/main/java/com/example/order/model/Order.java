package com.example.order.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "`order`")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String status;

    // Constructors, Getters, and Setters
}

