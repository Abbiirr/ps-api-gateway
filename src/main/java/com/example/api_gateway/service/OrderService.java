package com.example.api_gateway.service;

import com.example.api_gateway.constants.OrderAPIEndpoints;
import com.example.api_gateway.constants.PaymentAPIEndpoints;
import com.example.api_gateway.dto.OrderRequestDTO;
import com.example.api_gateway.dto.PaymentRequestDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {



    private final RestTemplate restTemplate;

    private HttpHeaders headers;


    public OrderService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
    }

    public String createOrder(OrderRequestDTO requestDTO) {
        String response = restTemplate.exchange(OrderAPIEndpoints.getGetAllOrdersUrl(), HttpMethod.POST,
                new HttpEntity<>(requestDTO, headers), String.class).getBody();
        return response;
    }



    public String getAll() {
        String response = restTemplate.exchange(OrderAPIEndpoints.getCreateOrderUrl(), HttpMethod.GET,
                new HttpEntity<>(headers), String.class).getBody();
        return response;
    }
}
