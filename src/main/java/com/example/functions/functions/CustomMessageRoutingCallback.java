package com.example.functions.functions;

import org.springframework.cloud.function.context.MessageRoutingCallback;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Optional;

@Component
public class CustomMessageRoutingCallback implements MessageRoutingCallback {
    public static final String EVENT_TYPE = "event_type";
    public static final String DOMAIN_VALUE = "domain";

    @Override
    public String functionDefinition(Message<?> message) {
        return Optional.of(message.getHeaders())
                .filter(headers -> containHeadersValidation(headers))
                .map(headers -> EventTypeToBinding.valueOf(String.format("%s_%s",
                        headers.get(DOMAIN_VALUE).toString().toUpperCase(), headers.get(EVENT_TYPE))))
                .map(EventTypeToBinding::getBinding)
                .orElseThrow(() -> new IllegalStateException("event_type was not recognized !! supported values are "
                        + Arrays.toString(EventTypeToBinding.values())));
    }

    /**
     * Contain headers validation
     *
     * @param headers The headers
     * @return A boolean
     */
    private boolean containHeadersValidation(MessageHeaders headers) {
        return headers.containsKey(EVENT_TYPE) && headers.containsKey(DOMAIN_VALUE);
    }

}

