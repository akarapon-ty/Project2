package com.findtheway;

import android.Manifest;
import android.content.Intent;
import android.location.LocationManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
    final static int PERMISSION_ALL = 1;
    final static String[] PERMISSIONS = {android.Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACCESS_FINE_LOCATION};
    private GoogleMap mMap;
    MarkerOptions mo;
    Marker marker;
    LocationManager locationManager;
    double lat;
    double lon;
    GPSTracker gpsTracker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        mo = new MarkerOptions().position(new LatLng(0, 0)).title("My Current Location");
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent receiveIntent = getIntent();
                lat = receiveIntent.getDoubleExtra("lat", lat);
                lon = receiveIntent.getDoubleExtra("lon", lon);
                Log.d("location after clicked", ""+lat+","+lon);
                marker.setPosition(new LatLng(lat,lon));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(lat,lon)));
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(lat,lon),17));
                gpsTracker.onStart();
        }
        });
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        marker =  mMap.addMarker(mo);
        Intent receiveIntent = getIntent();
        lat = receiveIntent.getDoubleExtra("lat", lat);
        lon = receiveIntent.getDoubleExtra("lon", lon);
        Log.d("location after clicked", ""+lat+","+lon);
        marker.setPosition(new LatLng(lat,lon));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(lat,lon)));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(lat,lon),16));
    }
    public static void main(String[] args){
        Edge[] edges = {
                new Edge(0,2,1),
                new Edge(0,3,4),
                new Edge(0,4,2),
                new Edge(0,1,3),
                new Edge(1,3,2),
                new Edge(1,4,3),

        };
        Graph g = new Graph(edges);
        g.calculateShortestDistance();

        g.printresult();
    }
}
