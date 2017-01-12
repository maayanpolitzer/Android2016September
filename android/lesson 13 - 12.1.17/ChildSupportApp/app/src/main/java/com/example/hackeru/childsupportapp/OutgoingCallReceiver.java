package com.example.hackeru.childsupportapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by hackeru on 1/12/2017.
 */

public class OutgoingCallReceiver extends BroadcastReceiver {

    private static ArrayList<Contact> contacts;

    static {
        contacts = new ArrayList<>();
        contacts.add(new Contact("Mom", "1111"));
        contacts.add(new Contact("Dad", "2222"));
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String phone = intent.getStringExtra(Intent.EXTRA_PHONE_NUMBER);
        boolean validNumber = false;
        for (Contact contact : contacts){
            if (contact.getPhone().equals(phone)){
                validNumber = true;
                break;
            }
        }
        if (!validNumber){
            // block the call!!!!
            setResultData(null);
            Toast.makeText(context, "You DIRTY child!", Toast.LENGTH_LONG).show();
        }
    }
}







