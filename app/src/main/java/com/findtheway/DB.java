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

public class DB extends SQLiteOpenHelper {
    private static final String DB_NAME = "Road";
    private static final int DB_VERSION = 1;

    public static final String TABLE_NAME = "Bus";
    public static final String COL_Line = "Line";
    public static final String COL_Trip = "Trip";
    public static final String COL_Level = "Level";
    public static final String COL_Polyline = "Polyline";

    Context context;

    public DB(Context ctx) {
        super(ctx, DB_NAME, null, DB_VERSION);
        context = ctx;
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME
                + " (_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COL_Line + " TEXT, " + COL_Trip + " TEXT, "
                + COL_Polyline + " TEXT,"+ COL_Level +" TEXT);");

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
                            + " (" + COL_Line + ", " + COL_Trip
                            + ", " + COL_Polyline +", " +COL_Level+ ") VALUES ('" + str[0]
                            + "', '" + str[1] + "', '" + str[2]
                            + "', '" + str[3] + "');");
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
