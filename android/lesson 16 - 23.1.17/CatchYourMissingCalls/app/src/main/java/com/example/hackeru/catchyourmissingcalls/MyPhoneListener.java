package com.example.hackeru.catchyourmissingcalls;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.NotificationCompat;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;

/**
 * Created by hackeru on 1/19/2017.
 */
public class MyPhoneListener extends PhoneStateListener {

    private Context context;
    private static boolean b = true;

    public MyPhoneListener(Context context){
        this.context = context;
    }

    @Override
    public void onCallStateChanged(int state, String incomingNumber) {
        switch(state){
            case TelephonyManager.CALL_STATE_RINGING:
                // ringing...
                b = true;
                break;
            case TelephonyManager.CALL_STATE_OFFHOOK:
                // start call!
                b = false;
                break;
            case TelephonyManager.CALL_STATE_IDLE:
                // call ended!
                if (b){
                    b = false;
                    showNotification(incomingNumber);
                }
                break;
        }
    }

    private void showNotification(String number){
        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
        builder.setSmallIcon(android.R.drawable.sym_call_missed);
        builder.setContentTitle("Just missed call");
        builder.setContentText(number);
        Intent intent = new Intent(context, MainActivity.class);
        PendingIntent pi = PendingIntent.getActivity(context,0, intent, 0);
        builder.setContentIntent(pi);   // makes your notification clickable.
        PendingIntent callBackPendingIntent = PendingIntent.getActivity(context, 1, new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + number)), 0);
        builder.addAction(android.R.drawable.sym_call_outgoing, "Open App", callBackPendingIntent);
        manager.notify(2, builder.build());
    }

}
