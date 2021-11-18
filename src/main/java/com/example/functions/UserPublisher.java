package com.example.functions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.EmitterProcessor;
import reactor.core.publisher.Flux;

import java.util.function.Supplier;

@RestController
@RequestMapping("/user")
public class UserPublisher {
    private static final String SPRING_CLOUD_STREAM_SENDTO_DESTINATION = "spring.cloud.stream.sendto.destination";

    private final StreamBridge bridge;

    public UserPublisher(StreamBridge bridge) {
        this.bridge = bridge;
    }

    @PostMapping
    public void userSupplier() {
        var message = MessageBuilder
                .withPayload(User.builder().name("Carlos").build())
                .setHeader(SPRING_CLOUD_STREAM_SENDTO_DESTINATION, "functionRouter-in-0")
                .setHeader("event_type", "USER_UPDATED_EVENT")
                .build();

        bridge.send("functionRouter-in-0", message);
    }
}



@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
 class User {
    private String name;
}