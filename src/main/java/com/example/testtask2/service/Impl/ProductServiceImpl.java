package com.example.testtask2.service.Impl;

import com.example.testtask2.repository.ProductRepository;
import com.example.testtask2.service.ProductService;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }
}
