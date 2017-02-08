package com.kodjevlar.controllers;

import com.kodjevlar.utils.Mongo;
import com.kodjevlar.models.Like;
import com.kodjevlar.models.User;
import org.bson.types.ObjectId;
import spark.Request;
import spark.Response;

public class LikeCtrl {
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

        User user = Mongo.getUserDAO().getUserById(new ObjectId(userId));

        return user.getId().toString();
    }
}
