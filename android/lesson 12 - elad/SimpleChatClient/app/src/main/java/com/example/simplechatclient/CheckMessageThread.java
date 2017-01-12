package com.example.simplechatclient;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by eladlavi on 09/01/2017.
 */

public class CheckMessageThread extends Thread {

    private OnMessageChangedListener listener;
    private String previousMessage = "";
    private boolean go = true;

    public CheckMessageThread(OnMessageChangedListener listener) {
        this.listener = listener;
    }

    @Override
    public void run() {
        while(go) {
            HttpURLConnection urlConnection = null;
            InputStream inputStream = null;
            try {
                URL url = new URL("http://10.0.2.2:8080/MainServlet?action=check");
                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.setUseCaches(false);
                urlConnection.connect();
                inputStream = urlConnection.getInputStream();
                byte[] buffer = new byte[128];
                int actuallyRead = inputStream.read(buffer);
                inputStream.close();
                inputStream = null;
                if (actuallyRead != -1) {
                    String response = new String(buffer, 0, actuallyRead);
                    if (!response.equals(previousMessage)) {
                        previousMessage = response;
                        if (listener != null)
                            listener.messageChange(response);
                    }
                }

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (inputStream != null)
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                if (urlConnection != null)
                    urlConnection.disconnect();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void stopChecking(){
        go = false;
        interrupt();
    }

    interface OnMessageChangedListener{
        void messageChange(String message);
    }
}
