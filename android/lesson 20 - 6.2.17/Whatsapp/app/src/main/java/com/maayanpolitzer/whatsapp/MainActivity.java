package com.maayanpolitzer.whatsapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        settings = getSharedPreferences(RegisterActivity.PREFS_NAME, MODE_PRIVATE);

        String username = settings.getString("USERNAME", null);
        String password = settings.getString("PASSWORD", null);
        if (username != null && password != null){
            checkUser(username, password);
        }else{
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            finish();
        }


    }

    private void checkUser(String username, String password){
        Handler handler = new Handler();
        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).start();
    }
}
