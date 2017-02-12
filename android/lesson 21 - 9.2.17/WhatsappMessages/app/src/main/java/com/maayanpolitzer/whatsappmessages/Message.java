package com.maayanpolitzer.whatsappmessages;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by maayanpolitzer on 09/02/2017.
 */
public class Message {

    private String content;
    private int fromID;
    private int toID;

    public Message(String content, int from, int to){
        this.content = content;
        this.fromID = from;
        this.toID = to;
    }

    public Message(JSONObject obj){
        try {
            content = obj.getString("CONTENT");
            fromID = obj.getInt("FROM_ID");
            toID = obj.getInt("TO_ID");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String getContent() {
        return content;
    }

    public int getFromID() {
        return fromID;
    }

    public int getToID() {
        return toID;
    }

    public JSONObject toJson() throws JSONException{
        JSONObject obj = new JSONObject();
        obj.put("FROM", fromID);
        obj.put("TO", toID);
        obj.put("MESSAGE", content);
        return obj;
    }

}
