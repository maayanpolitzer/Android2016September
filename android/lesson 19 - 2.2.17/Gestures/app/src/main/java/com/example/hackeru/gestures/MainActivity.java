package com.example.hackeru.gestures;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    private ImageView ball;
    private boolean dragging;
    private float fixX, fixY;
    private View dropZone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);   // hide the status bar...

        RelativeLayout mainLayout = (RelativeLayout) findViewById(R.id.main_layout);
        dropZone = findViewById(R.id.drop_zone);

        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(150,150);

        ball = new ImageView(this);
        ball.setImageResource(R.drawable.ball);
        mainLayout.addView(ball, params);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch(event.getAction()){
            case MotionEvent.ACTION_DOWN:
                // touch the screen.
                if (event.getX() >= ball.getX() && event.getX() <= ball.getX() + ball.getWidth() && event.getY() >= ball.getY() && event.getY() <= ball.getY() + ball.getHeight()){
                    fixX = event.getX() - ball.getX();
                    fixY = event.getY() - ball.getY();
                    dragging = true;
                }
                break;
            case MotionEvent.ACTION_MOVE:
                // move my finger on the screen.
                if (dragging){
                    ball.setX(event.getX() - fixX);
                    ball.setY(event.getY() - fixY);
                }
                break;
            case MotionEvent.ACTION_UP:
                // stop touching the screen.

                Log.d("TAG", "clicked: " + event.getX() + "," + event.getY());
                if (dragging){
                    dragging = false;
                    if (ball.getX() >= dropZone.getX() && ball.getX() + ball.getWidth() <= dropZone.getX() + dropZone.getWidth() &&
                            ball.getY() >= dropZone.getY() && ball.getY() + ball.getHeight() <= dropZone.getY() + dropZone.getHeight()){
                        /*
                        float dropZoneMiddleX = dropZone.getX() + (dropZone.getWidth() / 2);
                        float dropZoneMiddleY = dropZone.getY() + (dropZone.getHeight() / 2);
                        moveToPoint(dropZoneMiddleX, dropZoneMiddleY);
                        Log.d("TAG", dropZoneMiddleX + "," + dropZoneMiddleY);
                        */
                    }else{
                        moveToPoint(0f,0f);
                    }

                }



                break;
        }
        return true;
    }

    private void moveToPoint(final float pointX, final float pointY){
        final Handler handler = new Handler();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(ball.getX() > pointX + 1  || ball.getY() > pointY + 1){
                    final float tempX = ball.getX() * 0.9f;
                    final float tempY = ball.getY() * 0.9f;
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            ball.setX(tempX);
                            ball.setY(tempY);
                        }
                    });
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}













