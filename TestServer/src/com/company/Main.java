package com.company;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Main {

    public final static int PORT = 11438;
    private static ArrayList<String> messages;

    public static void main(String[] args) {
        messages = new ArrayList<>();
        try {
            ServerSocket server = new ServerSocket(PORT);
            while(true) {
                System.out.println("waiting for client...");
                Socket client = server.accept();
                System.out.println("client connected..");
                new ClientThread(client).start();
            }
        } catch (IOException e) {
            System.out.println("Port already in use " + e);
        }
    }

    public static void addMessage(String message){
        messages.add(message);
    }

    public static String getMessage(int index){
        return messages.get(index);
    }

    public static int getMessagesSize(){
        return messages.size();
    }

}
