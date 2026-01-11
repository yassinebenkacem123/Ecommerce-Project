package com.example.ecommerce.services;


import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.ecommerce.exceptions.ResourceNotFoundException;
import com.example.ecommerce.models.Category;
import com.example.ecommerce.models.Product;
import com.example.ecommerce.payload.APIResponse;
import com.example.ecommerce.payload.ProductDTO;
import com.example.ecommerce.payload.ProductResponse;
import com.example.ecommerce.repository.CategoryRepo;
import com.example.ecommerce.repository.ProductRepo;

@Service
public class ProductServiceImplt implements ProductService {
    @Autowired
    CategoryRepo categoryRepo;

    @Autowired 
    ProductRepo productRepo;

    @Autowired
    ModelMapper modelMapper;

    // add new product.
    @Override
    public ResponseEntity<APIResponse> addNewProduct(ProductDTO productDTO, Long categoryId) {
        Category existedCategory = categoryRepo.findById(categoryId)
        .orElseThrow(()-> new ResourceNotFoundException("Category", "CategoryId", categoryId));

        // converting productDTO to product class.
        Product productToAdd = modelMapper.map(productDTO, Product.class);
        
        productToAdd.setCategory(existedCategory);
        Double specialPrice = productDTO.getPrice() - (productDTO.getPrice()*productDTO.getDiscounte()*0.01);
        productToAdd.setSpecialPrice(specialPrice);
        
        productRepo.save(productToAdd);
        APIResponse apiResponse = new APIResponse();
        apiResponse.setMessage("Product added successfly.");
        apiResponse.setStatus(true);
        return new ResponseEntity<>(apiResponse,HttpStatus.OK);
    }

    // get all products.
    @Override
    public ResponseEntity<ProductResponse> getAllProduct() {
        List<Product> products = productRepo.findAll();
        
        //=> verifying if there's any products.
        if(products.isEmpty()){
            throw new ResourceNotFoundException("There's no product added Until now.");
        }
        List<ProductDTO> productsDtos = products.stream().map((product)->
            modelMapper.map(product, ProductDTO.class)
        ).toList();


        ProductResponse productResponse = new ProductResponse();
        productResponse.setContent(productsDtos);
        return new ResponseEntity<>(productResponse,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ProductResponse> getProductByCategory(Long categoryId) {
        Category category = categoryRepo.findById(categoryId)
            .orElseThrow(()-> new ResourceNotFoundException("Category", "CategoryId", categoryId));
        List<Product> products = productRepo.findByCategoryOrderByPriceAsc(category);
        //=> verifying if there's any products.
        if(products.isEmpty()){
            throw new ResourceNotFoundException("There's no product added Until now.");
        }
        
        List<ProductDTO> productsDtos = products.stream().map((product)->
            modelMapper.map(product, ProductDTO.class)
        ).toList();

        ProductResponse productResponse = new ProductResponse();
        productResponse.setContent(productsDtos);
        return new ResponseEntity<>(productResponse,HttpStatus.OK);
    }
    
}
