package com.company;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Main {

    public final static String SERVER_IP = "10.0.7.49";
    public final static int SERVER_PORT = 11438;

    public static void main(String[] args) {

        try {
            Socket socket = new Socket(SERVER_IP, SERVER_PORT);
            OutputStream out = socket.getOutputStream();
            String message = "Hi man!!!!";
            out.write(message.getBytes());
        } catch (IOException e) {
            System.out.println("Problem: " + e.getMessage());
        }

    }
}
