package com.example.ecommerce.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId; 
    private String categoryName;
    
    // constructor :
    public Category(String categoryName, Long categoryId){
        this.categoryName = categoryName;
        this.categoryId  = categoryId;
    }

    // setters :
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
    public void setName(String categoryName) {
        this.categoryName = categoryName;
    }

    // getters:
    public Long getCategoryId() {
        return categoryId;
    }
    public String getName() {
        return categoryName;
    }
    

}
