package com.myShopping.MyShopping.controller;

import com.myShopping.MyShopping.Models.AppUser;
import com.myShopping.MyShopping.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//RestController annotation tell the springboot that this is the controller layer
@RestController
@RequestMapping("/api") //If any request starting with /api all those requests are going to come at the common controller
public class CommonController {

    @Autowired
    UserService userService;
    @PostMapping("/user/register")
    public String registerUser(@RequestBody AppUser appUser) {
        // Save User -> We need to write some kind of logic
        // So to write logic we require service layer where we can write logic
        userService.registerUser(appUser);
        return "User got saved successfully!";
    }
}
