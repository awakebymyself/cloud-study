package com.lzg.kafka.kafka;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.support.ErrorMessage;

@EnableBinding(Sink.class)
public class Consumer {

    @StreamListener(Sink.INPUT)
    public void consume(String msg) throws InterruptedException {
        Thread.sleep(1000);
        System.out.println(">>>>>> Receive msg:" + msg);
     //   throw new RuntimeException("Mock consume fail");
    }

 //  @ServiceActivator(inputChannel = "DEMO-TOPIC-02.demo01-consumer-group.errors")
    public void handleError(ErrorMessage errorMessage) {
        System.out.println("[handleError][payload：{}]>>>:" + errorMessage.getPayload().getMessage());
        System.out.println("[handleError][originalMessage：{}] >>>:" + errorMessage.getOriginalMessage());
        System.out.println("[handleError][headers：{}]>>>:" + errorMessage.getHeaders());
    }



    public void globalHandleError(ErrorMessage errorMessage) {
        System.out.println("[global][payload：{}]>>>:" + errorMessage.getPayload().getMessage());
        System.out.println("[global][originalMessage：{}] >>>:" + errorMessage.getOriginalMessage());
        System.out.println("[global][headers：{}]>>>:" + errorMessage.getHeaders());
    }

}
