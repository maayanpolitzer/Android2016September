package com.example.hackeru.broadcastreceiverintro;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by hackeru on 1/12/2017.
 */

public class MyFirstReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("TAG", "trigger: " + intent.getAction());
        Toast.makeText(context, "MyFirstReceiver called", Toast.LENGTH_LONG).show();
    }
}


