package com.example.hackeru.linkingactivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        Intent intent = getIntent();
        String value = intent.getStringExtra("name");

        Toast.makeText(this, "the value is: " + value, Toast.LENGTH_SHORT).show();
    }
}
