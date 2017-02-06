package com.maayanpolitzer.whatsapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class RegisterActivity extends AppCompatActivity {

    private EditText usernameET, passwordET, conPassET;

    public static final String PREFS_NAME = "prefs";
    private SharedPreferences settings;
    private SharedPreferences.Editor editor;

    /*
    how to download only onw project from github...
    http://kinolien.github.io/gitzip/
    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        settings = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        editor = settings.edit();

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
            Socket socket = null;
            int userID = 0;
            // new thread...
            try {
                socket = new Socket("10.0.24.27", 10234);
                OutputStream out = socket.getOutputStream();
                InputStream in = socket.getInputStream();
                out.write(1);
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("USERNAME", username);
                jsonObject.put("PASSWORD", password);
                out.write(jsonObject.toString().getBytes());
                userID = in.read();
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
            return userID;

        }

        @Override
        protected void onPostExecute(Integer integer) {

            // works on the Main Thread (UI Thread)
            if (integer != 0){
                // user added to servers list.
                Toast.makeText(RegisterActivity.this, "OK", Toast.LENGTH_SHORT).show();
                editor.putString("USERNAME", username);
                editor.putString("PASSWORD", password);
                editor.commit();
                startActivity(new Intent(RegisterActivity.this, MainActivity.class));
                finish();
            }else{
                Toast.makeText(RegisterActivity.this, "Problem", Toast.LENGTH_SHORT).show();
            }

        }
    }
}
