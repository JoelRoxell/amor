package com.kodjevlar;

import com.kodjevlar.consumers.ContentItemRunner;
import com.kodjevlar.controllers.ContentItemCtrl;
import com.kodjevlar.controllers.LikeCtrl;
import com.kodjevlar.middleware.Auth;

import static spark.Spark.*;

public class Server {
    public static void main(String[] args) {
        LikeCtrl likeCtrl = new LikeCtrl();
        ContentItemCtrl contentItemCtrl = new ContentItemCtrl();

        String portString = System.getenv("PORT");
        // int portN = portString.isEmpty() ? 8000 : Integer.parseInt(portString);

        port(8000);

        exception(Exception.class, (e, req, res) -> e.printStackTrace());

        before("/amor/*", Auth::requireToken);

        after(((request, response) -> {
            // Always return JSON.
            // response.header("Content-Type", "application/json");
        }));


        String contentRoute = "/amor/content-item";
        String likeRoute = "/amor/like";

        // Container routes
        post(contentRoute, contentItemCtrl::createContentItem);
        get(contentRoute + "/:id", contentItemCtrl::getContentItem);
        delete(contentRoute + "/:id", contentItemCtrl::removeContentItem);

        // Like routes
        get(likeRoute, likeCtrl::getLike);
        put(likeRoute +"/:id", likeCtrl::getLike);
        delete(likeRoute + "/:id", likeCtrl::getLike);

        // Health check
        get("/amor/status", likeCtrl::getStatus);

        // Kafka thread-consumers
        ContentItemRunner ct = new ContentItemRunner();
        ct.run();
    }
}
