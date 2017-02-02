package com.example.hackeru.permissions;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String[] permissions = {
            Manifest.permission.RECORD_AUDIO,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.ACCESS_FINE_LOCATION
    };
    private ArrayList<String> permissionsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        // check cerfully if it's working fine... for group permissions request...
        for (int i = 0; i < permissions.length; i++){
            if (ContextCompat.checkSelfPermission(this, permissions[i]) != PackageManager.PERMISSION_GRANTED ){
                permissionsList.add(permissions[i]);
            }
        }
        if (permissionsList.size() > 0) {
            String[] permissionsToRequest = new String[permissionsList.size()];
            for (int i = 0; i < permissionsList.size(); i++){
                permissionsToRequest[i] = permissionsList.get(i);
            }
            ActivityCompat.requestPermissions(this, permissionsToRequest, 2);
        }
        */

        // for one permission...
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.RECORD_AUDIO}, 2);
        }else{
            // permission already granted or device api is less than 23
            startRecording();
        }
    }

    private void startRecording(){
        Log.d("TAG", "Recording...");
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == 2){
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED){
                startRecording();
            }
        }
    }
}













