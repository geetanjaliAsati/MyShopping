package com.myShopping.MyShopping.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
//[{}, {}, {}]
public class OrderDetailsDTO {
    UUID id;//this is id of product
    int quantity;
    String paymentMode;
}
