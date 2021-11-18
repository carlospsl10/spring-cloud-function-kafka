package com.example.functions.functions.user;

import com.example.functions.functions.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.Message;

import java.util.function.Consumer;

@Slf4j
public class UserUpdatedEvent implements Consumer<Message<User>> {
    @Override
    public void accept(Message<User> userMessage) {
        log.info("Hi again {}", userMessage.getPayload().getName().concat(" - Event Type : ")
                .concat(userMessage.getHeaders().get("event_type").toString()));
    }
}
