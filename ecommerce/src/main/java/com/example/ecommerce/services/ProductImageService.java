package com.example.ecommerce.services;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.example.ecommerce.payload.ProductImageDTO;

public interface ProductImageService {

    ResponseEntity<ProductImageDTO> addImageToProductService(Long productId, MultipartFile imageProductDTO);

    
} 