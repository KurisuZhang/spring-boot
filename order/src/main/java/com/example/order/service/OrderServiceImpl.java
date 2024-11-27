package com.example.order.service;

import com.example.order.model.Order;
import com.example.order.repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    Logger logger= LoggerFactory.getLogger(OrderService.class);


    @Override
    public Order createOrder() {
        // create
        Order order = new Order();
        order.setStatus("CREATED");
        // log
        logger.info("ORDER-SERVICE[createOrder]: {}", order);

        return orderRepository.save(order);
    }

    @Override
    public Order getOrder(Long id) {
        Order order = orderRepository.findById(id).orElse(null);
        // log
        logger.info("ORDER-SERVICE[getOrder]: {}", order);
        return order;
    }
}
