package com.example.ecommerce.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.ecommerce.exceptions.APIException;
import com.example.ecommerce.exceptions.ResourceNotFoundException;
import com.example.ecommerce.models.Category;
import com.example.ecommerce.payload.CategoryDTO;
import com.example.ecommerce.payload.CategoryResponse;
import com.example.ecommerce.repository.CategoryRepo;


@Service // for defining the buisness logic here !
public class CategoryServiceImplt implements CategoryService {

    @Autowired
    CategoryRepo categoryRepo;

    @Autowired
    ModelMapper modelMapper;

    // get all categories :
    @Override
    public ResponseEntity<CategoryResponse> getAllCategories(Integer pageNumber, Integer pageSize) {
        List<Category> categories = categoryRepo.findAll();
        if(categories.isEmpty())
        {
            throw new APIException("No Category created until now.");
        }
        List<CategoryDTO> categoryDTOs = categories.stream().
            map(c -> modelMapper.map(c, CategoryDTO.class)).toList();

        CategoryResponse categoryResponse = new CategoryResponse();
        categoryResponse.setContent(categoryDTOs);
        return new ResponseEntity<>(categoryResponse, HttpStatus.OK);
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
    public ResponseEntity<String> addNewCategory(CategoryDTO newCategoryDto) {
        Category existCategory = categoryRepo.findByCategoryName(newCategoryDto.getCategoryName());
        if(existCategory != null){
            throw new APIException("Category with name "+ newCategoryDto.getCategoryName()+" already exist.");
        }
        Category categoryToSave = modelMapper.map(newCategoryDto, Category.class);
        categoryRepo.save(categoryToSave);
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
    public ResponseEntity<String> updateCategory(Long categoryId,CategoryDTO categoryDto) {
        Category existedCategory = categoryRepo.findByCategoryName(categoryDto.getCategoryName());
        if(existedCategory != null)
        {
            throw new APIException("the category name "+categoryDto.getCategoryName()+" already used, Pls use another name.");
        }
        Category categoryToUpdate = categoryRepo.findById(categoryId)
                .orElseThrow(() ->  new ResourceNotFoundException("Category", "Category ID", categoryId));
        categoryToUpdate.setCategoryName(categoryDto.getCategoryName());
        categoryRepo.save(categoryToUpdate);
        return new ResponseEntity<>("Category updated successfly.", HttpStatus.OK);
    }

}
