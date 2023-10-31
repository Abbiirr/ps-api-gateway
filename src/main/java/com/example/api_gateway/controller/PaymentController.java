package com.example.api_gateway.controller;

import com.example.api_gateway.dto.PaymentRequestDTO;
import com.example.api_gateway.service.PaymentEventService;
import com.example.api_gateway.service.PaymentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("payment")
public class PaymentController {


    private final PaymentService service;
    private final PaymentEventService eventService;

    public PaymentController(PaymentService service, PaymentEventService eventService) {
        this.service = service;
        this.eventService = eventService;
    }


    @GetMapping("")
    public String getAllProducts() {
        return this.service.getAllUsers();
    }
    @PostMapping("/debit")
    public String debit(@RequestBody PaymentRequestDTO requestDTO){
        return this.service.debit(requestDTO);
    }

    @PostMapping("/credit")
    public String credit(@RequestBody PaymentRequestDTO requestDTO){
        return this.service.credit(requestDTO);
    }

    @PostMapping("/pay")
    public String pay(@RequestBody PaymentRequestDTO requestDTO){
        return this.eventService.pay(requestDTO);
    }

}
