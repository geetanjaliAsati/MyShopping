package com.myShopping.MyShopping.controller;

import com.myShopping.MyShopping.Models.AppUser;
import com.myShopping.MyShopping.Models.Product;
import com.myShopping.MyShopping.dto.ProductDTO;
import com.myShopping.MyShopping.service.ProductService;
import com.myShopping.MyShopping.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//RestController annotation tell the springboot that this is the controller layer
@RestController
@RequestMapping("/api") //If any request starting with /api all those requests are going to come at the common controller
public class CommonController {

    @Autowired
    UserService userService;

    @Autowired
    ProductService productService;

    @PostMapping("/user/register")
    public String registerUser(@RequestBody AppUser appUser) {
        // Save User -> We need to write some kind of logic
        // So to write logic we require service layer where we can write logic
        userService.registerUser(appUser);
        return "User got saved successfully!";
    }

    @GetMapping("/product/search")
    public List<ProductDTO> searchProductByCategory(@RequestParam(required = false) String category, @RequestParam(required = false) String productName) {
        // Here we need to search the product -> Product service
        if(category != null && productName != null){
            // You will search in database both by productName and categoryName
            return productService.searchByCategoryAndProductName(category, productName);
        }else if(category != null){
            // You will search system by just category
            return productService.searchByCategory(category);
        }else if(productName != null){
            // you will search system by just productName
            return productService.searchByProductName(productName);
        }else{
            // you will return all the products that are present in system
            return productService.getAllProducts();
        }
    }
}
