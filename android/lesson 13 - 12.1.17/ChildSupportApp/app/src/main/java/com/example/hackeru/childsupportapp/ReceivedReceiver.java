package com.example.hackeru.childsupportapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by hackeru on 1/12/2017.
 */
public class ReceivedReceiver extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "SMS delivered!", Toast.LENGTH_LONG).show();
    }
}
