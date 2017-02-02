package com.example.hackeru.saveinstancestate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.text_view);

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        // get called automattically when we change the orientation && saveInstanceState is NOT null
        counter = savedInstanceState.getInt("COUNTER");
        textView.setText(counter + "");
    }

    public void add(View view) {
        textView.setText(++counter + "");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt("COUNTER", counter);
    }
}
