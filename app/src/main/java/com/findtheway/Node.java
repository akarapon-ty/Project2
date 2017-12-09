package com.findtheway;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
public class Node {
    private int distanceFromSource = Integer.MAX_VALUE;
    private Node prevNode;
    private boolean visited;
    private ArrayList<Edge> edges = new ArrayList<>(); // now we must create edges
    private int Line;
    private int ID;
    private String Name;
    private String Trip;
    private Double Lat;
    private Double Lon;
    private double Dis;

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

    public String getTrip() {
        return Trip;
    }

    public void setTrip(String trip) {
        Trip = trip;
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

    public double getDis() {
        return Dis;
    }

    public void setDis(double dis) {
        Dis = dis;
    }

    public Node getPrevNode() {
        return prevNode;
    }

    public void setPrevNode(Node prevNode) {
        this.prevNode = prevNode;
    }

    public int getDistanceFromSource() {
        return distanceFromSource;
    }
    public void setDistanceFromSource(int distanceFromSource) {
        this.distanceFromSource = distanceFromSource;
    }
    public boolean isVisited() {
        return visited;
    }
    public void setVisited(boolean visited) {
        this.visited = visited;
    }
    public ArrayList<Edge> getEdges() {
        return edges;
    }
    public void setEdges(ArrayList<Edge> edges) {
        this.edges = edges;
    }
    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(Line);
        dest.writeInt(ID);
        dest.writeString(Name);
        dest.writeDouble(Lat);
        dest.writeDouble(Lon);
        dest.writeString(Trip);
        dest.writeDouble(Dis);
    }
    public Node(){

    }
    private Node(Parcel in){
        this.Line = in.readInt();
        this.ID = in.readInt();
        this.Name = in.readString();
        this.Lat = in.readDouble();
        this.Lon = in.readDouble();
        this.Trip = in.readString();
        this.Dis = in.readDouble();
    }

    public static final Parcelable.Creator<Node> CREATOR = new Parcelable.Creator<Node>() {

        @Override
        public Node createFromParcel(Parcel source) {
            return new Node(source);
        }

        @Override
        public Node[] newArray(int size) {
            return new Node[size];
        }
    };
}