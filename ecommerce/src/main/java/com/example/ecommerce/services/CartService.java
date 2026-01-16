package com.example.ecommerce.services;

import org.springframework.http.ResponseEntity;

public interface CartService {

    ResponseEntity<?> addProductToCartService(Long productId, Integer quantity);

    
}