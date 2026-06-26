package com.example.testtask2.controller;

import com.example.testtask2.model.Product;
import com.example.testtask2.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("products")
    public List<Product> findAllProducts() {
        return productService.findAllProducts();
    }

    @GetMapping("products/{id}")
    public Product findProductById(@PathVariable Long id) {

        return productService.findProductById(id);
    }
}
