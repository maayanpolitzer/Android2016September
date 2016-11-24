package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {

    private static String link = "http://www.bizportal.co.il/forex/quote/generalview/22212222";

    public static void main(String[] args) {

        try {
            URL url = new URL(link);
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            String data = "";
            String line;
            /*
            while((line = reader.readLine()) != null){
                data += line;
            }
            */
            while((line = reader.readLine()) != null){
                if (line.contains("shaarim")){
                    System.out.println(line);
                    int start = line.indexOf(">") + 1;
                    System.out.println(line.substring(start));
                }
            }
            //System.out.println(data);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
