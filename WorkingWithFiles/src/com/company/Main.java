package com.company;

import java.io.*;

public class Main {

    public static void main(String[] args) {

        //writeFile();

        File k = new File("maayan");
        k.mkdir();
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
