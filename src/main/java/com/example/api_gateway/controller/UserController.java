package com.example.api_gateway.controller;

import com.example.api_gateway.dto.PaymentRequestDTO;
import com.example.api_gateway.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public String getAllProducts() {
        return this.userService.getAllUsers();
    }
    @PostMapping("/add")
    public String debit(@RequestBody PaymentRequestDTO requestDTO){
        return this.userService.debit(requestDTO);
    }
}
