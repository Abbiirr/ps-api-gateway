package com.example.api_gateway.helper;

import com.example.api_gateway.entity.Event;
import com.example.api_gateway.enums.EventStatus;
import com.example.api_gateway.enums.EventType;
import com.example.api_gateway.repository.EventRepository;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class EventCreator {
    private final EventRepository eventRepository;

    public EventCreator(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public String createNewEvent() {
        Event event = Event.builder()
                .eventId(UUID.randomUUID().toString())
                .eventStatus(EventStatus.CREATED)
                .eventType(EventType.DIRECT)
                .eventStep(1)
                .isRollBack(false)
                .build();

        eventRepository.save(event);
        return event.getEventId();
    }

    public String createNewEvent(EventType eventType) {
        Event event = Event.builder()
                .eventId(UUID.randomUUID().toString())
                .eventStatus(EventStatus.CREATED)
                .eventType(eventType)
                .isRollBack(false)
                .eventStep(1)
                .build();

        eventRepository.save(event);
        return event.getEventId();
    }
}
