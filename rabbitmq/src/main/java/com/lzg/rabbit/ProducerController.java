package com.lzg.rabbit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {

   // @Autowired
    private MyProcessor myProcessor;

    @GetMapping
    public String warmUp() {
        return "ok";
    }

    @GetMapping("/produce")
    public String produceLog() {
        Msg msg = new Msg();
        msg.setId("1");
        msg.setName("map");

        Message<Msg> stringMessage = MessageBuilder.withPayload(msg).build();

        myProcessor.logOutput().send(stringMessage);

        return "ok";
    }


}
