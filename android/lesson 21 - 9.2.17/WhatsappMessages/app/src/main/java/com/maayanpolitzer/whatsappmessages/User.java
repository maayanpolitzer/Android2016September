package com.maayanpolitzer.whatsappmessages;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by maayanpolitzer on 09/02/2017.
 */
public class User {

    private String name;
    private int id;

    public User(JSONObject object){
        try {
            name = object.getString("NAME");
            id = object.getInt("ID");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return name;
    }
}
