package com.example.hackeru.catchyourmissingcalls;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by hackeru on 1/19/2017.
 */
public class CallbackReceiver extends BroadcastReceiver{

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("TAG", "callback receiver");
    }
}
