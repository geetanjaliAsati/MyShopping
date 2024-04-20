package com.myShopping.MyShopping.Models;

import jakarta.persistence.*;

import java.util.UUID;
//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
@Entity
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;

    @Column(nullable = false)
    String name;

    @Column(unique = true, nullable = false)
    String email;

    @Column(nullable = false)
    String password;


    String userType;//buyer / seller / admin

    @Column(unique = true, length = 10)
    long phoneNumber;

    public AppUser() {
    }

    public AppUser(long phoneNumber, String userType, String password, String email, String name, UUID id) {
        this.phoneNumber = phoneNumber;
        this.userType = userType;
        this.password = password;
        this.email = email;
        this.name = name;
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}

/*
Buyer Controller
/buyer/search/product?category=FMCG

Seller Controller
/seller/product/remove?userId=lsdjfiejfe&&productId => by this endpoint a particular seller can remove their product from the application
/seller/product/add?sellerId=djfleifjdf(RequestBody productDetails) =>writing sellerId to get to know which particular seller is trying to add product, seller kind of user can add product into database

Admin controller
/admin/product/remove?userid=eojfslvfjoe&&productId=lfjeofjei => Admin kind of user can delete any product just we need to check one thing userId is of type admin or not

Common Controller
/api/user/register => all the kind of users will be able to register themselves
/api/product/all => all the users can view the products by this endpoint


* */













