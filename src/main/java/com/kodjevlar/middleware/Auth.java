package com.kodjevlar.middleware;

import spark.Request;
import spark.Response;

public class Auth {
    public static void requireToken(Request req, Response res) {
        System.out.println("Did run token check");
    }
}
