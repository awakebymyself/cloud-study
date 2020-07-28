package com.lzg.drool;


import com.lzg.drool.Order;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import java.math.BigDecimal;

public class DroolTest01 {

    @Test
    public void test01() {
        KieServices kieServices = KieServices.Factory.get();

        KieContainer kieContainer = kieServices.newKieClasspathContainer();

        // default
        KieSession kieSession = kieContainer.newKieSession("kesession-rule");

        Order order = new Order();
        order.setOriginPrice(120);
//
//        Message message = new Message();
//        message.setMessage("Hello World");
//        message.setStatus(Message.HELLO);


        // 保存fact
        kieSession.insert(order);

        // 激活规则, 如果触发规则则执行
        kieSession.fireAllRules();

        System.out.println(order);

        kieSession.dispose();

    }


}
