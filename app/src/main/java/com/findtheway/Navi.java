package com.findtheway;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Ty on 12/7/2017.
 */

public class Navi implements Parcelable {
    private String Line;
    private String ID;
    private String Name;
    private String Trip;
    private String Lat;
    private String Lon;
    public Navi(){

    }

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(Line);
        dest.writeString(ID);
        dest.writeString(Lat);
        dest.writeString(Lon);
        dest.writeString(Trip);
    }

    private Navi(Parcel in){
        this.Line = in.readString();
        this.ID = in.readString();
        this.Lat = in.readString();
        this.Lon = in.readString();
        this.Trip = in.readString();
    }

    public static final Parcelable.Creator<Navi> CREATOR = new Parcelable.Creator<Navi>() {

        @Override
        public Navi createFromParcel(Parcel source) {
            return new Navi(source);
        }

        @Override
        public Navi[] newArray(int size) {
            return new Navi[size];
        }
    };


}
