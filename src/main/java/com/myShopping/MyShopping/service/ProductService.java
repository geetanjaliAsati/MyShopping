package com.myShopping.MyShopping.service;

import com.myShopping.MyShopping.Models.AppUser;
import com.myShopping.MyShopping.Models.Product;
import com.myShopping.MyShopping.exception.ResourceNotFound;
import com.myShopping.MyShopping.exception.Unauthorised;
import com.myShopping.MyShopping.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    UserService userService;
    public void registerProduct(Product product, UUID sellerId) {
        // we need to check this userId exists in our system or not
        // if userId exists what kind of userId it is
        // if it is seller kind of id then it is fine
        // else we need to throw exception
        // With the help of seller id we can get userObject or seller object
        // 1. Get user object by Id;
        AppUser user = userService.getUserById(sellerId);
        if(user == null) {
//            System.out.println("User doesn't exist in the application");
            throw new ResourceNotFound(String.format("Seller with sellerId %s doesn't exist in the system", sellerId.toString()));
        }
        if(!user.getUserType().equals("SELLER")) {
// If user is not of type SELLER -> We are going to throw unAuthorized exception
//            //throw exception
            throw new Unauthorised(String.format("Seller with sellerId %s doesn't have permission to add product", sellerId.toString()));
        }

        product.setUser(user);
        productRepository.save(product);


    }
}
