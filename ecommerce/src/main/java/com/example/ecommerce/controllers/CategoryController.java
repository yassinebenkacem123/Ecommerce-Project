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
import org.springframework.web.server.ResponseStatusException;


import com.example.ecommerce.models.Category;
import com.example.ecommerce.services.CategoryService;
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
    public ResponseEntity<?> getCategoryById(@PathVariable Long id){
        try{
            return categoryService.getCategoryById(id);
        }catch(ResponseStatusException e){
            return new ResponseEntity<>(e.getReason(),e.getStatusCode());

        }
    }
    // add Category :
    @PostMapping("/admin/addCategory")
    public ResponseEntity<?> addCategory(@RequestBody Category newCategory){
        return categoryService.addNewCategory(newCategory);
    }

    // delete category :
    @DeleteMapping("/admin/deleteCategory/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable Long id){
        try{
            return categoryService.deleteCategory(id);
        }catch(ResponseStatusException e){
            return new ResponseEntity<>(e.getReason(),e.getStatusCode());
        }
    }

    // update category : 
    @PutMapping("/admin/updateCategory/{id}")
    public ResponseEntity<?> updateCategory(@PathVariable Long id, @RequestBody Category categoryToUpdate) {
        try{
            return categoryService.updateCategory(id, categoryToUpdate);
        }catch(ResponseStatusException e){
            return new ResponseEntity<>(e.getReason(),e.getStatusCode());
        }
    }
}
