package com.example.api_gateway.service;

import com.example.api_gateway.constants.OrderAPIEndpoints;
import com.example.api_gateway.dto.OrderRequestDTO;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {



    private final RestTemplate restTemplate;

    private final OrderAPIEndpoints orderAPIEndpoints;

    private HttpHeaders headers;


    public OrderService(RestTemplate restTemplate, OrderAPIEndpoints orderAPIEndpoints) {
        this.restTemplate = restTemplate;
        this.orderAPIEndpoints = orderAPIEndpoints;
        headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
    }

    public String createOrder(OrderRequestDTO requestDTO) {
        String response = restTemplate.exchange(orderAPIEndpoints.getCreateOrderUrl(), HttpMethod.POST,
                new HttpEntity<>(requestDTO, headers), String.class).getBody();
        return response;
    }



    public String getAll() {
        String response = restTemplate.exchange(orderAPIEndpoints.getGetAllOrdersUrl(), HttpMethod.GET,
                new HttpEntity<>(headers), String.class).getBody();
        return response;
    }
}
