package com.lzg.server.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface MsgConsumer {

    String GREETING = "producer";

    @Input(GREETING)
    SubscribableChannel consumer();

}
