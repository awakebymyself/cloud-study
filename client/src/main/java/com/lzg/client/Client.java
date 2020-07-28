package com.lzg.client;

import com.lzg.client.producer.MsgProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@RestController
@EnableBinding(MsgProducer.class)
public class Client {

    @Autowired
    private RemoteClient remoteClient;

    private MessageChannel messageChannel;

    public Client(MsgProducer producer) {
        messageChannel = producer.produceMsg();
    }

    @RequestMapping("/api")
    public String home() {
        return remoteClient.hello("mao");
    }

    @GetMapping("/produceMsg")
    public String produceMsg() {
        MessageHeaders headers = new MessageHeaders(new HashMap<>());

        Message<String> hello = MessageBuilder.withPayload("hello").build();
        boolean send = messageChannel.send(hello, 10000);

        return "" + send;
    }

    public static void main(String[] args) {
        SpringApplication.run(Client.class);
    }


}
