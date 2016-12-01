package com.example.hackeru.buttonscalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class SettingsActivity extends AppCompatActivity implements View.OnClickListener {

    private String operator;
    private Button saveAndCloseBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        saveAndCloseBtn = (Button) findViewById(R.id.save_and_close_button);

        saveAndCloseBtn.setOnClickListener(this);

    }

    public void radioChecked(View view) {
        RadioButton rb = (RadioButton) view;
        operator = rb.getText().toString();
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        intent.putExtra("Sign", operator);
        setResult(RESULT_OK, intent);     // pass result code (int) and intent (data) to the activity that launched this
        finish();
    }
}
