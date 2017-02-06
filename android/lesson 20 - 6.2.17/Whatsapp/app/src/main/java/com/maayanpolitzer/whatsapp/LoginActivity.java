package com.maayanpolitzer.whatsapp;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class LoginActivity extends AppCompatActivity {

    private EditText usernameET, passwordET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

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
                try {
                    Socket socket = new Socket("10.0.24.27", 10234);
                    OutputStream out = socket.getOutputStream();
                    out.write(2);
                    InputStream in = socket.getInputStream();
                    int serverResponse = in.read();
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(LoginActivity.this, "Server got your message!", Toast.LENGTH_SHORT).show();
                        }
                    });
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

}
