package com.example.cart.controller;

import com.example.cart.model.CartItem;
import com.example.cart.model.CartItemDTO;
import com.example.cart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/add")
    public CartItem addItem(@RequestBody CartItemDTO item) {
        return cartService.addItem(item);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getItem(@PathVariable Long id) {
        CartItem cartItem = cartService.getItem(id);
        if (cartItem == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Item with id " + id + " not found.");
        }
        return ResponseEntity.ok(cartItem);
    }


    @PostMapping("/checkout")
    public String checkout() {
        return cartService.checkout();
    }
}
