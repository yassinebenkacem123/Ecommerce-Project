package com.example.ecommerce.services;

import org.springframework.http.ResponseEntity;

import com.example.ecommerce.models.Product;
import com.example.ecommerce.payload.APIResponse;
import com.example.ecommerce.payload.ProductDTO;
import com.example.ecommerce.payload.ProductResponse;

public interface ProductService {
    // add new product.
    public ResponseEntity<APIResponse> addNewProduct(ProductDTO productDTO, Long categoryId);

    // get all products.
    public ResponseEntity<ProductResponse> getAllProduct();

    // get product by category.
    public ResponseEntity<ProductResponse> getProductByCategory(Long categoryId);

    // search product by keyword
    public ResponseEntity<ProductResponse> searchForProductByKeyword(String keyword);

    // update product 
    public ResponseEntity<APIResponse>  updateProduct(Long productId, ProductDTO product);

    public ResponseEntity<APIResponse> deleteProductService(Long productId);
    

}
