package com.example.hackeru.file;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private String content = "wow wow it's working";
    private String fileName = "maayanFile.txt";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        // internal storage:

        /*
        // create file - write data!
        try {
            FileOutputStream out = openFileOutput(fileName, MODE_PRIVATE);
            out.write(content.getBytes());
            out.close();
            Toast.makeText(this, "Done!", Toast.LENGTH_LONG).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        */

        /*
        // read data from internal
        try {
            FileInputStream in = openFileInput(fileName);
            byte[] buffer = new byte[8];
            int actuallyRead;
            StringBuilder sb = new StringBuilder();
            while ((actuallyRead = in.read(buffer)) > 0){
                sb.append(new String(buffer, 0, actuallyRead));
            }
            in.close();
            Toast.makeText(this, sb.toString(), Toast.LENGTH_LONG).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        */

        /*
        File internalFolder = getFilesDir();
        Toast.makeText(this, "Free: " + internalFolder.getFreeSpace() + " bytes.", Toast.LENGTH_LONG).show();
        Log.d("TAG", internalFolder.getTotalSpace()/1024 + " total");
        Log.d("TAG", internalFolder.getFreeSpace()/1024 + " free");
        Log.d("TAG", internalFolder.getUsableSpace()/1024 + " useable");
        */

        if (isExternalStorageAvailable()){
            writeFile();
        }else{
            Toast.makeText(this, "Problem with extrenal storage", Toast.LENGTH_LONG).show();
        }
    }

    private void writeFile(){
        try {
            Log.d("TAG", Environment.getExternalStorageDirectory().getAbsolutePath());
            File myFolder = new File(Environment.getExternalStorageDirectory(), "myFolder");
            myFolder.mkdir();
            File myFile = new File(myFolder, fileName);
            FileOutputStream out = new FileOutputStream(myFile);
            out.write(content.getBytes());
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean isExternalStorageAvailable(){
        String state = Environment.getExternalStorageState();
        if (state.equals(Environment.MEDIA_MOUNTED)){   // extrenal storage available!
            return true;
        }
        return false;
    }

}
