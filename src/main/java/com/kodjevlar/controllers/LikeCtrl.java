package com.kodjevlar.controllers;

import com.kodjevlar.utils.Mongo;
import com.kodjevlar.enums.ENTITY;
import com.kodjevlar.models.Like;
import com.kodjevlar.models.User;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import spark.Request;
import spark.Response;

public class LikeCtrl {
    Mongo mongo;

    public LikeCtrl() {
        this.mongo = new Mongo().init();
    }

    public String getLikes(Request req, Response res ) {
        return "Returning likes";
    }

    public String getStatus(Request req, Response res ) {
        return "Service is running...";
    }

    public String getLike(Request req, Response res) throws Exception {
        String userId = req.params("id");
        Like like;

        like = new Like();
        User u = new User();

        User user = this.mongo.userDAO.getUserById(new ObjectId(userId));

        return user.getId().toString();
    }
}
