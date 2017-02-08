package com.kodjevlar.models;

import com.kodjevlar.utils.Json;

import java.util.HashMap;

public class JSONResponse {
    private HashMap body;

    public JSONResponse() {
        this.body = new HashMap();
    }

    public HashMap getBody() {
        return body;
    }

    public <T> JSONResponse addProperty(String key, T value) {
       this.body.put(key, value);

       return this;
    }

    @Override
    public String toString() {
        return new Json().toJson(this.body);
    }
}
