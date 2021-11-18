package com.example.functions;

import com.example.functions.functions.User;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ticket")
public class TicketPublisher {
    private final StreamBridge bridge;

    public TicketPublisher(StreamBridge bridge) {
        this.bridge = bridge;
    }

    @PostMapping("/{event}")
    public void userSupplier(@PathVariable("event") String event) {
        var message = MessageBuilder
                .withPayload(User.builder().name("Col").build())
                .setHeader("event_type", event)
                .setHeader("domain", "Ticket")
                .build();

        bridge.send("ticket", message);
    }
}
