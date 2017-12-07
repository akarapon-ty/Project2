package com.findtheway;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by Ty on 12/6/2017.
 */

public class Bus implements Parcelable {
    private String line;
    private String PolylineB;
    private String Polyline;
    private String Level;
    private String LevelB;
    public String getLevel() {
        return Level;
    }
    public Bus(){

    }

    public void setLevel(String level) {
        Level = level;
    }


    public String getPolyline() {
        return Polyline;
    }

    public void setPolyline(String polyline) {
        Polyline = polyline;
    }


    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }


    public String getPolylineB() {
        return PolylineB;
    }

    public void setPolylineB(String polylineB) {
        PolylineB = polylineB;
    }

    public String getLevelB() {
        return LevelB;
    }

    public void setLevelB(String levelB) {
        LevelB = levelB;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(line);
        dest.writeString(Polyline);
        dest.writeString(PolylineB);
        dest.writeString(Level);
        dest.writeString(LevelB);
    }

    private Bus(Parcel in){
        this.line = in.readString();
        this.Polyline = in.readString();
        this.PolylineB = in.readString();
        this.Level = in.readString();
        this.LevelB = in.readString();
    }

    public static final Parcelable.Creator<Bus> CREATOR = new Parcelable.Creator<Bus>() {

        @Override
        public Bus createFromParcel(Parcel source) {
            return new Bus(source);
        }

        @Override
        public Bus[] newArray(int size) {
            return new Bus[size];
        }
    };


}
