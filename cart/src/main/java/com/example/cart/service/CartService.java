package com.example.cart.service;

import com.example.cart.model.CartItem;

import java.util.List;

public interface CartService {
    CartItem addItem(CartItem item);
    CartItem getItem(Long id);
    List<CartItem> getAllItems();
    String checkout();
}
