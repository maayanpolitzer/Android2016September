package com.company.threads;

import com.company.ui.ChatLayout;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by hackeru on 11/7/2016.
 */
public class GetMessagesThread extends Thread {

    private static final int CLIENT_SEND_MESSAGE = 1;
    private static final int CLIENT_GET_MESSAGE = 2;
    private static final int CLIENT_SEND_IMAGE = 3;

    private int numOfMessages;
    private ChatLayout layout;

    public GetMessagesThread(int numOfMessages, ChatLayout layout){
        this.numOfMessages = numOfMessages;
        this.layout = layout;
    }

    @Override
    public void run() {
        while(true) {
            OutputStream out = null;
            InputStream in = null;
            Socket socket = null;
            try {
                socket = new Socket(SendMessageThread.SERVER_IP, SendMessageThread.SERVER_PORT);
                out = socket.getOutputStream();
                in = socket.getInputStream();
                out.write(CLIENT_GET_MESSAGE);
                out.write(numOfMessages);
                if (in.read() == 1) {
                    byte[] buffer = new byte[1024];
                    int length = in.read(buffer);
                    String message = new String(buffer, 0, length);
                    layout.displayMessage(message);
                    numOfMessages++;
                    System.out.println(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
