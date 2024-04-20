package com.myShopping.MyShopping.controller;

import com.myShopping.MyShopping.Models.Product;
import com.myShopping.MyShopping.exception.ResourceNotFound;
import com.myShopping.MyShopping.exception.Unauthorised;
import com.myShopping.MyShopping.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@RestController
@RequestMapping("/seller")
public class SellerController {

    @Autowired
    ProductService productService;

    @PostMapping("/product/add")
    public String addProduct(@RequestBody Product product, @RequestParam UUID sellerId) {
//To save product into our system we need to write some logic so to write logic we require service class
//request body is also called payload
        try {
            productService.registerProduct(product, sellerId);
        }
        catch (ResourceNotFound resourceNotFound) {
            return resourceNotFound.getMessage();
        }
        catch (Unauthorised unauthorised) {
            return unauthorised.getMessage();
        }

        return "Product got Saved into the system!";


    }

}
