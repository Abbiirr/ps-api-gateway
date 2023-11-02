package com.example.api_gateway.service;

import com.example.api_gateway.constants.PaymentAPIEndpoints;
import com.example.api_gateway.dto.PaymentRequestDTO;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class PaymentService {

    private final RestTemplate restTemplate;

    private HttpHeaders headers;

    private final PaymentAPIEndpoints paymentAPIEndpoints;


    public PaymentService(RestTemplate restTemplate, PaymentAPIEndpoints paymentAPIEndpoints, PaymentAPIEndpoints paymentAPIEndpoints1) {
        this.restTemplate = restTemplate;
        this.paymentAPIEndpoints = paymentAPIEndpoints1;
        headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

    }

    public String getAllUsers() {
        String response = restTemplate.exchange(paymentAPIEndpoints.getGetAllPaymentsUrl(), HttpMethod.GET,
                new HttpEntity<>(headers), String.class).getBody();
        return response;
    }

    public String debit(PaymentRequestDTO requestDTO) {
        String response = restTemplate.exchange(paymentAPIEndpoints.getDebitPaymentUrl(), HttpMethod.POST,
                new HttpEntity<>(requestDTO, headers), String.class).getBody();
        return response;
    }

    public String credit(PaymentRequestDTO requestDTO) {
        String response = restTemplate.exchange(paymentAPIEndpoints.getCreditPaymentUrl(), HttpMethod.POST,
                new HttpEntity<>(requestDTO, headers), String.class).getBody();
        return response;
    }
}
