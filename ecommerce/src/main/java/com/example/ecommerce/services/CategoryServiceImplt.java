package com.example.ecommerce.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.ecommerce.models.Category;

@Service
public class CategoryServiceImplt implements CategoryService {
    
    Long id = 0L;
    List<Category> categories = new ArrayList<>();
    @Override
    public ResponseEntity<List<Category>> getAllCategories() {
        return new ResponseEntity<>(categories ,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Category> getCategoryById(Long categoryId) {
        Category category = categories.stream()
        .filter(c -> c.getCategoryId().equals(categoryId))
        .findFirst()
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Category Not Found"));
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> addNewCategory(Category newCategory) {
        id++;
        newCategory.setCategoryId(id);
        categories.add(newCategory);
        return new ResponseEntity<>("Category added successfly", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> deleteCategory(Long categoryId) {
        Category category = categories.stream()
        .filter(c -> c.getCategoryId().equals(categoryId))
        .findFirst()
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Category Not Found"));
        categories.remove(category);
        return new ResponseEntity<>("Category Deleted successfly...",HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> updateCategory(Long categoryId, Category category) 
    {
        Category categoryToUpdate = categories.stream()
        .filter(c -> c.getCategoryId().equals(categoryId))
        .findFirst()
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Category Not Found"));
        categoryToUpdate.setName(category.getName());
        return new ResponseEntity<>("Category updated successfly...", HttpStatus.OK);
    }
    
}
