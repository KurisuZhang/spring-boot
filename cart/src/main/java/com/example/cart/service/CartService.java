package com.example.cart.service;

import com.example.cart.model.CartItem;
import com.example.cart.model.CartItemDTO;

import java.util.List;

public interface CartService {
    CartItem addItem(CartItemDTO item);
    CartItem getItem(Long id);
    List<CartItem> getAllItems();
    String checkout();
}
