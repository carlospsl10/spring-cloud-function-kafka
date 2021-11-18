package com.example.functions;

import com.example.functions.functions.User;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserPublisher {

    private final StreamBridge bridge;

    public UserPublisher(StreamBridge bridge) {
        this.bridge = bridge;
    }

    @PostMapping("/{event}")
    public void userSupplier(@PathVariable("event") String event) {
        var message = MessageBuilder
                .withPayload(User.builder().name("Carlos").build())
                .setHeader("event_type", event)
                .setHeader("domain", "User")
                .build();

        bridge.send("user", message);
    }
}



