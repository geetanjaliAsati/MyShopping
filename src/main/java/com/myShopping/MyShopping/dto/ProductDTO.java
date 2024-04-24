package com.myShopping.MyShopping.dto;

import lombok.*;

import java.util.UUID;

//Since we have added lombok maven dependency so we don't need to write constructors, getters , 
// setters etc.. in this class the springboot automatically will create these things
//Data transfer object(DTO)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ProductDTO {
    UUID id;
    String productName;
    String productCategory;
    String rating;
    String description;
    String sellerName;
    int price;
    int quantity;
}
