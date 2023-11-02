package com.example.api_gateway.service;

import com.example.api_gateway.dto.CheckoutRequestDTO;
import com.example.api_gateway.dto.ProductRequestDTO;
import com.example.api_gateway.enums.KafkaTopics;
import com.example.api_gateway.helper.KafkaMessager;
import org.springframework.stereotype.Service;

@Service
public class ProductEventService {

    private final KafkaMessager kafkaMessager;

    public ProductEventService(KafkaMessager kafkaMessager) {
        this.kafkaMessager = kafkaMessager;
    }


//    public String deductProduct(ProductRequestDTO requestDTO) {
//        return kafkaMessager.sendMessage(KafkaTopics.DEDUCT_PRODUCT.getTopicName(), requestDTO);
//    }
//
//    public String checkout(CheckoutRequestDTO requestDTO) {
//        return kafkaMessager.sendMessage(KafkaTopics.CHECKOUT_PRODUCT.getTopicName(), requestDTO);
//    }

//    public String addProduct(ProductRequestDTO requestDTO) {
//        return kafkaMessager.sendMessage(KafkaTopics.ADD_PRODUCT.getTopicName(), requestDTO);
//    }
//
//    public String getAllProducts() {
//        return kafkaMessager.sendMessage(KafkaTopics.GET_ALL_PRODUCTS.getTopicName(), "");
//    }
}
