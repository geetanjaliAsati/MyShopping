package com.myShopping.MyShopping.controller;

import com.myShopping.MyShopping.Models.OrderTable;
import com.myShopping.MyShopping.dto.BillDTO;
import com.myShopping.MyShopping.dto.OrderDetailsDTO;
import com.myShopping.MyShopping.service.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/buyer")
public class BuyerController {

    @Autowired
    BuyerService buyerService;
    @PostMapping("/placeorder")
    public BillDTO placeOrder(@RequestBody List<OrderDetailsDTO> orders, @RequestParam UUID userId) {
        return buyerService.placeOrder(orders, userId);
    }
/*
Create BillDTO where you have to share only sharable details like quantity, totalprice, buyer gmail, ordered products no need to pass completer details of buyer and products
* */
}
