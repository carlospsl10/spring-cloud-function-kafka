package com.example.functions;

import org.springframework.cloud.function.context.MessageRoutingCallback;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Optional;

@Component
public class CustomMessageRoutingCallback implements MessageRoutingCallback {
    public static final String EVENT_TYPE = "event_type";

    @Override
    public String functionDefinition(Message<?> message) {
        return Optional.of(message.getHeaders())
                .filter(headers -> headers.containsKey(EVENT_TYPE))
                .map(messageHeaders -> messageHeaders.get(EVENT_TYPE))
                .map(eventType -> EventTypeToBinding.valueOf((String) eventType))
                .map(EventTypeToBinding::getBinding)
                .orElseThrow(() -> new IllegalStateException("event_type was not recognized !! supported values are " + Arrays.toString(EventTypeToBinding.values())));
    }
}
