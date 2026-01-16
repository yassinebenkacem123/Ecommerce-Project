package com.example.ecommerce.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.ecommerce.exceptions.APIException;
import com.example.ecommerce.exceptions.ResourceNotFoundException;
import com.example.ecommerce.models.Cart;
import com.example.ecommerce.models.CartItem;
import com.example.ecommerce.models.Product;
  import com.example.ecommerce.payload.APIResponse;
import com.example.ecommerce.repository.CartItemRepo;
import com.example.ecommerce.repository.CartRepo;
import com.example.ecommerce.repository.ProductRepo;
import com.example.ecommerce.repository.UserRepo;
import com.example.ecommerce.utils.AuthUtils;

@Service
public class CartServiceImpl implements CartService {

    @Autowired 
    CartRepo cartRepo;

    @Autowired
    UserRepo userRepo;


    @Autowired
    AuthUtils authUtils;

    @Autowired 
    ProductRepo productRepo;


    @Autowired
    CartItemRepo cartItemRepo;


    @Override
    public ResponseEntity<?> addProductToCartService(Long productId, Integer quantity) {
        // create user cart:
        Cart cart = createNewCart();
        
        // check if the product exist or not
        Product productToadd = productRepo.findById(productId).orElseThrow(
            ()-> new ResourceNotFoundException("Product","Product",productId)
        );

        // check if the product already added.
        CartItem cartItem = cartItemRepo.findByCartIdAndProductId(cart.getCardId(),productId);

        if(cartItem != null){
            throw new APIException("Product With the name "+productToadd.getProductName()+" Already exist.");
        }
        if(productToadd.getQuantity() == 0){
            APIResponse apiResponse = new APIResponse();
            apiResponse.setMessage("This product is not available right now");
            apiResponse.setStatus(false);
            return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
        }else if(productToadd.getQuantity() < quantity){
            throw new APIException("the quantity of the product on the sock "+productToadd.getQuantity()+" less than the quantity provided");
        }else{
            CartItem newCartItem = new CartItem();
            newCartItem.setCart(cart);
            newCartItem.setDiscount(productToadd.getDiscounte());
            newCartItem.setProduct(productToadd);
            newCartItem.setQuantity(quantity);
            newCartItem.setProductPrice(productToadd.getPrice());  
            cartItemRepo.save(newCartItem);
            productToadd.setQuantity(productToadd.getQuantity() - quantity);
            productRepo.save(productToadd);
            // how i can do this !!!.
           
            cart.setTotalPrice(cart.getTotalPrice() + (newCartItem.getQuantity()*productToadd.getSpecialPrice()));
            cartRepo.save(cart);
            APIResponse apiResponse = new APIResponse();
            apiResponse.setMessage("Product added To Successfly.");
            apiResponse.setStatus(true);
            return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
        
        }
    }




    // create a new cart
    private Cart createNewCart() {
        Cart existedCart = cartRepo.findByUserEmail(authUtils.loggedInEmail());
        if(existedCart == null)
        {
            Cart cart = new Cart();
            cart.setTotalPrice(0.00);
            cart.setUser(authUtils.loggedInUser());
            return cart;
        }
        return existedCart;
    }
    
}
