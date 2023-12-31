package com.example.api_gateway.service;

import com.example.api_gateway.dto.PaymentRequestDTO;
import com.example.api_gateway.enums.EventType;
import com.example.api_gateway.enums.KafkaTopics;
import com.example.api_gateway.helper.EventCreator;
import com.example.api_gateway.helper.KafkaMessager;
import org.springframework.stereotype.Service;

@Service
public class PaymentEventService {

    private final KafkaMessager kafkaMessager;

    private final EventCreator eventCreator;

    public PaymentEventService(KafkaMessager kafkaMessager, EventCreator eventCreator) {
        this.kafkaMessager = kafkaMessager;
        this.eventCreator = eventCreator;
    }

//    public String debit(PaymentRequestDTO requestDTO) {
//        return kafkaMessager.sendMessage(KafkaTopics.DEBIT_PAYMENT.getTopicName(), requestDTO);
//    }
//
//    public String credit(PaymentRequestDTO requestDTO) {
//        return kafkaMessager.sendMessage(KafkaTopics.CREDIT_PAYMENT.getTopicName(), requestDTO);
//    }
//
//    public String getAllUsers() {
//        return kafkaMessager.sendMessage(KafkaTopics.GET_ALL_USERS.getTopicName(), "");
//    }

    public String pay(PaymentRequestDTO requestDTO) {
        requestDTO.setEventId(eventCreator.createNewEvent(EventType.PURCHASE_SINGLE));
        return kafkaMessager.sendMessage(KafkaTopics.PAYMENT_REQUEST.getTopicName(), requestDTO);
    }
}
