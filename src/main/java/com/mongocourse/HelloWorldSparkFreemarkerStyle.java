package com.mongocourse;

import freemarker.template.Configuration;
import freemarker.template.Template;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

public class HelloWorldSparkFreemarkerStyle {
    public static void main(String[] args) {
        final Configuration config = new Configuration();
        config.setClassForTemplateLoading(HelloWorldSparkFreemarkerStyle.class, "/");

        Spark.get(new Route("/") {
            @Override
            public Object handle(final Request request, final Response response) {
                StringWriter writer = new StringWriter();

                try {
                    Template helloTmpl = config.getTemplate("hello.ftl");
                    Map<String, Object> helloMap = new HashMap<String, Object>();
                    helloMap.put("name", "Freemarker");

                    helloTmpl.process(helloMap, writer);
                } catch(Exception e) {
                    halt(500);
                    e.printStackTrace();
                }

                return writer;
            }
        });
    }
}
