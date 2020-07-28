package com.lzg.client;

import org.springframework.stereotype.Component;

@Component
public class RemoteFallback implements RemoteClient{


    @Override
    public String hello(String name) {
        return "fallback";
    }

}
