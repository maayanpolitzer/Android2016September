package com.example;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by eladlavi on 09/01/2017.
 */
public class MainServlet extends javax.servlet.http.HttpServlet {

    private String message = "";

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    //http://www.example.com:80/path?key1=value&key2=value
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String queryString = request.getQueryString();
        if(queryString == null || queryString.isEmpty())
            return;
        Map<String, String> qs = new HashMap<>();
        String[] keyValuePairs = queryString.split("&");
        for(String keyValuePair : keyValuePairs){
            String[] keyValue = keyValuePair.split("=");
            if(keyValue.length != 2)
                continue;
            if(keyValue[0].length() == 0 || keyValue[1].length() == 0)
                continue;
            qs.put(keyValue[0], keyValue[1]);
        }
        String action = qs.get("action");
        if(action == null)
            return;
        switch (action){
            case "send":
                String msg = qs.get("message");
                if(msg != null) {
                    this.message = msg;
                    response.getWriter().write("ok");
                }
                break;
            case "check":
                response.getWriter().write(this.message);
                break;
        }

    }
}
