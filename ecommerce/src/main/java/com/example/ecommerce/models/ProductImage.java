package com.example.ecommerce.models;



import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductImage {
    @Id
    private Long imageId;

    private String imageUrl;

    private String publicId;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false) // i must add the ID product.=> DTO's.
    @JsonIgnore
    private Product product;
}