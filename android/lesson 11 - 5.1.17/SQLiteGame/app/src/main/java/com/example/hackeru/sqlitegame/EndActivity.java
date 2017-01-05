package com.example.hackeru.sqlitegame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class EndActivity extends AppCompatActivity {

    private EditText nameEditText;
    private int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);

        /*
        App myApp = (App) getApplication();
        myApp.getNames();
        */

        TextView scoreTextView = (TextView) findViewById(R.id.activity_end_score_text_view);

        score = getIntent().getIntExtra(GameActivity.SCORE, -1);

        if (score != -1) {
            scoreTextView.setText(String.valueOf(score));
        }


        nameEditText = (EditText) findViewById(R.id.activity_end_name_edit_text);
        findViewById(R.id.activity_end_save_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveScore();
            }
        });
    }

    private void saveScore(){
        String name = nameEditText.getText().toString().trim();
        if (!name.isEmpty()) {
            DataSource dbManager = new DataSource(this);
            dbManager.insert(name, score);
            dbManager.getAllData();
            finish();
        }else{
            nameEditText.setError("What?!?!?!?!?!?!");
        }
    }
}
