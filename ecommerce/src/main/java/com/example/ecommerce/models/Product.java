package com.example.ecommerce.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @NotBlank(message = "You must provide a product name.")
    @Size(min=2, message = "Product name must contain at least 2 caracters.")
    private String productName;
    
    private String productImage;
        
    @Size(min=10,max = 150, message = "Description size must be between 10 and 150.")
    private String description;
    

    @NotNull(message = "You must provide a quantity for the product.")
    @Min(value = 1, message = "Quantity must be at least 1.")    
    private Integer quantity;
    private Double price;
    private Double specialPrice;
    private Double discounte;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "category_id")
    private Category category;

}
