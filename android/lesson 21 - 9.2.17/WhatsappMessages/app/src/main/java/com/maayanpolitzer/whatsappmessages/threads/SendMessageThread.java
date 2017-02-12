package com.maayanpolitzer.whatsappmessages.threads;

import com.maayanpolitzer.whatsappmessages.Message;

import org.json.JSONException;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by maayanpolitzer on 09/02/2017.
 */
public class SendMessageThread extends BaseThread{

    private Message message;

    public SendMessageThread(Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        Socket socket = null;
        try {
            socket = new Socket(SERVER_IP, SER_PORT);
            OutputStream out = socket.getOutputStream();
            out.write(2);
            out.write(message.toJson().toString().getBytes());
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
