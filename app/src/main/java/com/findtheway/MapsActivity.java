package com.findtheway;



import android.support.design.widget.FloatingActionButton;

import android.support.design.widget.NavigationView;

import android.support.v4.app.ActivityCompat;

import android.support.v4.app.FragmentActivity;

import android.os.Bundle;

import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.ActionBarDrawerToggle;

import android.util.Log;

import android.view.View;

import android.support.design.widget.NavigationView;

import android.support.design.widget.NavigationView;

import android.support.v4.view.GravityCompat;

import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.ActionBarDrawerToggle;

import android.support.v7.app.AppCompatActivity;

import android.support.v7.widget.Toolbar;





import com.google.android.gms.maps.CameraUpdateFactory;

import com.google.android.gms.maps.GoogleMap;

import com.google.android.gms.maps.OnMapReadyCallback;

import com.google.android.gms.maps.SupportMapFragment;

import com.google.android.gms.maps.model.LatLng;

import com.google.android.gms.maps.model.MarkerOptions;



public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {



    private GoogleMap mMap;

    GPSTracker gps;

    /**

     * Manipulates the map once available.

     * This callback is triggered when the map is ready to be used.

     * This is where we can add markers or lines, add listeners or move the camera. In this case,

     * we just add a marker near Sydney, Australia.

     * If Google Play services is not installed on the device, the user will be prompted to install

     * it inside the SupportMapFragment. This method will only be triggered once the user has

     * installed Google Play services and returned to the app.

     */

    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;

        gps = new GPSTracker(MapsActivity.this);



        if (gps.canGetLocation()) {



            double latitude = gps.getLatitude();

            double longitude = gps.getLongitude();

            LatLng latLng = new LatLng(latitude, longitude);

            mMap.addMarker(new MarkerOptions().position(latLng).title("Me"));

            mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));



        }

        else {

            Log.d("location", "cannot get location");

        }

    }



    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);



        // setSupportActionBar(toolbar);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()

                .findFragmentById(R.id.map);

        mapFragment.getMapAsync(this);



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {



            @Override

            public void onClick(View view) {

                gps = new GPSTracker(MapsActivity.this);

                if (gps.canGetLocation()) {

                    double latitude = gps.getLatitude();

                    double longitude = gps.getLongitude();

                    LatLng latLng = new LatLng(latitude, longitude);

                    mMap.addMarker(new MarkerOptions().position(latLng).title("Me"));

                    mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));

                    Log.d("location after clicked", ""+gps.getLatitude()+","+gps.getLongitude());

                } else {

                    gps.showSettingsAlert();

                }

            }

        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(

                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        drawer.addDrawerListener(toggle);

        toggle.syncState();



        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);

//        navigationView.setNavigationItemSelectedListener(this);





    }

}