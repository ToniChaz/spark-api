package org.sparkapi.app.utils;

import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

/**
 * Connection with mongo data base
 *
 * @author  Toni Chaz
 * @version 1.0
 * @since   2018-12-22
 */
public class ConnectionDB {

    /**
     * Simply displays an a string to the standard output.
     *
     * @param collection [String] The collection to return
     * @throws MongoException The mongo general exception
     */
    public static MongoCollection getCollection(String collection) throws MongoException {

        // TODO pass all parameters from environment variables
        // Creating a mongo client
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        Log.sout("Connected to database");

        // Get the mongo database
        MongoDatabase database = mongoClient.getDatabase("sparkapi");

        // return the selected collection
        return database.getCollection(collection);
    }
}
