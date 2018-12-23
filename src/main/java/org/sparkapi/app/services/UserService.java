package org.sparkapi.app.services;

import org.sparkapi.app.persistence.dao.impl.UserDaoImpl;
import org.sparkapi.app.utils.Log;

import static spark.Spark.*;

public class UserService {

    public void initUserServices() {
        exception(Exception.class, (e, req, res) -> e.printStackTrace()); // print all exceptions

        get("/get-users", (req, res) -> {
            Log.sout("/get-users service called");
            UserDaoImpl userDaoImpl = new UserDaoImpl();
            return userDaoImpl.find();
        });
    }
}
