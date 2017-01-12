package com.example.hackeru.interceptsmsmessage;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by hackeru on 1/12/2017.
 */

public class SmsReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        Bundle bundle = intent.getExtras();
        SmsMessage[] messages = null;
        if (bundle != null){
            Log.d("TAG", "bundle is not NULL");
            Object[] pdus = (Object[]) bundle.get("pdus");
            messages = new SmsMessage[pdus.length];
            for (int i = 0; i < messages.length; i++){
                messages[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);
                if (i == 0){
                    String sender = messages[i].getOriginatingAddress();
                    String senderPhoneNumber = sender.substring(sender.length()-4);
                    String message = messages[i].getMessageBody();
                    Log.d("TAG", "send: " + sender + ", senderPhone: " + senderPhoneNumber + ", message: " + message);
                    Toast.makeText(context, senderPhoneNumber + ": " + message, Toast.LENGTH_LONG).show();
                    if (senderPhoneNumber.equals("5554") && message.equals("location")){
                        SmsManager manager = SmsManager.getDefault();   // there is only one SmsManager in your phone.
                        manager.sendTextMessage(
                                senderPhoneNumber,
                                null,
                                message + " MOM RELAX!!!",
                                null,
                                null
                        );
                    }
                }
            }
        }


    }
}
