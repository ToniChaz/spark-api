package org.sparkapi.app;

import static spark.Spark.*;

import org.sparkapi.app.persistence.dao.impl.UserDaoImpl;
import org.sparkapi.app.persistence.entities.UserDto;
import org.sparkapi.app.services.UserService;
import org.sparkapi.app.utils.Log;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * The App main class
 * Here starts the application
 *
 * @author Toni Chaz
 * @version 1.0
 * @since 2018-12-22
 */
public class App {
    public static void main(String[] args) {

        exception(Exception.class, (e, req, res) -> e.printStackTrace()); // print all exceptions

        UserService userService = new UserService();
        userService.initUserServices();


        get("/init-users", (req, res) -> {
            Log.sout("/init-users service called");

            UserDto user1 = new UserDto("Mike", 45, "male");
            UserDto user2 = new UserDto("Ali", 22, "female");

            List<Document> users = new ArrayList<>();

            users.add(user1.toBsonDocument());
            users.add(user2.toBsonDocument());

            try {
                UserDaoImpl userDaoImpl = new UserDaoImpl();
                userDaoImpl.insertMany(users);
                return "User has been created";
            } catch (Exception error) {
                return "An error occurred: " + error.getMessage();
            }
        });

    }
}
