package com.findtheway;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.maps.android.PolyUtil;

import java.util.ArrayList;
import java.util.List;

import io.nlopez.smartlocation.OnLocationUpdatedListener;
import io.nlopez.smartlocation.SmartLocation;
import io.nlopez.smartlocation.location.config.LocationAccuracy;
import io.nlopez.smartlocation.location.config.LocationParams;
import io.nlopez.smartlocation.location.providers.LocationGooglePlayServicesWithFallbackProvider;

import static java.lang.Math.atan2;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static java.lang.Math.sqrt;
import static java.lang.Math.toRadians;

public class Mapcal extends MapsActivity {

    MapsActivity map;
    public Mapcal(){
        map = new MapsActivity();
        map.onStart();
        map.startSmartLocation();
        
        Log.d("check cal",+latitude+","+longitude);
    }


    void cal(ArrayList<Navi> dirArray, ArrayList<Navi> stationarray)
    {    double d;
        int i;
        int k=0;
        int j=0;
        double R= 6371e3;
        double lat=toRadians(latitude);
        double lon=toRadians(longitude);
        for(i=0;i<dirArray.size();i++) {
            double lat2 =dirArray.get(i).getLat();
            double lon2 =dirArray.get(i).getLon();
            lat2 = toRadians(lat2);
            lon2 = toRadians(lon2);
//              Log.d("check lat lon",""+ lat +  "," + lon + ", " + lat2 + ", " + lon2);

            double a = (sin((lat2-lat)/2)*sin((lat2-lat)/2))+(cos(lat)*(cos(lat2)*sin((lon2-lon)/2)*sin((lon2-lon)/2)));
            double c = 2*atan2(sqrt(a),sqrt(1-a));
//              Log.d("check c",""+c );

            d = R*c;
            dirArray.get(i).setDis(d);

            if(d<1000)
            {
                stationarray.add(dirArray.get(i));
                Log.d("check dis",""+stationarray.get(k).getDis() );
                k++;
            }
        }

    }

}

