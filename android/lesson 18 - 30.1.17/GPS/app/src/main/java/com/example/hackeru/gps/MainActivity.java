package com.example.hackeru.gps;

import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.LocationListener;
import android.location.LocationManager;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private LocationManager manager;
    private MyLocation myLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("TAG", "onCreate()");
        manager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        myLocation = new MyLocation(this);
        // dont check if provider enabled only here!!! when coming back to a created activity, it wont be called again!!! USE onResume()
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("TAG", "onStart()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("TAG", "onPause()");
        manager.removeUpdates(myLocation);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("TAG", "onRestart()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("TAG", "onStop()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("TAG", "onResume()");
        if(manager.isProviderEnabled(LocationManager.GPS_PROVIDER)){
            manager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 1, myLocation);
        }else{
            new AlertDialog.Builder(this)
                    .setTitle("GPS is OFF")
                    .setMessage("What to do???")
                    .setPositiveButton("go to settings", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                            startActivity(intent);
                        }
                    })
                    .setNegativeButton("Close app", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    })
                    .setCancelable(false)
                    .show();

        }
    }

    public void openMap(View view) {
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }
}
