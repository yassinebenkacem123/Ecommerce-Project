package com.example.ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.ecommerce.exceptions.APIException;
import com.example.ecommerce.exceptions.ResourceNotFoundException;
import com.example.ecommerce.models.Category;
import com.example.ecommerce.repository.CategoryRepo;


@Service // for defining the buisness logic here !
public class CategoryServiceImplt implements CategoryService {

    @Autowired
    CategoryRepo categoryRepo;

    // get all categories :
    @Override
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> categories = categoryRepo.findAll();
        if(categories.isEmpty())
        {
            throw new APIException("No Category created until now.");
        }
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    // get category by Id :
    @Override
    public ResponseEntity<Category> getCategoryById(Long categoryId) {
        Category category = categoryRepo.findById(categoryId)
            .orElseThrow(() ->  new ResourceNotFoundException("Category", "Category ID", categoryId));
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    // add new Category :
    @Override
    public ResponseEntity<String> addNewCategory(Category newCategory) {
        Category existCategory = categoryRepo.findByCategoryName(newCategory.getCategoryName());
        if(existCategory != null){
            throw new APIException("Category with name "+ newCategory.getCategoryName()+" already exist.");
        }
        categoryRepo.save(newCategory);
        return new ResponseEntity<>("Category added successfly.", HttpStatus.OK);
    }

    // delete category :
    @Override
    public ResponseEntity<String> deleteCategory(Long categoryId) {
        Category categoryDeleted = categoryRepo.findById(categoryId)
                .orElseThrow(() ->  new ResourceNotFoundException("Category", "Category ID", categoryId));
        categoryRepo.delete(categoryDeleted);
        return new ResponseEntity<>("Category Deleted successfly.", HttpStatus.OK);
    }

    // updating category :
    @Override
    public ResponseEntity<String> updateCategory(Long categoryId,Category category) {
        Category existedCategory = categoryRepo.findByCategoryName(category.getCategoryName());
        if(existedCategory != null)
        {
            throw new APIException("the category name "+category.getCategoryName()+" already used, Pls use another name.");
        }
        Category categoryToUpdate = categoryRepo.findById(categoryId)
                .orElseThrow(() ->  new ResourceNotFoundException("Category", "Category ID", categoryId));
        categoryToUpdate.setCategoryName(category.getCategoryName());
        categoryRepo.save(categoryToUpdate);
        return new ResponseEntity<>("Category updated successfly.", HttpStatus.OK);
    }

}
