package com.myShopping.MyShopping.dto;

import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class OrderProductDTO {
    UUID productId;
    String productName;
    int quantity;
}
