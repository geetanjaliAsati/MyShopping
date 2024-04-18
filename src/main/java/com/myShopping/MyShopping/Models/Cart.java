package com.myShopping.MyShopping.Models;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;
    int quantity;
    @OneToOne
    AppUser user;//each buyer can have only one cart so relation b/w cart and user is one to one
    int totalPrice;
    @OneToMany
    List<Product> products;//each cart can have many products so relationship from cart point of view is one to many

    public Cart(UUID id, int quantity, AppUser user, int totalPrice, List<Product> products) {
        this.id = id;
        this.quantity = quantity;
        this.user = user;
        this.totalPrice = totalPrice;
        this.products = products;
    }

    public Cart() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public AppUser getUser() {
        return user;
    }

    public void setUser(AppUser user) {
        this.user = user;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
