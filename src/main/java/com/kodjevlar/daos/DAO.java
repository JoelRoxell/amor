package com.kodjevlar.daos;

import com.kodjevlar.utils.Mongo;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.annotations.NotSaved;
import org.mongodb.morphia.annotations.Transient;

public class DAO<T> {
    private Datastore ds;
    private T type;

    public DAO(T type, Datastore ds) {
        this.type = type;
        this.ds = ds;
    }

    public T save() {
        Mongo.getDatastore().save(this);

        return null;
    }

    public void remove() {
        Mongo.getDatastore().delete(this);
    }
}
