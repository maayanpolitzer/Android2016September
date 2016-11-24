package com.example.hackeru.firstproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private int counter;
    private TextView tv;

    private View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // inflate...

        Button b = (Button) findViewById(R.id.second_button);

        tv = (TextView) findViewById(R.id.main_text);
        /*
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        */
        //b.setOnClickListener(click);
        b.setOnClickListener(this);

        b.setText("change text view...");
    }


    public void firstClickButton(View view) {
        Toast.makeText(this, "break!!", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View v) {

        //Toast.makeText(this, "Counter is: " + ++counter, Toast.LENGTH_LONG).show();
        tv.setText("Counter is: " + ++counter);
    }
}
