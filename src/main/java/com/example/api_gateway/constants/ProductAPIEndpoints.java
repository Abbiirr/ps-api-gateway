package com.example.api_gateway.constants;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ProductAPIEndpoints {

    @Value("${external.product_service.ip}")
    private String productServiceIp;

    @Value("${external.product_service.port}")
    private String productServicePort;

    @Value("${endpoint.product}")
    private String productEndpoint;

    @Value("${endpoint.add}")
    private String addProductEndpoint;

    @Value("${endpoint.deduct}")
    private String deductProductEndpoint;

    @Value("${endpoint.get.all}")
    private String getAllEndpoint;

    private String getProductUrl() {
        return productServiceIp + ":" + productServicePort + productEndpoint;
    }

    public String getAddProductUrl() {
        return getProductUrl() + addProductEndpoint;
    }

    public String getDeductProductUrl() {
        return getProductUrl() + deductProductEndpoint;
    }

    public String getGetAllProductsUrl() {
        return getProductUrl() + getAllEndpoint;
    }
}

