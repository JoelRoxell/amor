package com.kodjevlar.controllers;

import com.kodjevlar.models.ContentItem;
import com.kodjevlar.models.JSONResponse;
import com.kodjevlar.utils.Mongo;
import spark.Request;
import spark.Response;

public class ContentItemCtrl {
    public String getContentItem(Request req, Response res) {
        String id = req.params("id");

        final ContentItem item = ContentItem.findById(id);

        return item.toJSON();
    }

    public String createContentItem(Request req, Response res) {
        ContentItem ci = new ContentItem();
        ContentItem ci1 = new ContentItem();

        Mongo.getDatastore().save(ci);

        return ci.toJSON();
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
