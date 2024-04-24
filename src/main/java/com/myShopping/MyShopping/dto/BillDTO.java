package com.myShopping.MyShopping.dto;

import lombok.*;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class BillDTO {
    UUID billId;
    String buyerName;
    UUID buyerId;
    String emailId;
    int totalQuantity;
    int totalPrice;
    List<OrderProductDTO> orderProducts;
}
