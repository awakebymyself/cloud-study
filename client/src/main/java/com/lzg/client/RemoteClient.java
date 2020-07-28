package com.lzg.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(name = "spring-cloud-server", fallback = RemoteFallback.class)
public interface RemoteClient {

    @GetMapping(value = "/hello")
    String hello(@RequestParam(value = "name") String name);

}
