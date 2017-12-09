package com.findtheway;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Ty on 12/7/2017.
 */

public class Station implements Parcelable {
    private int Line;
    private int ID;
    private String Name;
    private String Trip;
    private Double Lat;
    private Double Lon;
    private double Dis;

    public double getDis() {
        return Dis;
    }

    public void setDis(double dis) {
        Dis = dis;
    }




    public Station(){
    }

    public int getLine() {
        return Line;
    }
    public void setLine(int line) {
        Line = line;
    }
    public int getID() {
        return ID;
    }
    public void setID(int ID) {
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

    private Station(Parcel in){
//        this.Line = in.readString();
//        this.ID = in.readString();
        this.Name = in.readString();
//        this.Lat = in.readDouble();
//        this.Lon = in.readDouble();
//        this.Trip = in.readString();
//        this.Dis = in.readDouble();
    }

    public static final Parcelable.Creator<Station> CREATOR = new Parcelable.Creator<Station>() {

        @Override
        public Station createFromParcel(Parcel source) {
            return new Station(source);
        }

        @Override
        public Station[] newArray(int size) {
            return new Station[size];
        }
    };



}
