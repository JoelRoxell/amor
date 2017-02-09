package com.kodjevlar.controllers;

import com.kodjevlar.models.ContentItem;
import com.kodjevlar.models.JSONResponse;
import com.kodjevlar.producers.ContainerProducer;
import com.kodjevlar.utils.Mongo;
import com.sun.xml.internal.ws.api.server.Container;
import spark.Request;
import spark.Response;

public class ContentItemCtrl {
    public String getContentItem(Request req, Response res) {
        String id = req.params("id");

        final ContentItem item = ContentItem.findById(id);

        return item.toJSON();
    }

    // This method is only used as an producer trigger example.
    public String createContentItem(Request req, Response res) {
        ContentItem ci = new ContentItem();

        new ContainerProducer().send(ci.toJSON());

        return "OK";
    }

    public String removeContentItem(Request req, Response res) {
        String id = req.params("id");

        final ContentItem item = ContentItem.findById(id);

        if (item != null) {
            Mongo.getDatastore().delete(item);
        }

        final JSONResponse jsonResponse = new JSONResponse();

        jsonResponse.addProperty("message", "OK");

        return jsonResponse.toString();
    }
}
