package com.example.hackeru.sqlitegame;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    static final String SCORE = "score";
    private Button btn;
    private int counter;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        btn = (Button) findViewById(R.id.activity_game_button);
        btn.setOnClickListener(this);

        handler = new Handler();

    }

    @Override
    public void onClick(View v) {
        if (counter == 0){
            startTimer();
        }
        counter++;
    }

    private void startTimer(){
        btn.setText("Click fast!!!!!!!");
        // TODO: 1/5/2017 start the timer & call stopGame() method when it's done!
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                stopGame();
            }
        }, 5000);
    }

    private void stopGame(){
        Intent intent = new Intent(this, EndActivity.class);
        intent.putExtra(SCORE, counter);
        startActivity(intent);
        finish();
    }

}
