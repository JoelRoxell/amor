package com.kodjevlar;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import spark.Request;
import spark.Response;

public class LikeCtrl {
    Datastore db;

    LikeCtrl() {
        this.db = new Mongo().init();
    }

    public String getLikes(Request req, Response res ) {
        return "Returning likes";
    }

    public String getStatus(Request req, Response res ) {
        return "Service is running...";
    }

    public String getLike(Request req, Response res) {
        String id = req.params("id");
        Like like;

        try {
            like = new Like(ENTITY.PAGE);

            like.add(new ObjectId(id));

            this.db.save(like);
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        return "OK";
    }
}
