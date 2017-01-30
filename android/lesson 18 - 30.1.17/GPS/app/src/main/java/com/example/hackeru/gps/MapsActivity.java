package com.example.hackeru.gps;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.provider.Settings;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private LocationManager manager;
    private MyLocation myLocation;
    private Marker marker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        manager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        myLocation = new MyLocation(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        marker = mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
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

    public void setMarker(Location location){
        LatLng myNewLatLng = new LatLng(location.getLatitude(), location.getLongitude());
        marker.remove();
        mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        marker = mMap.addMarker(new MarkerOptions().position(myNewLatLng).title("WOW"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(myNewLatLng, 20));
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("TAG", "onPause()");
        manager.removeUpdates(myLocation);
    }

}
