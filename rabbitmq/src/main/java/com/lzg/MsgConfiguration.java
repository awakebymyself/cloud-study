package com.lzg;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import com.lzg.rabbit.MyProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
//@EnableBinding(value = {MyProcessor.class})
//@EnableApolloConfig
public class MsgConfiguration {

    public static void main(String[] args) {
        SpringApplication.run(MsgConfiguration.class);
    }


}
