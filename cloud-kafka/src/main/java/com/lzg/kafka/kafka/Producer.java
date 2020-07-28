package com.lzg.kafka.kafka;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;

@EnableBinding(Source.class)
public class Producer {

    private final Source source;

    public Producer(Source source) {
        this.source = source;
    }

    public Source getSource() {
        return source;
    }

}
