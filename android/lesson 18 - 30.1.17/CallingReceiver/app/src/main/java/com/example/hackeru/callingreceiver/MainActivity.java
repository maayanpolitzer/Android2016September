package com.example.hackeru.callingreceiver;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void callReceiver(View view) {
        Log.d("TAG", "onclick");
        Intent intent = new Intent("YudaLevi");
        sendBroadcast(intent);
    }
}
