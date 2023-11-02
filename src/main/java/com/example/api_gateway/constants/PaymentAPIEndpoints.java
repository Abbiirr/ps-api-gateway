package com.example.api_gateway.constants;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PaymentAPIEndpoints {

    @Value("${external.payment_service.ip}")
    private  String paymentServiceIp;

    @Value("${external.payment_service.port}")
    private  String paymentServicePort;

    @Value("${endpoint.payment}")
    private  String paymentEndpoint;

    @Value("${endpoint.debit}")
    private  String debitPaymentEndpoint;

    @Value("${endpoint.credit}")
    private  String creditPaymentEndpoint;

    @Value("${endpoint.get.all}")
    private  String getAllEndpoint;

    private  String getPaymentUrl() {
        return paymentServiceIp + ":" + paymentServicePort + paymentEndpoint;
    }

    public  String getDebitPaymentUrl() {
        return getPaymentUrl() + debitPaymentEndpoint;
    }

    public  String getCreditPaymentUrl() {
        return getPaymentUrl() + creditPaymentEndpoint;
    }

    public  String getGetAllPaymentsUrl() {
        return getPaymentUrl() + getAllEndpoint;
    }
}
