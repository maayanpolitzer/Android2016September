package com.company;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by maayanpolitzer on 13/02/2017.
 */
public class Message {

    private int from;
    private int to;
    private String body;
    private boolean isRead;
    private JSONObject obj;

    public Message(JSONObject obj) throws JSONException {
        this.obj = obj;
        from = obj.getInt("FROM");
        to = obj.getInt("TO");
        body = obj.getString("MESSAGE");
        isRead = false;
    }

    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }

    public String getBody() {
        return body;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }

    public JSONObject getJson() {
        return obj;
    }
}
