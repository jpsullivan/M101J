package com.mongocourse_w2;


import com.mongodb.*;

import java.net.UnknownHostException;
import java.util.Arrays;

public class InsertTest {
    public static void main(String[] args) throws UnknownHostException {
        MongoClient client = new MongoClient();
        DB courseDB = client.getDB("course");
        DBCollection collection = courseDB.getCollection("insertTest");

        DBObject doc = new BasicDBObject().append("x", 1);
        DBObject doc2 = new BasicDBObject().append("x", 2);

        System.out.println(doc);

        collection.insert(Arrays.asList(doc, doc2));

        System.out.println(doc);
    }
}
