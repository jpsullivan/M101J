package com.mongocourse;

import com.mongodb.*;
import freemarker.template.Configuration;
import freemarker.template.Template;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

import java.io.StringWriter;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

public class HelloWorldMongoDBSparkFreemarkerStyle {
    public static void main(String[] args) throws UnknownHostException {
        final Configuration config = new Configuration();
        config.setClassForTemplateLoading(HelloWorldSparkFreemarkerStyle.class, "/");

        MongoClient client = new MongoClient(new ServerAddress("localhost", 27017));

        DB database = client.getDB("course");
        final DBCollection collection = database.getCollection("hello");

        Spark.get(new Route("/") {
            @Override
            public Object handle(final Request request, final Response response) {
                StringWriter writer = new StringWriter();

                try {
                    Template helloTmpl = config.getTemplate("hello.ftl");

                    DBObject document = collection.findOne();

                    helloTmpl.process(document, writer);
                } catch (Exception e) {
                    halt(500);
                    e.printStackTrace();
                }

                return writer;
            }
        });
    }
}
