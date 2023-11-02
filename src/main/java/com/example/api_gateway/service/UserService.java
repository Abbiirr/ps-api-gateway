package com.example.api_gateway.service;

import com.example.api_gateway.constants.ProductAPIEndpoints;
import com.example.api_gateway.dto.PaymentRequestDTO;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {
    private final RestTemplate restTemplate;
    private HttpHeaders headers;

    public UserService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        this.headers = new HttpHeaders();
    }

    public String getAllUsers() {
        HttpEntity<String> requestEntity = new HttpEntity<>(headers);
        return restTemplate.exchange(ProductAPIEndpoints.getGetAllProductsUrl(), HttpMethod.GET, requestEntity, String.class).getBody();
    }

    public String debit(PaymentRequestDTO requestDTO) {
        String response = restTemplate.exchange(ProductAPIEndpoints.getDeductProductUrl(), HttpMethod.POST,
                new HttpEntity<>(requestDTO, headers), String.class).getBody();
        return response;
    }

}
