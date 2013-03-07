package com.mongocourse_w2;

import com.mongodb.*;

import java.net.UnknownHostException;
import java.util.Random;

public class FindTest {
    public static void main(String[] args) throws UnknownHostException {
        MongoClient client = new MongoClient();
        DB db = client.getDB("course");
        DBCollection collection = db.getCollection("findTest");

        for (int i = 0; i < 10; i++) {
            collection.insert(new BasicDBObject("x", new Random().nextInt(100)));
        }

        System.out.println("Find one: ");
        DBObject doc = collection.findOne();

        System.out.println("\nFind all: ");
        DBCursor cursor = collection.find();
        try {
            while(cursor.hasNext()) {
                DBObject cur = cursor.next();
                System.out.println(cur);
            }
        } finally {
            cursor.close();
        }

        System.out.println("\nCount: ");
        long count = collection.count();
        System.out.println(count);
    }
}
