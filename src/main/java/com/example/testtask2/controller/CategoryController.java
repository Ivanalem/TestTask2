package com.example.testtask2.controller;


import com.example.testtask2.model.Category;
import com.example.testtask2.service.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("categories")
    public List<Category> findAllCategories() {
        return categoryService.findAllCategories();
    }


}
