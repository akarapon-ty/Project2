package com.findtheway;

/**
 * Created by Ty on 12/7/2017.
 */

public class Navi {
    private String Line;
    private String ID;
    private String Name;
    private String Trip;
    private String Lat;
    private String Lon;

    public String getLine() {
        return Line;
    }
    public void setLine(String line) {
        Line = line;
    }
    public String getID() {
        return ID;
    }
    public void setID(String ID) {
        this.ID = ID;
    }
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    public String getLat() {
        return Lat;
    }
    public void setLat(String lat) {
        Lat = lat;
    }
    public String getLon() {
        return Lon;
    }
    public void setLon(String lon) {
        Lon = lon;
    }
    public String getTrip() {
        return Trip;
    }

    public void setTrip(String trip) {
        Trip = trip;
    }


}
