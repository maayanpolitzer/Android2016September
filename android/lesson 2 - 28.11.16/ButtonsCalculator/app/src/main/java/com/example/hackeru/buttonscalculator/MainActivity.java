package com.example.hackeru.buttonscalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView counterTextView;
    private Button addBtn, subBtn;

    private int addCounter = 0, subCounter = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        counterTextView = (TextView) findViewById(R.id.counter_text_view);
        addBtn = (Button) findViewById(R.id.add_button);
        subBtn = (Button) findViewById(R.id.sub_button);

        addBtn.setOnClickListener(this);
        subBtn.setOnClickListener(this);
        /*
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addBtn.setText("add (" + ++addCounter + ")");
                updateTextView();
            }
        });

        subBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                subBtn.setText("subtract (" + ++subCounter + ")");
                updateTextView();
            }
        });
        */

    }

    @Override
    public void onClick(View view) {

        if (view == addBtn){
            addBtn.setText("add (" + ++addCounter + ")");
        }else{
            subBtn.setText("subtract (" + ++subCounter + ")");
        }
        updateTextView();
    }

    private void updateTextView(){
        counterTextView.setText("Counter is: " + (addCounter - subCounter));
    }
}
