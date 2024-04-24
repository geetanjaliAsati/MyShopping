package com.myShopping.MyShopping.service;

import com.myShopping.MyShopping.Models.AppUser;
import com.myShopping.MyShopping.Models.OrderTable;
import com.myShopping.MyShopping.Models.Product;
import com.myShopping.MyShopping.dto.BillDTO;
import com.myShopping.MyShopping.dto.OrderDetailsDTO;
import com.myShopping.MyShopping.dto.OrderProductDTO;
import com.myShopping.MyShopping.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class BuyerService {

    @Autowired
    UserService userService;

    @Autowired
    ProductService productService;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    MailService mailService;
    public BillDTO placeOrder(List<OrderDetailsDTO> orderDetailsDTOList, UUID userID) {
//    Get user by id
        /*
        * Tasks:-
        * 1. Verify user who is placing order
        * 2. Decrease orderedItems from total items available in the database
        * 3. Create bill dto
        * 4. email service
        * */
        AppUser user = userService.getUserById(userID);
        OrderTable orderTable = new OrderTable();
        BillDTO billDTO = new BillDTO();
        //Get list of product
//        we need to get products by id
        int totalQuantity = 0;
        int totalPrice = 0;
        List<Product> products = new ArrayList<>();
        List<OrderProductDTO> orderProductDTOS = new ArrayList<>();
        for(OrderDetailsDTO orderDetailsDTO : orderDetailsDTOList) {
            OrderProductDTO orderProduct = new OrderProductDTO();
            UUID productId = orderDetailsDTO.getId();
            orderProduct.setProductId(productId);
            totalQuantity += orderDetailsDTO.getQuantity();
            Product product = productService.getProductById(productId);
            orderProduct.setProductName(product.getName());
            orderProduct.setQuantity(orderDetailsDTO.getQuantity());
//            particular how many current product total price
            totalPrice += (orderDetailsDTO.getQuantity() * product.getPrice());
            products.add(product);
            orderTable.setPaymentMode(orderDetailsDTO.getPaymentMode());
            orderProductDTOS.add(orderProduct);
            int updatedQuantity = product.getQuantity() - orderProduct.getQuantity();
            productService.updateProductQuantity(productId, updatedQuantity);
        }
        billDTO.setBuyerId(user.getId());
        billDTO.setBuyerName(user.getName());
        billDTO.setTotalPrice(totalPrice);
        billDTO.setTotalQuantity(totalQuantity);
        billDTO.setEmailId(user.getEmail());
        billDTO.setOrderProducts(orderProductDTOS);
        orderTable.setUser(user);
        orderTable.setStatus("Not Delivered");
        orderTable.setTotalPrice(totalPrice);
        orderTable.setTotalQuantity(totalQuantity);
        orderTable.setProducts(products);

        orderRepository.save(orderTable);
        billDTO.setBillId(orderTable.getOrderId());

        mailService.sendMail("Order got placed", user.getEmail(), "Congratulations!");
        return billDTO;

    }
}
