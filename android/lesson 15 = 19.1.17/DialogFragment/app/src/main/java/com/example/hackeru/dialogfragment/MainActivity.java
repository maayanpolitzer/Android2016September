package com.example.hackeru.dialogfragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements DialogInterface.OnClickListener, OnDialogCloseListener  {

    private TextView nameTextView;
    private boolean firstTime = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameTextView = (TextView) findViewById(R.id.name_text_view);

    }

    private void changeTextViewText(boolean b){
        firstTime = true;
        nameTextView.setText(b + "");
    }

    public void showFirstDialog(View view) {
        /*
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        dialogBuilder
                .setIcon(R.mipmap.ic_launcher)
                .setTitle("Are you sure?")
                .setMessage("This cannot be undone!!!")
                .setPositiveButton("Yes!!!", this)
                .setNegativeButton("No", this)
                .setNeutralButton((firstTime ? "" : "Still ") + "dont know", this)
                .setCancelable(false)
                .show();
                */
        MyDialog dialog = new MyDialog();
        //dialog.setData("Wrong way");  WRONG WAY!!!! DO WHAT GOOGLE TELLS YOU!
        Bundle bundle = new Bundle();
        bundle.putString("TITLE", "Great way!!!");
        dialog.setArguments(bundle);

        dialog.show(getFragmentManager(), "");
    }

    public void showSecondDialog(View view) {
        MyCustomDialog dialog = new MyCustomDialog();
        dialog.show(getFragmentManager(), "");
    }


    @Override
    public void onClick(DialogInterface dialog, int which) {

        switch(which){
            case -1:
                // clicked on the Positive button (yes):
                changeTextViewText(true);
                break;
            case -2:
                // clicked on negative button (no);
                changeTextViewText(false);
                break;
            case -3:
                // clicked on the neutral button...
                firstTime = false;
                showFirstDialog(null);
                break;
            default:
                // the default is to close the dialog fragment
        }

    }

    @Override
    public void update(boolean result) {
        changeTextViewText(result);
    }

    @Override
    public void update(String email, String password) {
        nameTextView.setText(email + ", " + password);
    }
}
