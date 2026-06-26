package com.example.testtask2.service;

import com.example.testtask2.model.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {

    List<Category> findAllCategories();
}
