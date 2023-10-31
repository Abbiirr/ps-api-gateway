package com.example.api_gateway.service;

import com.example.api_gateway.dto.OrderRequestDTO;
import com.example.api_gateway.dto.PaymentRequestDTO;
import com.example.api_gateway.enums.KafkaTopics;
import com.example.api_gateway.helper.KafkaMessager;
import org.springframework.stereotype.Service;

@Service
public class OrderEventService {

    private final KafkaMessager kafkaMessager;

    public OrderEventService(KafkaMessager kafkaMessager) {
        this.kafkaMessager = kafkaMessager;
    }

    public String createOrder(OrderRequestDTO requestDTO) {
        return kafkaMessager.sendMessage(KafkaTopics.CREATE_ORDER.getTopicName(), requestDTO);
    }

    public String createPaymentRequest(PaymentRequestDTO requestDTO) {
        return kafkaMessager.sendMessage(KafkaTopics.ORDER_PAYMENT_REQUEST.getTopicName(), requestDTO);
    }

    public String getAll() {
        return kafkaMessager.sendMessage(KafkaTopics.GET_ALL_ORDERS.getTopicName(), "");
    }
}
