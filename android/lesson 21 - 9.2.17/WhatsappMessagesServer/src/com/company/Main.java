package com.company;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class Main {

    //download link for intelliJ ultimate.
    //https://account.jetbrains.com/a/f432bk3v

    private static User[] users = {
            new User("Maayan", 1),
            new User("Eliran", 2),
            new User("Niv", 3),
            new User("Liri", 4),
            new User("Itay", 5)
    };

    private static Vector<Message> messages = new Vector<>();


    private static final int PORT = 10234;

    public static void main(String[] args) {

        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            while (true){
                System.out.println("Waiting for connections...");
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected!");
                new ClientThread(clientSocket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static JSONArray getUsersAsJsonArray() throws JSONException {
        JSONArray arr = new JSONArray();
        for(User u : users){
            arr.put(u.toJson());
        }
        /*
        for (int i = 0; i < users.length; i++){
            User u = users[i];
            arr.put(u.toJson());
        }
        (*/
        return arr;
    }

    public static void addMessageToList(Message message){
        messages.add(message);
    }

    public static Message getMessageById(int id){
        for (Message message : messages){
            if (message.getTo() == id && !message.isRead()){
                return message;
            }
        }
        return null;
    }

}
