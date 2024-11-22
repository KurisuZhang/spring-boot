package com.example.order.service;

import com.example.order.model.Order;

public interface OrderService {
    Order createOrder();
    Order getOrder(Long id);
}
