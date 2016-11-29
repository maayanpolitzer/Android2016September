package com.example.hackeru.onclickrefreshment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buttonClick(View view){
        Button clickedBtn = (Button) view;
        Toast.makeText(this, clickedBtn.getText() + " clicked", Toast.LENGTH_LONG).show();
        //int number = Integer.parseInt(clickedBtn.getText().toString());
    }
}
