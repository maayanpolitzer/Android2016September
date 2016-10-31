package com.company;

import java.io.*;

public class Main {

    public static void main(String[] args) {

        File desktop = new File("C:\\Users\\hackeru\\Desktop");

        File mainFolder = new File(desktop, "img");

        File copyFolder = new File(desktop, mainFolder.getName() + " - COPY");
        copyFolder.mkdir();     // creates the folder "img -COPY" in desktop (from copyFolder object).

        copyFiles(mainFolder, copyFolder);

        deleteFolder(mainFolder);

        /*
        File f = new File("my.txt");
        try {
            f.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        */
        /*
        File f = new File("my.txt");
        f.delete();
        */
    }

    private static void deleteFolder(File folder){
        String[] fileNames = folder.list();
        for (int i = 0; i < fileNames.length; i++){
            File f = new File(folder, fileNames[i]);
            System.out.println(fileNames[i] + " is " + f.exists());
            System.out.println(fileNames[i] + " deleted " + f.delete());
        }
        System.out.println("folder deleted: " + folder.delete());


    }

    private static void copyFiles(File originalFolder, File copyFolder){

        File[] files = originalFolder.listFiles();
        for (int i = 0; i < files.length; i++){
            //System.out.println(files[i].getName() + " is " + (files[i].isFile() ? "file" : "folder"));
            if (files[i].isFile()){
                copyFile(files[i], copyFolder);
            }
        }
        System.out.println("DONE!!!");
    }

    private static void copyFile(File file, File copyFolder){

        FileInputStream in = null;
        FileOutputStream out = null;
        try {
            in = new FileInputStream(file);
            File f = new File(copyFolder, file.getName());
            out = new FileOutputStream(f);

            int actuallyRead;
            byte[] buffer = new byte[1024];

            while ((actuallyRead = in.read(buffer)) > 0){
                out.write(buffer, 0, actuallyRead);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (in != null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (out != null){
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        /*
        try with resources/

        try (
                FileOutputStream out = new FileOutputStream(new File(copyFolder, file.getName()));
                ) {
            out.write(bla bla bla);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        */
    }



}
