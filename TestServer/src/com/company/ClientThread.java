package com.company;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by hackeru on 11/7/2016.
 */
public class ClientThread extends Thread {

    private Socket socket;

    public ClientThread(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            InputStream in = socket.getInputStream();
            OutputStream out = socket.getOutputStream();
            byte[] buffer = new byte[1024];
            int length = in.read(buffer);
            String messageFromClient = new String(buffer, 0, length);
            Main.addMessage(messageFromClient);
            out.write(1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
