package com.example.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.ecommerce.models.Cart;

public interface CartRepo extends JpaRepository<Cart, Long>{
   @Query("select c from carts where c.user.email = ?1")
    Cart findByUserEmail(String email);
    
}