package com.maayanpolitzer.whatsappmessages.threads;

import android.content.Context;
import android.os.Handler;

import com.maayanpolitzer.whatsappmessages.User;
import com.maayanpolitzer.whatsappmessages.listeners.OnUsersArrivedListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by maayanpolitzer on 09/02/2017.
 */
public class GetUsersThread extends BaseThread {

    private OnUsersArrivedListener listener;
    private Handler handler;

    public GetUsersThread(OnUsersArrivedListener listener){
        this.listener = listener;
        handler = new Handler();
    }

    @Override
    public void run() {
        Socket socket = null;
        try {
            socket = new Socket(SERVER_IP, SER_PORT); // INTERNET PERMISSION !!!
            InputStream in = socket.getInputStream();
            OutputStream out = socket.getOutputStream();
            out.write(1);
            byte[] buffer = new byte[1024];
            StringBuilder sb = new StringBuilder();
            int length;
            while((length = in.read(buffer)) > 0){
                sb.append(new String(buffer, 0, length));
            }
            JSONArray arr = new JSONArray(sb.toString());
            final User[] users = new User[arr.length()];
            for (int i = 0; i < arr.length(); i++) {
                users[i] = new User(arr.getJSONObject(i));
                // the same as:
                /*
                JSONObject obj = arr.getJSONObject(i);
                User user = new User(obj);
                users[i] = user;
                */
            }
            handler.post(new Runnable() {
                @Override
                public void run() {
                    listener.updateList(users);
                }
            });
            /* foreach wont work on json array...
            for(JSONObject obj : arr){

            }
            */

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } finally {
            if (socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
