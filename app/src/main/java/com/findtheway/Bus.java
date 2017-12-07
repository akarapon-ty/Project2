package com.findtheway;

import java.util.ArrayList;

/**
 * Created by Ty on 12/6/2017.
 */

public class Bus {
    private String line;
    private String PolylineB;
    private String Polyline;
    private String Level;
    private String LevelB;
    public String getLevel() {
        return Level;
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
}
