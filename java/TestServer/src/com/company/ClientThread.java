package com.company;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by hackeru on 11/7/2016.
 */
public class ClientThread extends Thread {

    private static final int CLIENT_SEND_MESSAGE = 1;
    private static final int CLIENT_GET_MESSAGE = 2;
    private static final int CLIENT_SEND_IMAGE = 3;
    private Socket socket;

    public ClientThread(Socket socket){
        this.socket = socket;
    }


    //SERVER

    @Override
    public void run() {
        InputStream in = null;
        OutputStream out = null;
        try {
            in = socket.getInputStream();
            out = socket.getOutputStream();
            int action = in.read();
            switch(action){
                case CLIENT_SEND_MESSAGE:
                    byte[] buffer = new byte[1024];
                    int length = in.read(buffer);
                    String messageFromClient = new String(buffer, 0, length);
                    Main.addMessage(messageFromClient);
                    out.write(1);
                    break;
                case CLIENT_GET_MESSAGE:
                    int numOfMessagesInClient = in.read();
                    int numOfMessagesInServer = Main.getMessagesSize();
                    if (numOfMessagesInClient == numOfMessagesInServer){
                        out.write(0);
                    }else if(numOfMessagesInClient > numOfMessagesInServer){
                        out.write(-1);
                    }else{
                        out.write(1);
                        out.write(Main.getMessage(numOfMessagesInClient).getBytes());
                    }
                    break;
                case CLIENT_SEND_IMAGE:

                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
