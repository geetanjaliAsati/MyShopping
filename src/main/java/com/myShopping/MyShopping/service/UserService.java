package com.myShopping.MyShopping.service;

import com.myShopping.MyShopping.Models.AppUser;
import com.myShopping.MyShopping.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
//    To save the user we need repository layer
    public void registerUser(AppUser appUser) {
//        to save user in the database jpa is providing save method to us
        userRepository.save(appUser);
//        by using this save method which is coming from jpa repository automatically our user kind
//        our user kind object will get save into sql database
    }

    public AppUser getUserById(UUID id) {
        AppUser user = userRepository.findById(id).orElse(null);
        return user;
    }

//    public AppUser getUserById(String email) {
//        AppUser user = userRepository.findByEmail(email);
//        return user;
//    }
}
