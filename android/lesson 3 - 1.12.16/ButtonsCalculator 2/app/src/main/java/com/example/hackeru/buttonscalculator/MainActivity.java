package com.example.hackeru.buttonscalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int GO_TO_SETTINGS_REQUEST_CODE = 1;

    private TextView firstTV, secondTV;
    private Button firstBtn, secondBtn;
    private ImageView settingsBtn;
    private String operator = "+";
    private int firstInt, secondInt;
    private View.OnClickListener secondBtnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            secondTV.setText(++secondInt + "");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstTV = (TextView) findViewById(R.id.first_text_view);
        secondTV = (TextView) findViewById(R.id.second_text_view);
        firstBtn = (Button) findViewById(R.id.first_button);
        secondBtn = (Button) findViewById(R.id.second_button);
        settingsBtn = (ImageView) findViewById(R.id.settings_button);

        settingsBtn.setOnClickListener(this);

        // read about butterknife...

        firstBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstTV.setText(++firstInt + "");
            }
        });

        secondBtn.setOnClickListener(secondBtnClick);

    }

    public void calculate(View view) {
        // sum the numbers and go to second activity.
        Intent intent = new Intent(this, SumActivity.class);
        // add data to the intent and pass it to the target activity.
        int sum = 0;
        switch(operator){
            case "+":
                sum = firstInt + secondInt;
                break;
            case "-":
                sum = firstInt - secondInt;
                break;
            case "*":
                sum = firstInt * secondInt;
                break;
            case "/":
                sum = firstInt / secondInt;
                break;
        }
        /*
        if(operator.equals("+")){

        }
        */
        intent.putExtra("data", sum);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1){
            if (resultCode == RESULT_OK){
                operator = data.getStringExtra("Sign");
            }else if(resultCode == RESULT_CANCELED){
                Toast.makeText(this, "DONT SAVE!!!", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
