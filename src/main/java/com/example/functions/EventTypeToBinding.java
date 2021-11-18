package com.example.functions;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum EventTypeToBinding {
    USER_CREATED_EVENT("userCreatedEvent"),
    USER_UPDATED_EVENT("userUpdatedEvent");

    private final String binding;
}
