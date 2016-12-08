package com.example.hackeru.memorygame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class GameOverActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        int clicks = getIntent().getIntExtra("clicks", -1);
        long duration = getIntent().getLongExtra("duration", -1);

        int i = clicks * (int)duration/ 1000;

        TextView tv = new TextView(this);
        tv.setText("Your result is: " + i);

        setContentView(tv);

    }
}
