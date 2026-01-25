package com.example.ecommerce.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.example.ecommerce.exceptions.ResourceNotFoundException;
import com.example.ecommerce.models.Product;
import com.example.ecommerce.models.ProductImage;
import com.example.ecommerce.payload.ProductImageDTO;
import com.example.ecommerce.repository.ProductImageRepo;
import com.example.ecommerce.repository.ProductRepo;

@Service
public class ProductImageServiceImplt implements ProductImageService{
    @Autowired
    ProductRepo productRepo;

    @Autowired
    FileService fileService;
    
    @Autowired
    Cloudinary cloudinary;

    @Autowired
    CloudinaryService cloudinaryService;

    @Autowired
    ProductImageRepo productImageRepo;

    // add product's images service :
    @Override
    public ResponseEntity<ProductImageDTO> addImageToProductService(Long productId, MultipartFile imageProduct) {
        //checking if the product exist :
        Product product = productRepo.findById(productId).orElseThrow(
            ()-> new ResourceNotFoundException("Product","ProductId",productId)
        );
        Map<String, String> uploadResult = cloudinaryService.uploadProductImage(imageProduct, product.getProductName());
        ProductImage productImage = new ProductImage();
        productImage.setImageUrl(uploadResult.get("secure_url").toString());
        productImage.setProduct(product);

        ProductImage savedProductImage  =  productImageRepo.save(productImage);

        ProductImageDTO productImageDTO = new ProductImageDTO();
        productImageDTO.setImageId(savedProductImage.getImageId());
        productImageDTO.setImageUrl(savedProductImage.getImageUrl());
        return ResponseEntity.ok().body(productImageDTO);
    }

    // get product's images service :

    @Override
    public ResponseEntity<List<ProductImageDTO>> getProductImagesService(Long productId) {

        
        return null;
    }
    
}
