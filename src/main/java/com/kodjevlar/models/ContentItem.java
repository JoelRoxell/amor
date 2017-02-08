package com.kodjevlar.models;

import com.kodjevlar.enums.ENTITY;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Reference;

import java.util.ArrayList;
import java.util.HashMap;

public class ContentItem {
    ObjectId id;
    HashMap meta;
    @Reference
    ArrayList<Like> likes;

    ContentItem() {
        this.id = new ObjectId();
    }

    ContentItem(Entity entityType) {
        this.meta.put("type", entityType);
    }

    int getLikeCount() {
        return this.likes.size();
    }
}
