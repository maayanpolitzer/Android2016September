package com.example.hackeru.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private String link = "http://www.myoutislands.com/includes/images/gallery/BOI-Exuma-Bahamas-Swimming-Pigs.jpg";
    private ImageView imageView;
    private Handler handler;
    private Thread thread;
    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            File file = new File(getFilesDir(), "image.jpg");
            if (file.exists()){
                imageView.setImageURI(Uri.fromFile(file));
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //handler = new Handler();
        Button btn = (Button) findViewById(R.id.start_service_button);
        imageView = (ImageView) findViewById(R.id.iv);
        btn.setOnClickListener(this);
        Log.d("TAG", Thread.currentThread().getName() + "");


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        /*
        if(thread != null){
            thread.interrupt(); // stop a running thread!
            thread = null;
            Log.d("TAG", "Thread stopped!!!");
        }
        */
    }

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter filter = new IntentFilter("99fm");
        registerReceiver(receiver, filter);

        File file = new File(getFilesDir(), "image.jpg");
        if (file.exists()){
            imageView.setImageURI(Uri.fromFile(file));
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(receiver);
    }

    @Override
    public void onClick(View v) {
        // service
        Intent intent = new Intent(this, DownloadService.class);
        intent.putExtra("LINK", link);
        startService(intent);
    }

    public void displayImage(View view) {
        File file = new File(getFilesDir(), "image.jpg");
        if (file.exists()){
            imageView.setImageURI(Uri.fromFile(file));
        }
    }

    /*
    @Override
    public void onClick(View v) {
        // thread
        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL(link);
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    InputStream inputStream = con.getInputStream();
                    final Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                    Log.d("TAG", "thread...");
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Log.d("TAG", "handler: " + Thread.currentThread().getName());
                            imageView.setImageBitmap(bitmap);
                            Toast.makeText(MainActivity.this, "DONE!", Toast.LENGTH_SHORT).show();
                            Log.d("TAG", "DONE!!!");
                        }
                    }, 10000);

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }
    */
}
