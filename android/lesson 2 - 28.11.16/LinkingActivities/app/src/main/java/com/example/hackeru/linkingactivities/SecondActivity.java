package com.example.hackeru.linkingactivities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by hackeru on 11/28/2016.
 */
public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    public void displayThird(View view) {
        Intent intent = new Intent(this, ThirdActivity.class);
        intent.putExtra("name", "Maayan");  // add data to hashmap.
        startActivity(intent);
    }
}
