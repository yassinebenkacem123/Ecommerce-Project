package com.example.ecommerce.controllers;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce.models.Product;
import com.example.ecommerce.payload.ProductDTO;
import com.example.ecommerce.services.ProductService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;



@RestController

@RequestMapping("/api/v2")
public class ProductController {

    @Autowired
    ProductService productService;

    // add a new product : 
    @PostMapping("/admin/categories/{categoryId}/addProduct")
    public ResponseEntity<?> addNewProduct(
        @RequestBody ProductDTO productDTO, 
        @PathVariable(name = "categoryId") Long categoryId
    ){
        return productService.addNewProduct(productDTO, categoryId);
    }

    // get all products : 
    @GetMapping("/public/getAllProducts")
    public ResponseEntity<?> getAllProducts(){
        return productService.getAllProduct();
    }
    

    // get product by category :
    @GetMapping("/public/getProductByCategory/{categoryId}")
    public ResponseEntity<?> getProductByCategory(@PathVariable Long categoryId){
        return productService.getProductByCategory(categoryId);
    }

    // get product by keyword :
    @GetMapping("/public/product/keyword/{keyword}")
    public ResponseEntity<?> getProductByKeyword(@PathVariable String keyword){
        return productService.searchForProductByKeyword(keyword);

    }

    // update product : 
    @PutMapping("/admin/updateProduct/{productId}")
    public ResponseEntity<?> updateProduct(@PathVariable Long productId, @RequestBody ProductDTO product) {
        return productService.updateProduct(productId, product);
    }

    // delete product :
    @DeleteMapping("/admin/deleteProduct/{productId}")
    public ResponseEntity<?> deletedProduct(@PathVariable Long productId){
        return productService.deleteProductService(productId);
    }

    
}

