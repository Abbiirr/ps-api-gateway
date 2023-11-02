package com.example.api_gateway.constants;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class OrderAPIEndpoints {

    @Value("${external.order_service.ip}")
    private String orderServiceIp;

    @Value("${external.order_service.port}")
    private String orderServicePort;

    @Value("${endpoint.order}")
    private String orderEndpoint;

    @Value("${endpoint.create}")
    private String createEndpoint;

    @Value("${endpoint.get.all}")
    private String getAllEndpoint;

    private String getOrderUrl() {
        return orderServiceIp + ":" + orderServicePort + orderEndpoint;
    }

    public String getCreateOrderUrl() {
        return getOrderUrl() + createEndpoint;
    }

    public String getGetAllOrdersUrl() {
        return getOrderUrl() + getAllEndpoint;
    }
}
