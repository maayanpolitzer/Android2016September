package com.maayanpolitzer.whatsapp;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class RegisterActivity extends AppCompatActivity {

    private EditText usernameET, passwordET, conPassET;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        usernameET = (EditText) findViewById(R.id.activity_register_username_edit_text);
        passwordET = (EditText) findViewById(R.id.activity_register_password_edit_text);
        conPassET = (EditText) findViewById(R.id.activity_register_confirm_password_edit_text);

        findViewById(R.id.activity_register_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
            }
        });

    }

    private void register(){
        String username = usernameET.getText().toString().trim();
        String password = passwordET.getText().toString().trim();
        new RegisterTask(username, password).execute();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;

            default:
                return false;
        }

    }

    private class RegisterTask extends AsyncTask<Void, Void, Integer> {

        private String username, password;

        public RegisterTask(String username, String password){
            this.username = username;
            this.password = password;
        }

        @Override
        protected Integer doInBackground(Void... params) {
            // new thread...
            try {
                Socket socket = new Socket("10.0.24.27", 10234);
                OutputStream out = socket.getOutputStream();
                InputStream in = socket.getInputStream();
                out.write(1);
                int serverResponse = in.read();
                in.close();
                out.close();
                return serverResponse;
            } catch (IOException e) {
                e.printStackTrace();
                return -1;
            }

        }

        @Override
        protected void onPostExecute(Integer integer) {
            // works on the Main Thread (UI Thread)
            if (integer == 10){
                Toast.makeText(RegisterActivity.this, "Server got your message!!!", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
