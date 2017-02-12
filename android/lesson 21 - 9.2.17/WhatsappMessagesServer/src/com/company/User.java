package com.company;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by maayanpolitzer on 09/02/2017.
 */
public class User {

    private String name;
    private int id;

    public User(String name, int id){
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public JSONObject toJson() throws JSONException {
        JSONObject obj = new JSONObject();
        obj.put("NAME", name);
        obj.put("ID", id);
        return obj;
    }

}
