package com.example.testtask2.service.Impl;

import com.example.testtask2.model.Category;
import com.example.testtask2.repository.CategoryRepository;
import com.example.testtask2.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> findAllCategories() {

        return categoryRepository.findAll();


    }
}
