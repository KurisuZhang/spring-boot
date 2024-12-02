package com.example.cart.service;


import com.example.cart.model.ProductEvent;
import com.example.cart.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProductCommandService {

    private final ProductRepository productRepository;
    private final KafkaTemplate<String, ProductEvent> kafkaTemplate;

    @Autowired
    public ProductCommandService(ProductRepository productRepository, KafkaTemplate<String, ProductEvent> kafkaTemplate) {
        this.productRepository = productRepository;
        this.kafkaTemplate = kafkaTemplate;
    }


    public ResponseEntity<String> consumeProductEvent(ProductEvent event) {

        kafkaTemplate.send("product-events", event);

        return switch (event.getEventType()) {
            case "ADD" -> {
                productRepository.save(event.getProduct());
                yield new ResponseEntity<>("Product added", HttpStatus.CREATED);
            }
            case "UPDATE" -> {
                productRepository.save(event.getProduct());
                yield new ResponseEntity<>("Product updated", HttpStatus.OK);
            }
            case "DELETE" -> {
                productRepository.deleteById(event.getProduct().getId());
                yield new ResponseEntity<>("Product deleted", HttpStatus.OK);
            }
            default -> new ResponseEntity<>("Invalid event type", HttpStatus.BAD_REQUEST);
        };
    }
}
