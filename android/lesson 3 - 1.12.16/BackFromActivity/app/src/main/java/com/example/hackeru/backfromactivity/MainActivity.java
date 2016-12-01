package com.example.hackeru.backfromactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button loginBtn, settingsBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginBtn = (Button) findViewById(R.id.login_button);
        settingsBtn = (Button) findViewById(R.id.settings_button);

        loginBtn.setOnClickListener(this);
        settingsBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view == settingsBtn){
            Intent intent = new Intent(this, SettingsActivity.class);
            startActivityForResult(intent, 1);
        }else{
            Intent intent = new Intent(this, LoginActivity.class);
            startActivityForResult(intent, 2);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        String backFrom = "";
        if (requestCode == 1){
            if (resultCode == RESULT_OK){
                backFrom = "SettingsActivity Button click";
            }else{
                backFrom = "SettingsActivity BACK click";
            }
        }else if(requestCode == 2){
            if (resultCode == RESULT_OK){
                backFrom = "LoginActivity Button click";
            }else{
                backFrom = "LoginActivity BACK click";
            }
        }
        Toast.makeText(this, "Welcome back from : " + backFrom, Toast.LENGTH_SHORT).show();
    }
}
