package com.myShopping.MyShopping.Models;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
public class Laptop {
    @Id
    UUID id;
    String name;

//    @OneToOne
//    Student student;

//    @ManyToOne
//    Student student;

    @ManyToMany
//            list because one laptop can be used by multiple students
    List<Student> student;
}
