package com.example.order.controller;


import com.example.order.model.Product;
import com.example.order.service.ProductQueryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// 假设查询不需要路径参数
@RestController
@RequestMapping("/api/queries")
public class ProductQueryController {

    private final ProductQueryService productQueryService;

    public ProductQueryController(ProductQueryService productQueryService) {
        this.productQueryService = productQueryService;
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productQueryService.getAllProducts();
    }
}
