package com.company;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by maayanpolitzer on 06/02/2017.
 */
public class ClientThread extends Thread {

    private Socket clientSocket;
    private InputStream in;
    private OutputStream out;

    public ClientThread(Socket clientSocket){
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
            in = clientSocket.getInputStream();
            out = clientSocket.getOutputStream();
            int action = in.read();
            switch (action) {
                case 1: // register
                    registerUser();
                    break;
                case 2: // login
                    loginUser();
                    break;

            }
        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            if (clientSocket != null){
                try {
                    clientSocket.close(); // will close inputStream & outputStream.
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    private void registerUser() throws IOException {
        out.write(10);
    }

    private void loginUser(){

    }
}
