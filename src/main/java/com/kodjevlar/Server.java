package com.kodjevlar;

import com.mongodb.MongoClient;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import static spark.Spark.*;

public class Server {
    public static void main(String[] args) {
        LikeCtrl ctrl = new LikeCtrl();

        port(8080);

        exception(Exception.class, (e, req, res) -> e.printStackTrace());

        get("/like/:id", (req, res)  -> ctrl.getLike(req, res));
        get("/like", (req, res)      -> ctrl.getLikes(req, res));
        get("/status", (req, res)    -> ctrl.getStatus(req, res));
    }
}
