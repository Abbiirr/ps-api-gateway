package com.example.api_gateway.service;


import com.example.api_gateway.constants.ProductAPIEndpoints;
import com.example.api_gateway.dto.CheckoutRequestDTO;
import com.example.api_gateway.dto.ProductRequestDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductService {


    private final RestTemplate restTemplate;

    private HttpHeaders headers;
    private String productUrl;

    public ProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        this.headers = new HttpHeaders();
        this.headers.setContentType(MediaType.APPLICATION_JSON);
    }

    public String getAllProducts() {
        HttpEntity<String> requestEntity = new HttpEntity<>(headers);
        return restTemplate.exchange(ProductAPIEndpoints.getGetAllProductsUrl(), HttpMethod.GET, requestEntity, String.class).getBody();
    }

    public String deductProduct(ProductRequestDTO requestDTO) {
        String response = restTemplate.exchange(ProductAPIEndpoints.getAddProductUrl(), HttpMethod.POST,
                new HttpEntity<>(requestDTO, headers), String.class).getBody();
        return response;
    }

    public String addProduct(ProductRequestDTO requestDTO) {
        String response = restTemplate.exchange(ProductAPIEndpoints.getDeductProductUrl(), HttpMethod.POST,
                new HttpEntity<>(requestDTO, headers), String.class).getBody();
        return response;
    }

}
