package com.findtheway;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Database extends SQLiteOpenHelper {
    private static final String DB_NAME = "BTS.db";
    private static final int DB_VERSION = 1;
    public static final String TABLE_NAME = "BTS";
    public static final String COL_NAME = "Data_station";
    public static final String COL_Latitude = "Latitude";
    public static final String COL_Longitude = "Longitude";
    public static final String Bus_line11 = "Line11";
    public static final String Bus_line09 = "Line09";
    public static final String Bus_line10 = "Line10";
    public static final String Bus_line70 = "Line70";


    Context context;

    public Database(Context ctx) {
        super(ctx, DB_NAME, null, DB_VERSION);
        context = ctx;
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME
                + " (_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COL_NAME + " TEXT,  " + COL_Latitude  + " DOUBLE, "
                + COL_Longitude + " DOUBLE, " + Bus_line11 + " INTEGER, " + Bus_line09 + " INTEGER, "
                + Bus_line10 + " INTEGER, " + Bus_line70 + " INEGER);");
        try {
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(context.getAssets().open(
                            "ิbusline.csv")));
            String readLine = null;
            readLine = br.readLine();

            try {
                while ((readLine = br.readLine()) != null) {
                    Log.i("Data Input", readLine);
                    String[] str = readLine.split(",");
                    db.execSQL("INSERT INTO " + TABLE_NAME
                            + " (" + COL_NAME + ", " + COL_Latitude
                            + ", " + COL_Longitude + ", " + Bus_line11 + ", " + Bus_line09 + ", "
                            + Bus_line10 + ", " + Bus_line70 + ") VALUES ('" + str[0]
                            + "', " + str[1] + ", " + str[2]
                            + "', " + str[3] + ", " + str[4]
                            + "', " + str[5] + ", " + str[6] + ");");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}