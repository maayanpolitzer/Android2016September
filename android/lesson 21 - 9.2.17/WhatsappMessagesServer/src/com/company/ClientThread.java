package com.company;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by maayanpolitzer on 09/02/2017.
 */
public class ClientThread extends Thread {

    private Socket clientSocket;
    private InputStream in;
    private OutputStream out;

    public ClientThread(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
            in = clientSocket.getInputStream();
            out = clientSocket.getOutputStream();
            int action = in.read();
            switch (action){
                case 1:
                    // client wants to get users list.
                    out.write(Main.getUsersAsJsonArray().toString().getBytes());
                    break;
                case 2:
                    // client sent message
                    clientSendingMessage();
                    break;
                case 3:
                    // client wants to get a message.
                    clientWantsToGetMessage();
                    break;
            }


        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } finally {
            if (clientSocket != null){
                try {
                    clientSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void clientSendingMessage() throws IOException, JSONException {
        byte[] buffer = new byte[1024];
        int length;
        StringBuilder sb = new StringBuilder();
        while ((length = in.read(buffer)) > 0){
            sb.append(new String(buffer, 0, length));
        }
        JSONObject obj = new JSONObject(sb.toString());
        Message message = new Message(obj);
        Main.addMessageToList(message);
        System.out.println("client sent: " + sb.toString());
    }

    private void clientWantsToGetMessage() throws IOException {
        int client = in.read();
        Message message = Main.getMessageById(client);
        if (message != null){
            out.write(1);
            out.write(message.getJson().toString().getBytes());
            message.setRead(true);
        }else{
            out.write(0);
        }
    }

}
