package com.example.functions.functions.ticket;

import com.example.functions.functions.Ticket;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.Message;

import java.util.function.Consumer;

@Slf4j
public class TicketCreatedEvent implements Consumer<Message<Ticket>> {
    @Override
    public void accept(Message<Ticket> ticketMessage) {
        log.info("Ticket {} was created", ticketMessage.getPayload().getName());
    }
}
