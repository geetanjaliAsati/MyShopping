package com.myShopping.MyShopping.service;

import com.myShopping.MyShopping.Models.AppUser;
import com.myShopping.MyShopping.Models.Product;
import com.myShopping.MyShopping.dto.ProductDTO;
import com.myShopping.MyShopping.exception.ResourceNotFound;
import com.myShopping.MyShopping.exception.Unauthorised;
import com.myShopping.MyShopping.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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

    public List<ProductDTO> searchByCategoryAndProductName(String category, String name) {
        List<Product> products = productRepository.getProductsByCategoryAndName(category, name);
        List<ProductDTO> productList = convertProductToProductDTO(products);
        return productList;
    }

    public List<ProductDTO> searchByCategory(String category) {
        List<Product> products = productRepository.getProductsByCategory(category);
        List<ProductDTO> productList = convertProductToProductDTO(products);
        return productList;
    }


    public List<ProductDTO> convertProductToProductDTO(List<Product> products) {
        List<ProductDTO> productList = new ArrayList<>();
        for(Product product : products) {
            //Why we need to create object of productDTO here because products having so many product object inside it and so every time we need empty productDTO object to copy the product in it
            ProductDTO productDTO = new ProductDTO();
            productDTO.setProductName(product.getName());
            productDTO.setProductCategory(product.getCategory());
            productDTO.setId(product.getId());
            productDTO.setRating(product.getRating());
            productDTO.setPrice(product.getPrice());
            productDTO.setDescription(product.getDescription());
            productDTO.setSellerName(product.getUser().getName());
            productDTO.setQuantity(product.getQuantity());
            productList.add(productDTO);
        }
        return productList;
    }
    public List<ProductDTO> searchByProductName(String name) {
        List<Product> products = productRepository.getProductsByProductName(name);
        List<ProductDTO> productList = convertProductToProductDTO(products);
        return productList;
    }

    public List<ProductDTO> getAllProducts() {
        List<Product> products = productRepository.findAll();
        List<ProductDTO> productList = convertProductToProductDTO(products);
        return productList;
    }

    public Product getProductById(UUID id) {
        return productRepository.findById(id).orElse(null);
    }

    public void updateProductQuantity(UUID productId, int quantity) {
        productRepository.updateProductQuantity(productId, quantity);
    }

}
