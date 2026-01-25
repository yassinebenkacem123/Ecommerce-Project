package com.example.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ecommerce.models.ProductImage;

@Repository
public interface ProductImageRepo extends JpaRepository<Long, ProductImage> {
    
}
