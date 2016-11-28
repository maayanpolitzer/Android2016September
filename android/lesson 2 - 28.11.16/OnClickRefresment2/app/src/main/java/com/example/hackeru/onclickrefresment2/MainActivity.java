package com.example.hackeru.onclickrefresment2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn, secondBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.first_button);
        secondBtn = (Button) findViewById(R.id.second_button);
        /*
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        */
        btn.setOnClickListener(this);
        secondBtn.setOnClickListener(this);
    }

    public void onClick(View view){
        int clickedButtonID = view.getId();
        if (clickedButtonID == R.id.first_button){
            Toast.makeText(this, "first Clicked", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "second Clicked", Toast.LENGTH_SHORT).show();
        }
    }
}
