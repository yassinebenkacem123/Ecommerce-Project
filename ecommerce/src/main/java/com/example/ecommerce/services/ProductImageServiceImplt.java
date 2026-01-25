package com.example.ecommerce.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.ecommerce.exceptions.ResourceNotFoundException;
import com.example.ecommerce.models.Product;
import com.example.ecommerce.payload.ProductImageDTO;
import com.example.ecommerce.repository.ProductRepo;

@Service
public class ProductImageServiceImplt implements ProductImageService{
    @Autowired
    ProductRepo productRepo;

    @Autowired
    FileService fileService; 


    @Override
    public ResponseEntity<ProductImageDTO> addImageToProductService(Long productId, MultipartFile imageProduct) {
        //checking if the product exist :
    
        
        return null;
    }
    
}
