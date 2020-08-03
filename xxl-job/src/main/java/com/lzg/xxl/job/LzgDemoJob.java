package com.lzg.xxl.job;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;
import com.xxl.job.core.log.XxlJobLogger;
import org.springframework.stereotype.Component;

@Component
public class LzgDemoJob {

    @XxlJob("demoHandler")
    public ReturnT<String> execute(String param) {
        System.out.println(">>>>> Hello World <<<<<");
        XxlJobLogger.log("hello world.");
        return ReturnT.SUCCESS;
    }

}
