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
        Order order = new Order();
        order.setStatus("CREATED");

        logger.info("ORDER-SERVICE: "+ "createOrder");

        return orderRepository.save(order);
    }

    @Override
    public Order getOrder(Long id) {
        return orderRepository.findById(id).orElse(null);
    }
}
