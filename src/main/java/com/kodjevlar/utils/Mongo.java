package com.kodjevlar.utils;

import com.kodjevlar.daos.UserDAO;
import com.kodjevlar.models.User;
import com.mongodb.MongoClient;
import jdk.internal.dynalink.MonomorphicCallSite;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import javax.activation.DataSource;

public class Mongo {
    private static Morphia morphia;
    private static Datastore datastore;
    private static UserDAO userDAO;

    /**
     * Instantiate a new mongodb connection, map data models to storage using Morphia.
     * @return Mongo
     */
    public static Datastore getConnection() {
        Mongo.morphia = new Morphia();
        Mongo.morphia.mapPackage("com.kodjevlar.models");

        Mongo.datastore = Mongo.morphia.createDatastore(
                new MongoClient(),
                "like_example"
        );

        Mongo.datastore.ensureIndexes();
        Mongo.userDAO = new UserDAO(User.class, Mongo.datastore);

        return datastore;
    }

    /**
     * @return Datastore
     */
    public static Datastore getDatastore() {
        if (Mongo.datastore == null) {
            Mongo.getConnection();
        }

        return Mongo.datastore;
    }

    /*
     * @return userDAO
     */
    public static UserDAO getUserDAO() {
        return Mongo.userDAO;
    }
}
