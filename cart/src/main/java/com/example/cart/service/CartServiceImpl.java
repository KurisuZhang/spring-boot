package com.example.cart.service;

import com.example.cart.model.CartItem;
import com.example.cart.model.CartItemDTO;
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

    Logger logger = LoggerFactory.getLogger(CartService.class);

    @Override
    public CartItem addItem(CartItemDTO item) {
        CartItem cartItem = new CartItem();
        cartItem.setProduct(item.getProduct());
        cartItem.setQuantity(item.getQuantity());
        logger.info("CART-SERVICE[addItem]: {}", cartItem);
        return cartRepository.save(cartItem);
    }

    @Override
    public CartItem getItem(Long id) {
        CartItem cartItem = cartRepository.findById(id).orElse(null);
        logger.info("CART-SERVICE[getItem]: {}", cartItem);
        return cartItem;
    }

    @Override
    public List<CartItem> getAllItems() {
        logger.info("CART-SERVICE[getAllItems]: All items");
        return cartRepository.findAll();
    }

    @Override
    @CircuitBreaker(name = "orderService", fallbackMethod = "checkoutFallback")
    public String checkout() {

        String url = "http://order-service/orders/create";
        Order order = restTemplate.postForObject(url, null, Order.class);

        if (order != null && "CREATED".equals(order.getStatus())) {
            logger.info("CART-SERVICE[checkout]: {}", order);
            return String.format("Order ID:%s Status:%s", order.getId(), order.getStatus());
        } else {
            logger.warn("CART-SERVICE[checkout]: Failed to create order");
            return "Failed to create order";
        }
    }

    // Fallback method
    public String checkoutFallback(Throwable throwable) {
        logger.warn("CART-SERVICE[checkout]: Order service is down.");
        return "Order service is down.";
    }

}
