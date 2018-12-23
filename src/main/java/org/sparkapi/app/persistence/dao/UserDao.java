package org.sparkapi.app.persistence.dao;

import org.bson.Document;

import java.util.List;

public interface UserDao {

        Document insert(Document user);

        List<Document> insertMany(List<Document> users);

        StringBuffer find();
}
