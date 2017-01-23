package com.example.hackeru.catchyourmissingcalls;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;

/**
 * Created by hackeru on 1/19/2017.
 */

public class CallReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        TelephonyManager manager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        MyPhoneListener listener = new MyPhoneListener(context);
        manager.listen(listener, PhoneStateListener.LISTEN_CALL_STATE);
    }
}
