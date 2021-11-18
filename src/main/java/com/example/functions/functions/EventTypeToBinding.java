package com.example.functions.functions;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum EventTypeToBinding {
    USER_CREATED_EVENT("userCreatedEvent"),
    USER_UPDATED_EVENT("userUpdatedEvent"),
    TICKET_CREATED_EVENT("ticketCreatedEvent");

    private final String binding;
}
