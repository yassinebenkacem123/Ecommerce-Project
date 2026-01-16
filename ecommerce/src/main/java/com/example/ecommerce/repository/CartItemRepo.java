package com.example.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.ecommerce.models.CartItem;

public interface CartItemRepo  extends JpaRepository<CartItem, Long>{

    @Query("select ci from cartItems where ci.card.cardId = ?1 and  ci.product.productId = ?2")
    CartItem findByCartIdAndProductId(Long cardId, Long productId);
    
}
