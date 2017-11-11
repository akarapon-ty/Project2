package com.findtheway;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EdgeEffect;

import java.util.ArrayList;

/**
 * Created by Ty on 11/10/2017.
 */

public class Node
{
    private int distanceFromSource = Integer.MAX_VALUE;

    private boolean visited;

    private ArrayList<Edge> edges = new ArrayList<Edge>();

    public int getDistanceFromSource(){
        return distanceFromSource;
    }
    public void setDistanceFromSource(int distanceFromSource){
        this.distanceFromSource = distanceFromSource;
    }
    public boolean isVisited(){
        return visited;
    }
    public void setVisited(boolean visited){
        this.visited = visited;
    }


    public ArrayList<Edge> getEdges() {
        return edges;
    }

    public void setEdges(ArrayList<Edge> edges) {this.edges = edges;}
}

