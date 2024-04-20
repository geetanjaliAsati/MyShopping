package com.myShopping.MyShopping.exception;

public class Unauthorised extends RuntimeException{
    public Unauthorised(String message) {
        super(message);
    }
}
