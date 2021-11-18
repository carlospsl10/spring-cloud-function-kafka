package com.example.functions.functions;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Event type to binding
 * Enum Type Convention {Domain_Event}
 */
@Getter
@RequiredArgsConstructor
public enum EventTypeToBinding {
    USER_USER_CREATED_EVENT("userCreatedEvent"),
    USER_USER_UPDATED_EVENT("userUpdatedEvent"),
    TICKET_TICKET_CREATED_EVENT("ticketCreatedEvent");

    private final String binding;
}
