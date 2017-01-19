package com.example.hackeru.dialogfragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

/**
 * Created by hackeru on 1/19/2017.
 */

public class MyCustomDialog extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        //builder.setView(R.layout.dialog_layout); // from API 21.
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_layout, null);
        final EditText email = (EditText) view.findViewById(R.id.dialog_email_edit_text);
        final EditText password = (EditText) view.findViewById(R.id.dialog_password_edit_text);
        view.findViewById(R.id.dialog_login_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((OnDialogCloseListener) getActivity()).update(email.getText().toString(), password.getText().toString());
                // close the dialog fragment:
                dismiss();
            }
        });
        builder.setView(view);

        return builder.create();
    }
}
