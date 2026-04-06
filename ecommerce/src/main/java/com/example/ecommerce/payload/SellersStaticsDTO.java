package com.example.ecommerce.payload;

import com.example.ecommerce.config.ProductStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SellersStaticsDTO {
    private int totalSellers;
    private int activeSellers;
    private int inactiveSellers;
    private int pendingApprovalSellers;
}
