package com.example.api_gateway.entity;


import com.example.api_gateway.enums.EventStatus;
import com.example.api_gateway.enums.EventType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.util.UUID;

@RedisHash("Event")
@RequiredArgsConstructor
@AllArgsConstructor
@Data
@EntityScan
@Builder
public class Event {
    @Id
    private String eventId;
    private EventStatus eventStatus;
    private EventType eventType;
    private int eventStep;
    private boolean isRollBack;
}
