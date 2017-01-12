package com.example.simplechatclient;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends Activity implements CheckMessageThread.OnMessageChangedListener {

    Button btnSend;
    TextView lblMessage;
    EditText txtMessage;
    CheckMessageThread thread;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSend = (Button)findViewById(R.id.btnSend);
        lblMessage = (TextView)findViewById(R.id.lblMessage);
        txtMessage = (EditText)findViewById(R.id.txtMessage);
    }


    @Override
    protected void onResume() {
        super.onResume();

        thread = new CheckMessageThread(this);
        thread.start();
    }

    @Override
    protected void onPause() {
        super.onPause();

        thread.stopChecking();
        thread = null;
    }

    public void btnSend(View view) {
        btnSend.setEnabled(false);
        btnSend.setText("please wait..");
        String message = txtMessage.getText().toString();
        if(message.isEmpty()){
            Toast.makeText(this, "please type something", Toast.LENGTH_SHORT).show();
            return;
        }


        new AsyncTask<String, Void, Boolean>(){

            @Override
            protected Boolean doInBackground(String... params) {
                String message = params[0];
                boolean success = false;
                HttpURLConnection urlConnection = null;
                InputStream inputStream = null;
                try{
                    URL url = new URL("http://10.0.2.2:8080/MainServlet?action=send&message="+message);
                    urlConnection = (HttpURLConnection)url.openConnection();
                    urlConnection.setRequestMethod("GET");
                    urlConnection.setUseCaches(false);
                    urlConnection.connect();
                    inputStream = urlConnection.getInputStream();
                    byte[] buffer = new byte[128];
                    int actuallyRead = inputStream.read(buffer);
                    inputStream.close();
                    inputStream = null;
                    if(actuallyRead != -1){
                        String response = new String(buffer, 0, actuallyRead);
                        if(response.equals("ok"))
                            success = true;
                    }

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    if(inputStream != null)
                        try {
                            inputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    if(urlConnection != null)
                        urlConnection.disconnect();
                }
                return success;
            }

            @Override
            protected void onPostExecute(Boolean success) {
                super.onPostExecute(success);

                btnSend.setEnabled(true);
                btnSend.setText("Send");
                if(!success)
                    Toast.makeText(MainActivity.this, "error", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "sent", Toast.LENGTH_SHORT).show();
            }
        }.execute(message);



    }

    String message;

    @Override
    public void messageChange(String message) {
        this.message = message;
        handler.post(new Runnable() {
            @Override
            public void run() {
                lblMessage.setText(MainActivity.this.message);
            }
        });
    }
}
