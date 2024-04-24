package com.myShopping.MyShopping.repository;

import com.myShopping.MyShopping.Models.OrderTable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderRepository extends JpaRepository<OrderTable, UUID> {

}
