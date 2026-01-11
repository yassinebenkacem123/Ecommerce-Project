package com.example.ecommerce.payload;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    
    @NotBlank(message = "You must provide a product name.")
    @Size(min=2, message = "Product name must contain at least 2 caracters.")
    private String productName;

    @NotBlank(message = "The product must contain an image.")
    private String productImage;
        
    @Size(min=10,max = 150, message = "Description size must be between 10 and 150.")
    private String description;
    
    @Size(min=1, message = "You must provide a quantity for the product.")
    private Integer quantity;
    private Double price;
    private Double specialPrice;
    private Double discounte;

}
