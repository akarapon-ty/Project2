package com.findtheway;

import android.util.Log;

/**
 * Created by Ty on 12/9/2017.
 */

public class cal extends MapsActivity {
    MapsActivity map;
    double lat;
    double lon;

    public cal(){
        lat = map.getLatitude();
        lon = map.getLongitude();
        Log.d("test lat lon cal",+lat+""+lon);
    }
}
