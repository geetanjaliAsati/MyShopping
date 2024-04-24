package com.myShopping.MyShopping.repository;

import com.myShopping.MyShopping.Models.Product;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {

//    nativeQuery = true means we are passing sql query and whenever we want to execute our own query from jpa we pass nativeQuery = true, category = 'Electronics' dont have to pass hard coded values so here we have to pass variables inside sql query how to write that? :nameOfVariable in this way we can pass variable which we are
    @Query(value = "SELECT * FROM product WHERE category =:category AND name =:name", nativeQuery = true)
    public List<Product> getProductsByCategoryAndName(String category, String name);

    @Query(value = "SELECT * FROM product WHERE category =:category", nativeQuery = true)
    public List<Product> getProductsByCategory(String category);

    @Query(value = "SELECT * FROM product WHERE name =:name", nativeQuery = true)
    public List<Product> getProductsByProductName(String name);


//    No need to write this query because we can use the findAll() method of JPA inside the productService class
//    @Query(value = "SELECT * FROM product;", nativeQuery = true)
//    public List<Product> getAllProducts();

    //@Transactional annotation use when we want to update into database so it locks the row until we dont complete the transaction
    @Transactional
    @Modifying
    @Query(value = "update product set quantity =:quantity where id = :productId", nativeQuery = true)
    public void updateProductQuantity(UUID productId, int quantity);
}
