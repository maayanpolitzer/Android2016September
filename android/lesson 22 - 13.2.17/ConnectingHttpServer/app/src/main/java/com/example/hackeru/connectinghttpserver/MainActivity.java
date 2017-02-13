package com.example.hackeru.connectinghttpserver;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private TextView nameTV, ageTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameTV = (TextView) findViewById(R.id.name_text_view);
        ageTV = (TextView) findViewById(R.id.age_text_view);

    }

    public void connectServer(View view) {
        // DON'T FORGET PERMISSION !!!
        // GET
        final String link = "http://10.0.7.49:8082/MainServlet?name=wow&age=800";
        final Handler handler = new Handler();
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection con = null;
                try {
                    URL url = new URL(link);
                    con = (HttpURLConnection) url.openConnection();
                    InputStream in = con.getInputStream();
                    byte[] buffer = new byte[1024];
                    int length = in.read(buffer);
                    String response = new String(buffer, 0, length);
                    final JSONObject obj = new JSONObject(response);
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                nameTV.setText(obj.getString("name"));
                                ageTV.setText(String.valueOf(obj.getInt("age") + ", " + obj.getString("school")));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    });
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                } finally {
                    if (con != null){
                        con.disconnect();
                    }
                }
            }
        }).start();
    }

    public void connectPost(View view) {
        final String link = "http://10.0.7.49:8082/MainServlet";
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL(link);
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    con.setRequestMethod("POST");
                    con.setDoOutput(true);
                    con.setDoInput(true);
                    OutputStream out = con.getOutputStream();
                    out.write("name=maayanpolitzer&password=123abc".getBytes());
                    InputStream in = con.getInputStream();  // must be after outputStream sent parameters (out.write()).
                    byte[] buffer = new byte[1024];
                    int length = in.read(buffer);
                    String str = new String(buffer,0,length);
                    Log.d("TAG", str);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
