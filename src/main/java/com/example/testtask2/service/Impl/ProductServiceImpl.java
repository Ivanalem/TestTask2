package com.example.testtask2.service.Impl;

import com.example.testtask2.exception.ResponseNotFoundException;
import com.example.testtask2.model.Product;
import com.example.testtask2.repository.ProductRepository;
import com.example.testtask2.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public Product findProductById(Long id) {
            return productRepository.findById(id).orElseThrow(() -> new ResponseNotFoundException("Product not found with id: " + id));
    }

    @Override
    public List<Product> findAllProducts(){

        return productRepository.findAll();
    }
}
