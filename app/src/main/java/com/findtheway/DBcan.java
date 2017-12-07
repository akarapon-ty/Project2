package com.findtheway;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Ty on 12/5/2017.
 */

public class DBcan extends SQLiteOpenHelper {
    private static final String DB_NAME = "Road";
    private static final int DB_VERSION = 1;

    public static final String TABLE_NAME = "Can";
    public static final String COL_Line = "Line";
    public static final String COL_PolylineB = "PolylineB";
    public static final String COL_Level = "Level";
    public static final String COL_Polyline = "Polyline";
    public static final String COL_LevelB ="LevelB";

    Context context;

    public DBcan(Context ctx) {
        super(ctx, DB_NAME, null, DB_VERSION);
        context = ctx;
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME
                + " (_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COL_Line + " TEXT, " + COL_Polyline + " TEXT,"
                + COL_Level +" TEXT,"+ COL_PolylineB +" TEXT,"+ COL_LevelB +" TEXT);");

        try {
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(context.getAssets().open(
                            "busline.csv")));
            String readLine = null;
            readLine = br.readLine();

            try {
                while ((readLine = br.readLine()) != null) {
                    String[] str = readLine.split(",");
                    db.execSQL("INSERT INTO " + TABLE_NAME
                            + " (" + COL_Line + ", " + COL_Polyline
                            + ", " + COL_Level +", " + COL_PolylineB
                            +"," + COL_LevelB + ") " + "VALUES ('" + str[0]
                            + "', '" + str[1] + "', '" + str[2]
                            + "', '" + str[3] + "','"  + str[4] + "');");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion
            , int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
