package com.myShopping.MyShopping.repository;

import com.myShopping.MyShopping.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {

}
