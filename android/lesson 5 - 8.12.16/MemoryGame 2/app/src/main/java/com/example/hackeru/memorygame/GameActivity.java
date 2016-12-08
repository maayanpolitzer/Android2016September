package com.example.hackeru.memorygame;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.Random;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    private int[][] levels = {{3, 2}, {4, 3}, {6, 4}};
    private int[] images = {R.drawable.one, R.drawable.two, R.drawable.three, R.drawable.four, R.drawable.five
            , R.drawable.six, R.drawable.seven, R.drawable.eight, R.drawable.nine, R.drawable.ten
            , R.drawable.eleven, R.drawable.twelve};
    int[] cards;
    private LinearLayout mainLayout;
    private LinearLayout.LayoutParams rowParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 0, 1);    // (width,height,weight)
    private LinearLayout.LayoutParams imageParams = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT, 1);
    private int counter = 0;

    private ImageView firstImageView;
    private long gameStartTime;
    private int pairs = 0;

    private Handler handler = new Handler();
    private boolean working = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);   // hide the status bar.

        mainLayout = (LinearLayout) findViewById(R.id.main_layout);

        int level = getIntent().getIntExtra("level", -1);
        if (level != -1) {
            drawScreen(level);
        }
    }

    private void drawScreen(int level) {
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
                iv.setOnClickListener(this);
                iv.setImageResource(R.drawable.card);
                row.addView(iv, imageParams);
            }
            mainLayout.addView(row, rowParams);
        }
    }

    private void generateCardsArr(int rows, int cols) {
        cards = new int[rows * cols];
        /*
        int counter = 0;
        cards[0] = counter;
        for (int i = 1; i < cards.length; i++){
            if (i % 2 == 0){
                cards[i] = ++counter;
            }
            else{
                cards[i] = counter;
            }
        }
        */
        /*
        for (int i = 0, j = 0; i < cards.length - 1; i += 2, j++){
            cards[i] = j;
            cards[i + 1] = j;
        }
        */
        for (int i = 0; i < cards.length / 2; i++) {
            cards[i * 2] = i;
            cards[i * 2 + 1] = i;
        }

        shuffle();

    }

    @Override
    public void onClick(View v) {
        if (!working) {
            working = true;
            if (counter == 0) {
                gameStartTime = System.currentTimeMillis();
            }
            int tag = (int) v.getTag();
            if (firstImageView == null || (int) firstImageView.getTag() != tag) {
                Log.d("Maayan", "OK");
                if (firstImageView != null) {
                    Log.d("Maayan", "first: " + (int) firstImageView.getTag() + ", second: " + tag);
                }
                counter++;
                final ImageView clickedImageView = (ImageView) v;
                clickedImageView.setImageResource(images[cards[tag]]);
                if (counter % 2 == 0) {
                    // second card!!!
                    if (checkCards(cards[(int) firstImageView.getTag()], cards[tag])) {
                        // the cards are the same.
                        Log.d("Maayan", "cards are the same");
                        clickedImageView.setOnClickListener(null);
                        //ImageView firstImageView = (ImageView) mainLayout.findViewWithTag(tag);
                        firstImageView.setOnClickListener(null);
                        pairs++;
                        if (pairs == cards.length / 2) {
                            done();
                        }
                        working = false;
                    } else {
                        // not the same... need to flip them.

                        final ImageView finalFirstImageView = firstImageView;
                        Log.d("Maayan", "NOT the same");
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                finalFirstImageView.setImageResource(R.drawable.card);
                                clickedImageView.setImageResource(R.drawable.card);
                                working = false;
                            }
                        }, 2000);
                    }
                } else {
                    // first card!!!
                    Log.d("Maayan", "first card");
                    firstImageView = clickedImageView;
                    working = false;
                }
            }else{
                Log.d("Maayan", "NOT GOOD!!!!! " + counter);
                working = false;
            }
        }
    }

    private boolean checkCards(int firstCardImage, int secondCardImage) {
        return firstCardImage == secondCardImage;
    }

    private void done(){
        long gameDuration = System.currentTimeMillis() - gameStartTime;
        Intent intent = new Intent(this, GameOverActivity.class);
        intent.putExtra("clicks", counter);
        intent.putExtra("duration", gameDuration);
        startActivity(intent);
        finish();
    }

    private void shuffle(){

        int temp;
        Random random = new Random();
        for (int i = 0; i < cards.length; i++){
            int generatedNumber = random.nextInt(cards.length);
            temp = cards[i];
            cards[i] = cards[generatedNumber];
            cards[generatedNumber] = temp;
        }
    }

}
