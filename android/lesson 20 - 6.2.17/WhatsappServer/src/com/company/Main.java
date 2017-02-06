package com.company;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {

        try {
            ServerSocket server = new ServerSocket(10234);
            while(true){
                System.out.println("waiting for clients...");
                Socket clientSocket = server.accept();    // waiting for connections...
                System.out.println("client connected");
                new ClientThread(clientSocket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
