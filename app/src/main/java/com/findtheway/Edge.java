package com.findtheway;

import android.os.Parcel;
import android.os.Parcelable;

public class Edge{
    int Idfrom;
    int lineto;
    int Idto;
    int Distance;
    String polyline;
    int Route;
    int linefrom;

    public Node getNodefrom() {
        return nodefrom;
    }

    public void setNodefrom(Node nodefrom) {
        this.nodefrom = nodefrom;
    }

    public Node getNodeto() {
        return nodeto;
    }

    public void setNodeto(Node nodeto) {
        this.nodeto = nodeto;
    }

    Node nodefrom;
    Node nodeto;

    public Edge() {

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

    public int getIdfrom() {
        return Idfrom;
    }

    public void setIdfrom(int idfrom) {
        Idfrom = idfrom;
    }

    public int getLineto() {
        return lineto;
    }

    public void setLineto(int lineto) {
        this.lineto = lineto;
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


    public Node getNeighbour(Node node) {
        if (nodefrom.equals(node)) {
            return nodeto;
        } else {
            return nodefrom;
        }
    }

}
