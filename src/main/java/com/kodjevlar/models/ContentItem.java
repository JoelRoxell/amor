package com.kodjevlar.models;

import com.google.gson.GsonBuilder;
import com.kodjevlar.utils.Json;
import com.kodjevlar.utils.Mongo;
import com.kodjevlar.utils.ObjectIdSerializer;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Reference;
import org.mongodb.morphia.query.Query;

import java.util.ArrayList;
import java.util.HashMap;

public class ContentItem {
    @Id
    ObjectId id;

    public HashMap meta;

    @Embedded
    private ArrayList<Like> likes;

    public ContentItem() {
        this.meta = new HashMap();
    }

    ContentItem(Entity entityType) {
        this();

        this.meta.put("type", entityType);
    }

    int getLikeCount() {
        return this.likes.size();
    }

    public static ContentItem findById(String contentItemId) {
        final ObjectId id = new ObjectId(contentItemId);
        final Query<ContentItem> findContentItem = Mongo.getDatastore().createQuery(ContentItem.class);

        return findContentItem.field("id").equal(id).get();
    }

    public String toJSON() {
        return new Json().toJson(this);
    }
}
