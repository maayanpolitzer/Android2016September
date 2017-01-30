package com.example.hackeru.gps;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationProvider;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by hackeru on 1/30/2017.
 */

public class MyLocation implements LocationListener {

    private Context context;
    //private Location restaurant;

    public MyLocation(Context context){
        this.context = context;
        /*
        restaurant = new Location("");
        restaurant.setLatitude(32.888);
        restaurant.setLongitude(34.888);
        */
    }

    @Override
    public void onLocationChanged(Location location) {
        ((MapsActivity)context).setMarker(location);
        /*
        Toast.makeText(context, "Location changed!!!", Toast.LENGTH_SHORT).show();
        Log.d("TAG", "MyLocation is: " + location.toString());
        float meters = location.distanceTo(restaurant);
        Log.d("TAG", "You are " + meters + " away from the restaurant");
        */
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        String str = "";
        switch (status){
            case LocationProvider.OUT_OF_SERVICE:
                str = "out of OUT_OF_SERVICE";
                break;
            case LocationProvider.TEMPORARILY_UNAVAILABLE:
                str = "TEMPORARILY_UNAVAILABLE";
                break;
            case LocationProvider.AVAILABLE:
                str = "AVAILABLE";
                break;
        }
        Log.d("TAG", "Status: " + str);
    }

    @Override
    public void onProviderEnabled(String provider) {
        Log.d("TAG", "provider " + provider + " enabled!!!");
    }

    @Override
    public void onProviderDisabled(String provider) {
        Log.d("TAG", "provider " + provider + " disabled!!!");
    }
}
