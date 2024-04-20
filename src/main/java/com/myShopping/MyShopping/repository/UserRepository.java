package com.myShopping.MyShopping.repository;

import com.myShopping.MyShopping.Models.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

// This repository layer is going to deal with AppUserTable
// We not need to write any kind of logic for database related operation for AppUserTable
// Jpa is going to handle it.
//
@Repository
public interface UserRepository extends JpaRepository<AppUser, UUID> {
    //HashMap is in memory database but here we are not using that because here our database is going to maintain by Jpa and hibernate

//    You don't have to implement this method jpa will automatically implement this
//    public AppUser findByEmail(String email);

}
