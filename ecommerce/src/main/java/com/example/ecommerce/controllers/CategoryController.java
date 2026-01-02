package com.example.ecommerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.ecommerce.models.Category;
import com.example.ecommerce.services.CategoryService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/v2")
public class CategoryController {
    // Calling the category service :
    @Autowired
    private CategoryService categoryService;

    // get all categories :
    @GetMapping("/public/categories")
    public ResponseEntity<?> getAllCategories() {
        return categoryService.getAllCategories();
    }

    // getting category By Id:
    @GetMapping("/public/category/{id}")
    public ResponseEntity<?> getCategoryById(@PathVariable Long id) {
        return categoryService.getCategoryById(id);
    }

    // add Category :
    @PostMapping("/admin/addCategory")
    public ResponseEntity<?> addCategory(@Valid @RequestBody Category newCategory) {
        return categoryService.addNewCategory(newCategory);
    }

    // delete category :
    @DeleteMapping("/admin/deleteCategory/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable Long id) {
        return categoryService.deleteCategory(id);
    }

    // update category :
    @PutMapping("/admin/updateCategory/{id}")
    public ResponseEntity<?> updateCategory(@PathVariable Long id,@Valid @RequestBody Category categoryToUpdate) {
        return categoryService.updateCategory(id, categoryToUpdate);
    }
}
