package com.company;

import java.io.IOException;
import java.net.ServerSocket;

public class Main {

    public static void main(String[] args) {

        try {
            ServerSocket serverSocket = new ServerSocket(10234);
            while(true){
                System.out.println("waiting...");
                serverSocket.accept();
                System.out.println("client connected!!!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
