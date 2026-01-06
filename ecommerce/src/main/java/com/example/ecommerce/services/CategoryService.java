package com.example.ecommerce.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.ecommerce.models.Category;

public interface CategoryService {

    // get all categories :
    public ResponseEntity<List<Category>> getAllCategories();

    // get category by Id:
    public ResponseEntity<Category> getCategoryById(Long categoryId);

    // post category :
    public ResponseEntity<String> addNewCategory(Category newCategory);

    // delete category :
    public ResponseEntity<String> deleteCategory(Long categoryId);

    // update category :
    public ResponseEntity<String> updateCategory(Long categoryId, Category category);
}
