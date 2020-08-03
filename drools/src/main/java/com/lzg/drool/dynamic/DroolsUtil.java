package com.lzg.drool.dynamic;

public class DroolsUtil {

    public static String generateDrl(String lhs) {
        StringBuilder drool_builder = new StringBuilder();
        drool_builder.append("package fms;\n");
        drool_builder.append("import ").append(Fact.class.getName()).append(";\r\n");
        drool_builder.append("\r\n");
        drool_builder.append("rule \"rule_fms\" \r\n");
        drool_builder.append("when\n");
        drool_builder.append("\t$fact: Fact(").append(lhs).append(")").append("\r\n");
        drool_builder.append("\tthen\r\n");
        drool_builder.append("\t\tSystem.out.println(\"规则触发了\");\r\n");
        drool_builder.append("\t\t$fact.setPass(true);\r\n");
        drool_builder.append("end\n");

        return drool_builder.toString();
    }

    public static void main(String[] args) {
        String lhs = "((userName == \"jack\" || age == 10) && amount > 100)";

        System.out.println(DroolsUtil.generateDrl(lhs));
    }

}
