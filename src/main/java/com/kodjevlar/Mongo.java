package com.kodjevlar;

import com.mongodb.MongoClient;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

public class Mongo {
    private Morphia morphia;
    public Datastore datastore;

    Datastore init() {
        this.morphia = new Morphia();
        this.morphia.mapPackage("kodjevlar");

        this.datastore = this.morphia.createDatastore(
                new MongoClient(),
                "like_example"
        );

        datastore.ensureIndexes();

        return this.datastore;
    }
}
