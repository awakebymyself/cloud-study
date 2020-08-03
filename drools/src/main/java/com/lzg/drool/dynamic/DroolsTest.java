package com.lzg.drool.dynamic;

import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieSession;
import org.kie.internal.utils.KieHelper;

import java.math.BigDecimal;

public class DroolsTest {

    public static void main(String[] args) {
        KieHelper kieHelper = new KieHelper();
        String lhs = "((userName == \"jack\" || age == 10) && amount > 100)";
        String drl = DroolsUtil.generateDrl(lhs);
        System.out.println(drl);
        kieHelper.addContent(drl, ResourceType.DRL);

        KieSession kieSession = kieHelper.build().newKieSession();

        Fact fact = new Fact();
        fact.setAge(9);
        fact.setAmount(new BigDecimal("100.1"));
        fact.setUserName("mao");

        kieSession.insert(fact);

        kieSession.fireAllRules();

        System.out.println("pass:>>>>>" + fact.isPass());
        kieSession.dispose();

    }

}
