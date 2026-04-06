package com.example.ecommerce.payload;

import com.example.ecommerce.config.ProductStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public  class AdminProductsDashboardDTO {
    private String productName;
    private String productImage;
    private Double productPrice;
    private int productQuantity;
    private Date productCreatedDate;
    private double productRating;
    private Double discount;
    private String productCategory;
    private ProductStatus productStatus;
    private SubSellerInfo subSellerInfo;
}
