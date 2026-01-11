package com.example.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ecommerce.models.Category;
import com.example.ecommerce.models.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long>{

    List<Product> findByCategoryOrderByPriceAsc(Category category);
  
} 