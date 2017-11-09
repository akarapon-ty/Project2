package com.findtheway;

<<<<<<< HEAD

import java.io.IOException;
import java.util.List;
import java.util.Locale;

>>>>>>> 86532df8cd6847cbc3475ede6a019b648550db4d
import android.app.AlertDialog;
=======
import android.Manifest;
>>>>>>> parent of 86532df... Gpsver2
import android.app.Service;
import android.content.Context;
import android.content.Intent;
<<<<<<< HEAD

=======
import android.location.Address;
import android.location.Geocoder;
>>>>>>> 86532df8cd6847cbc3475ede6a019b648550db4d
=======
import android.content.pm.PackageManager;
>>>>>>> parent of 86532df... Gpsver2
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
<<<<<<< HEAD
import android.provider.Settings;



/**
 * Created by Apostolis on 10/27/2016.
 */

=======
import android.util.Log;

/**
 * Create this Class from tutorial :
 * http://www.androidhive.info/2012/07/android-gps-location-manager-tutorial
 *
 * For Geocoder read this : http://stackoverflow.com/questions/472313/android-reverse-geocoding-getfromlocation
 *
 */
=======
import android.support.v4.app.ActivityCompat;
>>>>>>> parent of 86532df... Gpsver2

public class GPSTracker extends Service implements LocationListener {
    private final Context mContext;

    // GPS status
    boolean isGPSEnabled = false;

    // network status
    boolean isNetworkEnabled = false;


public class GPSTracker  extends Service implements LocationListener {

    private final Context context;

    boolean isGPSEnabled = false;
    boolean isNetworkEnabled = false;
    boolean canGetLocation = false;

    Location location;

    double latitude;
    double longitude;

<<<<<<< HEAD

    private static final long MIN_DISTANCE_CHANGE_FOR_UPDATES = 10;
    private static final long MIN_TIME_BW_UPDATES = 100;

    //The minimum distance to change updates in metters
    private static final long MIN_DISTANCE_CHANGE_FOR_UPDATES = 10; //10 metters
=======
    private static final long MIN_DISTANCE_CHANGE_FOR_UPDATES = 10; // 10 meters
>>>>>>> parent of 86532df... Gpsver2

    private static final long MIN_TIME_BW_UPDATES = 1000 * 60 * 1; // 1 minute

<<<<<<< HEAD

    //Declaring a Location Manager
    protected LocationManager locationManager;

    public GPSTracker(Context context){
        this.context = context;
        getLocation();
    }

