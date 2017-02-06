package com.company;

import org.json.JSONObject;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class Main {

    private static Vector<User> users = new Vector<>();

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

    public static int insertUser(User user){
        if(users.add(user)){
            return user.getId();
        }
        return 0;
    }

    public static int getUserIdByNameAndPassword(String username, String password){
        for(User user : users){
            if (user.getName().equals(username) && user.getPassword().equals(password)){
                return user.getId();
            }
        }
        return 0;
    }
}
