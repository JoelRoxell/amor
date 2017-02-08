package com.kodjevlar.utils;

import com.kodjevlar.daos.UserDAO;
import com.kodjevlar.models.User;
import com.mongodb.MongoClient;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

public class Mongo {
    private Morphia morphia;
    public Datastore datastore;
    public UserDAO userDAO;

    public Mongo init() {
        this.morphia = new Morphia();
        this.morphia.mapPackage("com.kodjevlar");

        this.datastore = this.morphia.createDatastore(
                new MongoClient(),
                "like_example"
        );

        datastore.ensureIndexes();

        this.userDAO = new UserDAO(User.class, this.datastore);

        return this;
    }
}
