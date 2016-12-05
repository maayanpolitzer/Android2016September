package com.example.hackeru.memorygame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void buttonClick(View view) {
        int buttonId = view.getId();
        int level = 0;
        switch (buttonId){
            case R.id.button_medium:
                level = 1;
                break;
            case R.id.button_hard:
                level = 2;
                break;

        }
        startGame(level);
    }

    private void startGame(int level){
        Intent intent = new Intent(this, GameActivity.class);
        intent.putExtra("level", level);
        startActivity(intent);
    }


}
