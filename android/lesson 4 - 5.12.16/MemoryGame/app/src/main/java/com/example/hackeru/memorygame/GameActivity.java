package com.example.hackeru.memorygame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class GameActivity extends AppCompatActivity {

    private int[][] levels = {{3,2}, {4,3}, {6,4}};
    private int[] images = {R.drawable.one, R.drawable.two, R.drawable.three, R.drawable.four, R.drawable.five
            , R.drawable.six, R.drawable.seven, R.drawable.eight, R.drawable.nine, R.drawable.ten
            , R.drawable.eleven, R.drawable.twelve};
    int[] cards;
    private LinearLayout mainLayout;
    private LinearLayout.LayoutParams rowParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 0, 1);    // (width,height,weight)
    private LinearLayout.LayoutParams imageParams = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT, 1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);   // hide the status bar.

        mainLayout = (LinearLayout) findViewById(R.id.main_layout);

        int level = getIntent().getIntExtra("level", -1);
        if (level != -1){
            drawScreen(level);
        }
    }

    private void drawScreen(int level){
        int counter = 0;
        int rows = levels[level][0];
        int cols = levels[level][1];
        generateCardsArr(rows, cols);
        for (int i = 0; i < rows; i++) {
            LinearLayout row = new LinearLayout(this);  // orientation = horizontal (default)
            for (int j = 0; j < cols; j++) {
                // add images in a loop to the row.
                ImageView iv = new ImageView(this);
                iv.setTag(counter++);
                iv.setImageResource(R.drawable.card);
                row.addView(iv, imageParams);
            }
            mainLayout.addView(row, rowParams);
        }
    }

    private void generateCardsArr(int rows, int cols) {
        cards = new int[rows * cols];

    }


}
