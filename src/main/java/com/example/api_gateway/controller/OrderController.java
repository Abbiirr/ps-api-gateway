package com.example.api_gateway.controller;

import com.example.api_gateway.dto.OrderRequestDTO;
import com.example.api_gateway.dto.PaymentRequestDTO;
import com.example.api_gateway.service.OrderEventService;
import com.example.api_gateway.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrderService service;

    @PostMapping("/create")
    public String createOrder(@RequestBody OrderRequestDTO requestDTO){
        return this.service.createOrder(requestDTO);
    }

    @GetMapping("/all")
    public String getOrders(){
        return this.service.getAll();
    }


}
