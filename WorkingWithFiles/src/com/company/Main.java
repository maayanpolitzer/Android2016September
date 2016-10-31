package com.company;

import java.io.*;

public class Main {

    public static void main(String[] args) {

        //writeFile();

        /*
        File k = new File("maayan");
        k.mkdir();
        */

        //readFromFile("MyFile.txt");

        writeToFileNewWay();
        readFileNewWay();
    }

    private static void readFileNewWay(){

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("MyFile.txt")));
            String data = "";
            String line;
            while((line = reader.readLine()) != null){
                data += line;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeToFileNewWay(){
        try {
            FileWriter writer = new FileWriter("myFile.txt", true);
            writer.write("How are you?");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readFromFile(String fileName){
        File f = new File(fileName);
        try {
            FileInputStream in = new FileInputStream(f);
            byte[] buffer = new byte[10];
            /*
            int actuallyRead = in.read(buffer);
            String data = new String(buffer, 0, actuallyRead);
            */
            int actuallyRead;
            String content = "";
            while((actuallyRead = in.read(buffer)) > 0){        // loop to read from file the 10 next chars or less.
                String data = new String(buffer, 0, actuallyRead);
                content += data;
            }

            System.out.println("Content: " + content);
        } catch (FileNotFoundException e) {
            System.out.println("file not available....");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void writeFile() {
        File f = new File("MyFile.txt");
        if(!f.exists()) {
            try {
                f.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println(f.getAbsolutePath());
        String content = "WOW3 its working!!!";
        try {
            FileOutputStream out = new FileOutputStream(f, true);
            byte[] buffer = content.getBytes();
            out.write(buffer);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
