package com.example.hackeru.dialogfragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;

/**
 * Created by hackeru on 1/19/2017.
 */

public class MyDialog extends DialogFragment {

    //private String title;
    private OnDialogCloseListener listener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        listener = (OnDialogCloseListener) getActivity();
        String title = getArguments().getString("TITLE");

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(title);
        builder.setMessage("My message");
        builder.setCancelable(false);
        builder.setPositiveButton("Yes we can!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                listener.update(true);
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                listener.update(false);
            }
        });
        return builder.create();
    }

    /*
    public void setData(String title){
        this.title = title;
    }
    */
}
