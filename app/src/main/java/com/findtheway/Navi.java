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
    private Double Lat;
    private Double Lon;
    private Double Dis;


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
    public Double getLat() {
        return Lat;
    }
    public void setLat(Double lat) {
        Lat = lat;
    }
    public Double getLon() {
        return Lon;
    }
    public void setLon(Double lon) {
        Lon = lon;
    }
    public String getTrip() {
        return Trip;
    }

    public void setTrip(String trip) {
        Trip = trip;
    }

    public Double getDis() {
        return Dis;
    }

    public void setDis(Double dis) {
        Dis = dis;
    }
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
//        dest.writeString(Line);
//        dest.writeString(ID);
        dest.writeString(Name);
//        dest.writeDouble(Lat);
//        dest.writeDouble(Lon);
//        dest.writeString(Trip);
//        dest.writeDouble(Dis);
    }

    private Navi(Parcel in){
//        this.Line = in.readString();
//        this.ID = in.readString();
        this.Name = in.readString();
//        this.Lat = in.readDouble();
//        this.Lon = in.readDouble();
//        this.Trip = in.readString();
//        this.Dis = in.readDouble();
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
