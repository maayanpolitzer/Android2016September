package com.company.threads;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by hackeru on 11/7/2016.
 */
public class GetMessagesThread extends Thread {

    private int numOfMessages;

    public GetMessagesThread(int numOfMessages){
        this.numOfMessages = numOfMessages;
    }

    @Override
    public void run() {
        OutputStream out = null;
        InputStream in = null;
        try {
            Socket socket = new Socket(SendMessageThread.SERVER_IP, SendMessageThread.SERVER_PORT);
            out = socket.getOutputStream();
            in = socket.getInputStream();
            out.write(numOfMessages);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
