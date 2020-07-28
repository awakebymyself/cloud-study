package com.lzg.client.producer;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface MsgProducer {

    @Output("producer")
    MessageChannel produceMsg();

}
