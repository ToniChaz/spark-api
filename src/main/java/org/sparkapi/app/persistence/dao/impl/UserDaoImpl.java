package org.sparkapi.app.persistence.dao.impl;

import org.bson.Document;
import org.sparkapi.app.persistence.dao.UserDao;
import org.sparkapi.app.persistence.entities.UserDto;

import java.util.List;


public class UserDaoImpl extends AbstractFactory<UserDto> implements UserDao {

    public UserDaoImpl() {
        super(UserDto.class, "users");
    }

    @Override
    public Document insert(Document user) {
        return super.insert(user);
    }

    @Override
    public List<Document> insertMany(List<Document> users) {
        return super.insertMany(users);
    }

    @Override
    public StringBuffer find() {
        return super.find();
    }
}
