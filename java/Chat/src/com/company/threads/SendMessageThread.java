package com.company.threads;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by hackeru on 11/7/2016.
 */
public class SendMessageThread extends Thread {

    static final int SERVER_PORT = 11438;
    static final String SERVER_IP = "10.0.7.49";

    private static final int CLIENT_SEND_MESSAGE = 1;
    private static final int CLIENT_GET_MESSAGE = 2;
    private static final int CLIENT_SEND_IMAGE = 3;

    private String message;

    public SendMessageThread(String message){
        this.message = message;
    }

    // CLIENT

    @Override
    public void run() {
        Socket socket = null;
        OutputStream out = null;
        InputStream in = null;
        try {
            socket = new Socket(SERVER_IP, SERVER_PORT);
            out = socket.getOutputStream();
            in = socket.getInputStream();
            out.write(CLIENT_SEND_MESSAGE);
            out.write(message.getBytes());
            int status = in.read();
            System.out.println("status (1 - success, 0 - failure) value: " + status);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (in != null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
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
