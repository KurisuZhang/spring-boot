package com.example.cart.service;

import com.example.cart.model.CartItem;
import com.example.cart.model.Order;
import com.example.cart.repository.CartRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private RestTemplate restTemplate;

    Logger logger= LoggerFactory.getLogger(CartService.class);

    @Override
    public CartItem addItem(CartItem item) {
        logger.info("ORDER-SERVICE: "+ "Item Added");
        return cartRepository.save(item);
    }

    @Override
    public CartItem getItem(Long id) {
        return cartRepository.findById(id).orElse(null);
    }

    @Override
    public List<CartItem> getAllItems() {
        return cartRepository.findAll();
    }

    @Override
    @CircuitBreaker(name = "orderService", fallbackMethod = "checkoutFallback")
    public String checkout() {
        String url = "http://order-service/orders/create";

        // Correctly using POST method
        Order order = restTemplate.postForObject(url, null, Order.class);

        if (order != null && "CREATED".equals(order.getStatus())) {
            return "Order created successfully with ID: " + order.getId();
        } else {
            return "Failed to create order";
        }
    }

    // Fallback method
    public String checkoutFallback(Throwable throwable) {
        return "Order service is down.";
    }

}
