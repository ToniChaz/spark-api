package org.sparkapi.app.persistence.dao.impl;

import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import org.bson.Document;
import org.sparkapi.app.utils.ConnectionDB;
import org.sparkapi.app.utils.Log;

import java.util.List;

@SuppressWarnings("unchecked")
public abstract class AbstractFactory<DtoType> {

    private final Class<DtoType> dtoType;
    private MongoCollection collection;


    protected AbstractFactory(Class<DtoType> clazz, String collectionName) {
        this.dtoType = clazz;
        this.collection = ConnectionDB.getCollection(collectionName);
    }

    protected Document insert(Document dto) throws MongoException {
        if (dto == null) {
            Log.sout("Data must not be null");
            throw new RuntimeException("Data must not be null");
        }

        try {
            this.collection.insertOne(dto);
            return dto;
        } catch (MongoException e) {
            Log.sout("Unable to connect to MongoDB " + e.getMessage());
            throw new MongoException("Unable to connect to MongoDB " + e.getMessage());
        }
    }

    protected List<Document> insertMany(List<Document> dtoMany) throws MongoException {
        if (dtoMany == null) {
            Log.sout("Data must not be null");
            throw new RuntimeException("Data must not be null");
        }

        try {
            this.collection.insertMany(dtoMany);
            return dtoMany;
        } catch (MongoException e) {
            Log.sout("Unable to connect to MongoDB " + e.getMessage());
            throw new MongoException("Unable to connect to MongoDB " + e.getMessage());
        }
    }

    protected StringBuffer find() throws MongoException {
        MongoCursor<Document> cursor = this.collection.find().iterator();

        try {
            StringBuffer result = new StringBuffer();

            while (cursor.hasNext()) {
                result.append(cursor.next().toJson());
            }

            return result;

        } catch (MongoException e) {
            Log.sout("Unable to connect to MongoDB " + e.getMessage());
            throw new MongoException("Unable to connect to MongoDB " + e.getMessage());
        } finally {
            cursor.close();
            Log.sout("Cursor closed");
        }
    }
}
