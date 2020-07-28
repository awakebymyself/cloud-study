package com.lzg.kafka.kafka;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@EnableBinding(Sink.class)
public class Consumer {

    @StreamListener(Sink.INPUT)
    public void consume(String msg) {
        System.out.println(">>>>>> Receive msg:" + msg);
    }

}
