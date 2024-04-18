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
    int phoneNumber;

    public AppUser() {
    }

    public AppUser(int phoneNumber, String userType, String password, String email, String name, UUID id) {
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

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
