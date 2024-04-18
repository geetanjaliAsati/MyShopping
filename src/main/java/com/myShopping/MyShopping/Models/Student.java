package com.myShopping.MyShopping.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

import java.util.List;
import java.util.UUID;

@Entity
public class Student {
    @Id
    UUID id;
    String name;

//    @OneToOne
//    Laptop laptop;

//    by using mappedBy we are telling hibernate this relation is already maintained in Laptop table by field student name
    @OneToMany(mappedBy = "student")
    List<Laptop> laptops;


}
