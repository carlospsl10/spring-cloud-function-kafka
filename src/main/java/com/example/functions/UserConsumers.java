package com.example.functions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Slf4j
@Component
public class UserConsumers {

    @Bean
    public Consumer<?> userCreatedEvent() {
        return user -> log.info("User Created Event {}", user);
    }

    @Bean
    public Consumer<?> userUpdatedEvent() {
        return user -> log.info("User Updated Event {}", user);
    }

    @Bean
    public Consumer<?> devNull() {
        return message -> log.info("discarded message {}", message);
    }
}
