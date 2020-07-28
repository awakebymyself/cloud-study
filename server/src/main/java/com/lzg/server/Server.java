package com.lzg.server;

import com.lzg.server.message.MsgConsumer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
@EnableBinding(MsgConsumer.class)
public class Server {


    @RequestMapping("/hello")
    public String index(@RequestParam String name) {
        return "lzg";
    }

    @StreamListener(target = MsgConsumer.GREETING)
    public void consumeMsg(Object msg) {
        System.out.println("Receive msg: -----" + msg);
    }


    public static void main(String[] args) {
        SpringApplication.run(Server.class);
    }

}
