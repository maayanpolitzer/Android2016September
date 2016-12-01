package com.example.hackeru.buttonscalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SumActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sum);

        Intent receivedIntent = getIntent();
        int sum = receivedIntent.getIntExtra("data", -1);

        TextView textView = (TextView) findViewById(R.id.sum_text_view);

        textView.setText("The sum is: " + sum);

    }

    public void backToMain(View view) {
        finish();
    }
}
