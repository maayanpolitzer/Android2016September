package com.company;

import java.io.*;

public class Main {

    public static void main(String[] args) {

        //createFile("myFile.txt");
        readFile("myFile.txt");

    }

    private static void readFile(String fileName){
        /*
        try {
            FileInputStream in = new FileInputStream(fileName);
            byte[] buffer = new byte[8];
            int actuallyRead;
            String data = "";
            while((actuallyRead = in.read(buffer)) > 0){
                String part = new String(buffer, 0, actuallyRead);
                data += part;
            }
            System.out.println(data);
        } catch (FileNotFoundException e) {
            System.out.println("No such file....");
        } catch (IOException e) {
            e.printStackTrace();
        }
        */

        
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
            String data = "";
            String line;
            while((line = reader.readLine()) != null){
                data += line;
            }
            System.out.println(data);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void createFile(String fileName){
        File file = new File(fileName);
        try {
            if(file.createNewFile()){
                String content = "Anima";
                FileOutputStream out = new FileOutputStream(file, false);
                out.write(content.getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
