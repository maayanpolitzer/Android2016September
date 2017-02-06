package com.maayanpolitzer.whatsapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class LoginActivity extends AppCompatActivity {

    private EditText usernameET, passwordET;
    private SharedPreferences settings;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        settings = getSharedPreferences(RegisterActivity.PREFS_NAME, MODE_PRIVATE);
        editor = settings.edit();

        usernameET = (EditText) findViewById(R.id.activity_login_username_edit_text);
        passwordET = (EditText) findViewById(R.id.activity_login_password_edit_text);

        findViewById(R.id.activity_login_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

        findViewById(R.id.activity_login_register_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);

            }
        });

    }

    private void login(){
        final String username = usernameET.getText().toString().trim();
        final String password = passwordET.getText().toString().trim();
        // TODO: 06/02/2017 send user inputs to the server to check if it's exists!
        final Handler handler = new Handler();  // must be on the Main Thread!!!
        new Thread(new Runnable() {
            @Override
            public void run() {
                Socket socket = null;
                try {
                    socket = new Socket("10.0.24.27", 10234);
                    InputStream in = socket.getInputStream();
                    OutputStream out = socket.getOutputStream();
                    out.write(2);
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("USERNAME", username);
                    jsonObject.put("PASSWORD", password);
                    out.write(jsonObject.toString().getBytes());
                    Log.d("TAG", jsonObject.toString());
                    final int userID = in.read();
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            Log.d("TAG", "userID: " + userID);
                            if (userID != 0){
                                Toast.makeText(LoginActivity.this, "OK", Toast.LENGTH_LONG).show();
                                editor.putString("USERNAME", username);
                                editor.putString("PASSWORD", password);
                                editor.commit();
                                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                                finish();
                            }else{
                                Toast.makeText(LoginActivity.this, "No such user!", Toast.LENGTH_LONG).show();

                            }
                        }
                    });
                    //out.write((username + "/" + password).getBytes());
                    /*
                    out.write(username.length());   // 6
                    out.write(username.getBytes());
                    out.write(password.length());
                    out.write(password.getBytes());
                    */
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                } finally {
                    if (socket != null){
                        try {
                            socket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }
        }).start();
    }


}
