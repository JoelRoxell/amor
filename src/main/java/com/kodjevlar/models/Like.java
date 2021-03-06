package com.kodjevlar.models;

import com.kodjevlar.enums.ENTITY;
import com.kodjevlar.models.User;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Reference;

import java.util.ArrayList;

@Entity("likes")
public class Like {
    @Id
    private ObjectId id;
    @Reference
    private ContentItem contentItem;

    public Like() {}

    public Like(User user, ContentItem contentItem) {
        super();

        this.contentItem = contentItem;
    }

    public static ArrayList<Like> getLikesByUser(User user) {
        return null;
    }

    public static boolean remove(User user, ContentItem contentItem) {
        return false;
    }
}
