package com.kodjevlar;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Reference;

import java.util.ArrayList;
import java.util.List;

@Entity("likes")
public class Like {
    @Id
    private ObjectId id;
    private ENTITY entity;
    @Reference
    private ArrayList<ObjectId> userIds;

    public Like(ENTITY entity) {
        this.entity = entity;
        this.userIds = new ArrayList<>();
    }

    public void add(ObjectId userId) {
        this.userIds.add(userId);
    }

    public void remove(ObjectId userId) {
        final int index = this.userIds.indexOf(userId);

        this.userIds.remove(index);
    }

    public boolean isLikedByUser(ObjectId userId) {
        return this.userIds.indexOf(userId) != -1;
    }
}
