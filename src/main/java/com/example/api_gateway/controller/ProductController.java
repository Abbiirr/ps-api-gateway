package com.example.api_gateway.controller;

import com.example.api_gateway.dto.CheckoutRequestDTO;
import com.example.api_gateway.dto.ProductRequestDTO;
import com.example.api_gateway.service.ProductEventService;
import com.example.api_gateway.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/all")
    public String getAllProducts() {
        return this.service.getAllProducts();
    }

    @PostMapping("/deduct")
    public String deduct(@RequestBody final ProductRequestDTO requestDTO){
        return this.service.deductProduct(requestDTO);
    }

    @PostMapping("/add")
    public String add(@RequestBody final ProductRequestDTO requestDTO){
         return this.service.addProduct(requestDTO);
    }

}
