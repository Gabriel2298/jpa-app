package com.itscool.jpa.controllers;

import com.itscool.jpa.models.Order;
import com.itscool.jpa.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService service;

    @PostMapping
    public ResponseEntity<Order> placeOrder(@RequestParam Long userId, @RequestParam String product, @RequestParam Double price){
        Order order = service.placeOrder(userId, product, price);
        return ResponseEntity.ok(order);
    }
    @GetMapping
    public ResponseEntity<List<Order>> ordersWithPagination(@RequestParam Long userId, @RequestParam int page, @RequestParam int size){
        List<Order> orders =service.getOrderWithPagination(userId,page,size);
        return ResponseEntity.ok(orders);
    }
}
