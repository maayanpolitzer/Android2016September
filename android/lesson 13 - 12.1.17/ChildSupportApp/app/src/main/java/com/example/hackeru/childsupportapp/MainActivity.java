package com.example.hackeru.childsupportapp;

import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText phone, message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        phone = (EditText) findViewById(R.id.phone_edit_text);
        message = (EditText) findViewById(R.id.message_edit_text);

    }

    public void sendSMS(View view) {
        SmsManager manager = SmsManager.getDefault();   // there is only one SmsManager in your phone.
        for (int i = 0; i < 50; i++) {
            manager.sendTextMessage(
                    phone.getText().toString(),
                    null,
                    message.getText().toString() + " " + i,
                    PendingIntent.getBroadcast(this, 1, new Intent(this, SentReceiver.class), 0),
                    PendingIntent.getBroadcast(this, 2, new Intent(this, ReceivedReceiver.class), 0)
            );
        }
    }

}
