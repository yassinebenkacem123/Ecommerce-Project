package com.example.ecommerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce.services.CartService;

@RestController
@RequestMapping("/api/v2")
public class CartController {


    @Autowired 
    CartService cartService;


    // add product to a card by authenticated user :
    @PostMapping("/cart/product/{productId}/quantity/{quantity}")
    public ResponseEntity<?> addProductToCart(
        @PathVariable Long productId,
        @PathVariable Integer quantity
    ){
        return cartService.addProductToCartService(productId, quantity);
    }

}