    public Location getLocation(){
        try {
            locationManager = (LocationManager)context.getSystemService(LOCATION_SERVICE);
            isGPSEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
            isNetworkEnabled = locationManager.isProviderEnabled(locationManager.NETWORK_PROVIDER);


            if(!isGPSEnabled && !isGPSEnabled) {

            } else {
                this.canGetLocation = true;

                if(isNetworkEnabled) {
                    locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,
                            MIN_TIME_BW_UPDATES,
                            MIN_DISTANCE_CHANGE_FOR_UPDATES, this);


                    if (locationManager != null) {
                        location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                        if (location != null) {
                            latitude = location.getLatitude();
                            longitude = location.getLongitude();

                        }
                    }
                }
                if(isGPSEnabled) {
                    if(location == null) {
                        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,
                                MIN_TIME_BW_UPDATES,
                                MIN_DISTANCE_CHANGE_FOR_UPDATES, this);
                        if(locationManager != null) {
                            location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                            if(location != null){
                                latitude = location.getLatitude();
                                longitude = location.getLongitude();

                            }

    public GPSTracker(Context context)
    {
=======
    protected LocationManager locationManager;

    public GPSTracker(Context context) {
>>>>>>> parent of 86532df... Gpsver2
        this.mContext = context;
        getLocation();
    }

    public Location getLocation() {
        try {
            locationManager = (LocationManager) mContext
                    .getSystemService(LOCATION_SERVICE);

            // get GPS status
            isGPSEnabled = locationManager
                    .isProviderEnabled(LocationManager.GPS_PROVIDER);

            // get network status
            isNetworkEnabled = locationManager
                    .isProviderEnabled(LocationManager.NETWORK_PROVIDER);

            if (!isGPSEnabled && !isNetworkEnabled) {
                // ถ้า network ปิดอยู่
            } else {
                this.canGetLocation = true;
                if (isNetworkEnabled) {
                    if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                        // TODO: Consider calling
                        //    ActivityCompat#requestPermissions
                        // here to request the missing permissions, and then overriding
                        //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                        //                                          int[] grantResults)
                        // to handle the case where the user grants the permission. See the documentation
                        // for ActivityCompat#requestPermissions for more details.

                    }
                    locationManager.requestLocationUpdates(
                            LocationManager.NETWORK_PROVIDER,
                            MIN_TIME_BW_UPDATES,
                            MIN_DISTANCE_CHANGE_FOR_UPDATES, this);
                    if (locationManager != null) {
                        location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                        if (location != null) {
                            latitude = location.getLatitude();
                            longitude = location.getLongitude();
                        }
                    }
                }

                if (isGPSEnabled) {
                    if (location == null) {
                        locationManager.requestLocationUpdates(
                                LocationManager.GPS_PROVIDER,
                                MIN_TIME_BW_UPDATES,
                                MIN_DISTANCE_CHANGE_FOR_UPDATES, this);
                        if (locationManager != null) {
                            location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
<<<<<<< HEAD
                            updateGPSCoordinates();

=======
                            if (location != null) {
                                latitude = location.getLatitude();
                                longitude = location.getLongitude();
                            }
>>>>>>> parent of 86532df... Gpsver2
                        }

                    }

                }
            }
<<<<<<< HEAD
<<<<<<< HEAD
        } catch (Exception e) {
            e.printStackTrace();
=======
        }
        catch (Exception e)
        {
            //e.printStackTrace();
            Log.e("Error : Location", "Impossible to connect to LocationManager", e);
        }
>>>>>>> 86532df8cd6847cbc3475ede6a019b648550db4d

        }
        return location;
    }

<<<<<<< HEAD
    public void stopUsingGPS(){
        if(locationManager != null) {
=======
    public void updateGPSCoordinates()
    {
        if (location != null)
        {
            latitude = location.getLatitude();
            longitude = location.getLongitude();
=======

        } catch (Exception e) {
            e.printStackTrace();
>>>>>>> parent of 86532df... Gpsver2
        }

<<<<<<< HEAD
    /**
     * Stop using GPS listener
     * Calling this function will stop using GPS in your app
     */

    public void stopUsingGPS()
    {
        if (locationManager != null)
        {
>>>>>>> 86532df8cd6847cbc3475ede6a019b648550db4d
            locationManager.removeUpdates(GPSTracker.this);
        }
    }

<<<<<<< HEAD
    public double getLatitude() {
        if(location != null) {
=======
    /**
     * Function to get latitude
     */
    public double getLatitude()
    {
        if (location != null)
        {
>>>>>>> 86532df8cd6847cbc3475ede6a019b648550db4d
=======
        return location;
    }

    public double getLatitude(){
        if(location != null){
>>>>>>> parent of 86532df... Gpsver2
            latitude = location.getLatitude();
        }
        return latitude;
    }

<<<<<<< HEAD
<<<<<<< HEAD
    public double getLongitude(){
        if(location != null) {
=======
    /**
     * Function to get longitude
     */
    public double getLongitude()
    {
        if (location != null)
        {
>>>>>>> 86532df8cd6847cbc3475ede6a019b648550db4d
=======
    public double getLongitude(){
        if(location != null){
>>>>>>> parent of 86532df... Gpsver2
            longitude = location.getLongitude();
        }
        return longitude;
    }
<<<<<<< HEAD

<<<<<<< HEAD
    public boolean canGetLocation() {
        return this.canGetLocation;
    }

    public void showSettingsAlert(){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);

        alertDialog.setTitle("GPS SETTINGS");

        alertDialog.setMessage("GPS is not enabled.Go to Settings menu and enable it?");
        alertDialog.setPositiveButton("Settings", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                context.startActivity(intent);
            }
        }) ;
        alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        alertDialog.show();
    }

    @Override
    public void onLocationChanged(Location location) {
        this.location = location;
        getLatitude();
        getLongitude();
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

=======
    /**
     * Function to check GPS/wifi enabled
     */
    public boolean canGetLocation()
    {
=======
    public boolean canGetLocation() {
>>>>>>> parent of 86532df... Gpsver2
        return this.canGetLocation;
    }

    @Override
    public void onLocationChanged(Location location) {
        // TODO Auto-generated method stub
    }

    @Override
    public void onProviderDisabled(String provider) {
        // TODO Auto-generated method stub
    }

    @Override
    public void onProviderEnabled(String provider) {
        // TODO Auto-generated method stub
    }

    @Override
<<<<<<< HEAD
    public void onStatusChanged(String provider, int status, Bundle extras)
    {
>>>>>>> 86532df8cd6847cbc3475ede6a019b648550db4d
=======
    public void onStatusChanged(String provider, int status, Bundle extras) {
        // TODO Auto-generated method stub
>>>>>>> parent of 86532df... Gpsver2
    }


    @Override
<<<<<<< HEAD
<<<<<<< HEAD
    public IBinder onBind(Intent intent) {
=======
    public IBinder onBind(Intent intent)
    {
>>>>>>> 86532df8cd6847cbc3475ede6a019b648550db4d
=======
    public IBinder onBind(Intent intent) {
        // TODO Auto-generated method stub
>>>>>>> parent of 86532df... Gpsver2
        return null;
    }

}