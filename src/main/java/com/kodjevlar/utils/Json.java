package com.kodjevlar.utils;

import com.google.gson.GsonBuilder;
import com.google.gson.Gson;

import org.bson.types.ObjectId;

public class Json {
    static GsonBuilder builder = new GsonBuilder();
    static Gson parser;

    public Json() {
        if (Json.parser == null) {
            builder.registerTypeAdapter(ObjectId.class, new ObjectIdSerializer());
            Json.parser = builder.create();
        }

        this.parser = Json.parser;
    }

    public <T> String toJson(T target) {
        return Json.parser.toJson(target);
    }
}
