package com.kodjevlar.models;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Entity("users")
public class User {
    @Id
    private ObjectId id;

    public User() {
        this.id = new ObjectId();
    }

    public User(String id) {
        this.id = new ObjectId(id);
    }

    public ObjectId getId() {
        return id;
    }
}
