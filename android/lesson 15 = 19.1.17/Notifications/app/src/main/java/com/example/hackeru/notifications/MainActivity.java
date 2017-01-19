package com.example.hackeru.notifications;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static final int MY_NOTIFICATION_ID = 1;
    private NotificationManager manager;
    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        manager.cancel(MY_NOTIFICATION_ID);
    }

    public void create(View view) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        // must have: smallIcon, contentTitle, contentText.
        builder.setSmallIcon(android.R.drawable.ic_dialog_email)
                .setContentTitle("this is the title: " + counter)
                .setContentText("this is the content");
        //PendingIntent pi;
        //builder.setLights(Color.argb(1,1,1,1), 500, 500); // check on READ device
        //if (counter == 0) {
             PendingIntent pi = PendingIntent.getActivity(this, 1, new Intent(this, MainActivity.class), PendingIntent.FLAG_NO_CREATE);
        //}else{
        //     pi = PendingIntent.getActivity(this, 1, new Intent(this, SecondActivity.class), PendingIntent.FLAG_NO_CREATE);
        //}
        builder.setContentIntent(pi);
        manager.notify(MY_NOTIFICATION_ID, builder.build());
    }

    public void update(View view){

    }

    public void remove(View view) {
        manager.cancel(MY_NOTIFICATION_ID);
        //manager.cancelAll();  // cancel all from my app!!!!!
    }
}
