package com.mongocourse;

import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

public class HelloWorldFreemarkerStyle {
    public static void main(String[] args) {
        Configuration config = new Configuration();
        config.setClassForTemplateLoading(HelloWorldSparkFreemarkerStyle.class, "/");

        try {
            Template helloTmpl = config.getTemplate("hello.ftl");
            StringWriter writer = new StringWriter();
            Map<String, Object> helloMap = new HashMap<String, Object>();
            helloMap.put("name", "Freemarker");

            helloTmpl.process(helloMap, writer);
            System.out.println(writer);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
