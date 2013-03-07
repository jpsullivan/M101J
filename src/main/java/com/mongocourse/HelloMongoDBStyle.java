package com.mongocourse;

import com.mongodb.*;

import java.net.UnknownHostException;

public class HelloMongoDBStyle {
    public static void main( String[] args ) throws UnknownHostException {
        MongoClient client = new MongoClient(new ServerAddress("localhost", 27017));

        DB database = client.getDB("course");
        DBCollection collection = database.getCollection("hello");

        DBObject document = collection.findOne();
        System.out.println(document);
    }
}
