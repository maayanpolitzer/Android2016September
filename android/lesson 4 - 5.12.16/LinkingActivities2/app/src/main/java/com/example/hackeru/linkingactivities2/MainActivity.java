package com.example.hackeru.linkingactivities2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final int EDITOR_REQUEST_CODE = 4;

    public static final String NAME = "name";
    public static final String AGE = "age";

    private int counter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button addBtn = (Button) findViewById(R.id.activity_main_add_button);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                Intent intent = new Intent(MainActivity.this, EditorActivity.class);
                startActivityForResult(intent,EDITOR_REQUEST_CODE);
                */
                addData("Maayan", counter++);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == EDITOR_REQUEST_CODE){
            // back from EditorActivity...
            if(resultCode == RESULT_OK){
                // get the saved data and add line to mainActivity.
                String name = data.getStringExtra(NAME);
                int age = data.getIntExtra(AGE, -1);
                if (name != null && age != -1){
                    addData(name, age);
                }
            }
        }
    }

    private void addData(String name, int age){
        //create view progammatically.
        TextView data = new TextView(this);
        data.setText(name + ", " + age);

        LinearLayout mainLayout = (LinearLayout) findViewById(R.id.activity_main_layout);
        mainLayout.addView(data);
        final ScrollView scrollView = (ScrollView) findViewById(R.id.activity_main_scroll_view);
        scrollView.post(new Runnable() {
            @Override
            public void run() {
                scrollView.fullScroll(View.FOCUS_DOWN);
            }
        });
    }

}
