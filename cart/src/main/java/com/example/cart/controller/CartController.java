package com.example.cart.controller;

import com.example.cart.model.CartItem;
import com.example.cart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/add")
    public CartItem addItem(@RequestBody CartItem item) {
        return cartService.addItem(item);
    }

    @GetMapping("/{id}")
    public CartItem getItem(@PathVariable Long id) {
        return cartService.getItem(id);
    }

    @PostMapping("/checkout")
    public String checkout() {
        return cartService.checkout();
    }
}
