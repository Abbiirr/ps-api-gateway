package com.example.api_gateway.enums;


public enum KafkaTopics {
    CHECK_USER_STATUS("check_user_status"),
    CHECKOUT_TOPIC("checkout_topic"),
    CREATE_ORDER("create_order"),
    GET_ALL_ORDERS("get_all_orders"),
    GET_ALL_USERS("get_all_users"),
    ORDER_PAYMENT_REQUEST("order_payment_request"),
    GET_ALL_PRODUCTS("get_all_products"),
    ADD_PRODUCT("add_product"),
    DEDUCT_PRODUCT("deduct_product"),
    CHECKOUT_PRODUCT("checkout_product"),
    DEBIT_PAYMENT("debit_payment"),
    CREDIT_PAYMENT("credit_payment")
    ;

    private final String topicName;

    KafkaTopics(String topicName) {
        this.topicName = topicName;
    }

    public String getTopicName() {
        return topicName;
    }
}
