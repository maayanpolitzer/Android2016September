package com.company;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by maayanpolitzer on 06/02/2017.
 */
public class ClientThread extends Thread {

    private Socket clientSocket;
    private InputStream in;
    private OutputStream out;

    public ClientThread(Socket clientSocket){
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
            in = clientSocket.getInputStream();
            out = clientSocket.getOutputStream();
            int action = in.read();
            switch (action) {
                case 1: // register
                    registerUser();
                    break;
                case 2: // login
                    loginUser();
                    break;

            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } finally {
            if (clientSocket != null){
                try {
                    clientSocket.close(); // will close inputStream & outputStream.
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    private void registerUser() throws IOException, JSONException {
        String[] data = getUserData();
        out.write(Main.insertUser(new User(data)));
    }

    private void loginUser() throws IOException, JSONException {
        String[] data = getUserData();
        out.write(Main.getUserIdByNameAndPassword(data[0], data[1]));
    }

    private String[] getUserData() throws IOException, JSONException {
        String[] data = new String[2];
        byte[] buffer = new byte[1024];
        int length = in.read(buffer);
        String str = new String(buffer, 0, length);
        JSONObject object = new JSONObject(str);
        data[0] = object.getString("USERNAME");
        data[1] = object.getString("PASSWORD");
        return data;
    }
}
