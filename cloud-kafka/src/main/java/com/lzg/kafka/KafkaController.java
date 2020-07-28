package com.lzg.kafka;

import com.lzg.kafka.kafka.MessageDto;
import com.lzg.kafka.kafka.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {

    @Autowired
    private Producer producer;

    @GetMapping("hello")
    public String hello() {
        return "ok";
    }

    @GetMapping("produce")
    public String product() {
        MessageDto messageDto = new MessageDto();
        messageDto.setId(1);
        messageDto.setMessage("hello mao");

        Message<MessageDto> message = MessageBuilder.withPayload(messageDto).build();

        boolean send = producer.getSource().output().send(message);
        System.out.println("Result---->" + send);

        return "product ok !";
    }





}
