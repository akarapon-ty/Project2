package com.findtheway;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Ty on 12/8/2017.
 */

public class dis implements Parcelable {

    int Route;
    int linefrom;
    int Idfrom;
    int lineto;
    int Idto;
    int Distance;
    String polyline;

    public dis(){

    }

    public int getRoute() {
        return Route;
    }
    public void setRoute(int route) {
        Route = route;
    }
    public int getLinefrom() {
        return linefrom;
    }
    public void setLinefrom(int linefrom) {
        this.linefrom = linefrom;
    }
    public int getLineto() {
        return lineto;
    }
    public void setLineto(int lineto) {
        this.lineto = lineto;
    }
    public int getIdfrom() {
        return Idfrom;
    }
    public void setIdfrom(int idfrom) {
        Idfrom = idfrom;
    }
    public int getIdto() {
        return Idto;
    }
    public void setIdto(int idto) {
        Idto = idto;
    }
    public int getDistance() {
        return Distance;
    }
    public void setDistance(int distance) {
        Distance = distance;
    }
    public String getPolyline() {
        return polyline;
    }
    public void setPolyline(String polyline) {
        this.polyline = polyline;
    }
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(Route);
        dest.writeInt(linefrom);
        dest.writeInt(lineto);
        dest.writeInt(Idfrom);
        dest.writeInt(Idto);
        dest.writeInt(Distance);
        dest.writeString(polyline);
    }

    private dis(Parcel in){
        this.Route = in.readInt();
        this.linefrom = in.readInt();
        this.lineto = in.readInt();
        this.Idfrom = in.readInt();
        this.Idto = in.readInt();
        this.Distance = in.readInt();
        this.polyline = in.readString();
    }

    public static final Parcelable.Creator<dis> CREATOR = new Parcelable.Creator<dis>() {

        @Override
        public dis createFromParcel(Parcel source) {
            return new dis(source);
        }

        @Override
        public dis[] newArray(int size) {
            return new dis[size];
        }
    };
}
