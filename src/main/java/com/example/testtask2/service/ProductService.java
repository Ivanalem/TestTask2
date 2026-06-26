package com.example.testtask2.service;

import com.example.testtask2.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    Product findProductById(Long id);

    List<Product> findAllProducts();
}
