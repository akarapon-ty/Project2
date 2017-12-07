//package com.findtheway;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//import android.content.Context;
//import android.content.Intent;
//import android.database.sqlite.SQLiteDatabase;
//import android.database.sqlite.SQLiteOpenHelper;
//import android.util.Log;
//
///**
// * Created by Ty on 12/5/2017.
// */
//
//public class DBnavi extends SQLiteOpenHelper {
//    private static final String DB_NAME = "distance";
//    private static final int DB_VERSION = 1;
//
//    public static final String TABLE_NAME = "Bus";
//    public static final String COL_Line = "Line";
//    public static final String COL_ID = "ID";
//    public static final String COL_Name = "Name";
//    public static final String COL_Lat = "Lat";
//    public static final String COL_Lon ="Lon";
//    public static final String COL_Trip ="Trip";
//
//    Context context;
//
//    public DBnavi(Context ctx) {
//        super(ctx, DB_NAME, null, DB_VERSION);
//        context = ctx;
//    }
//
//    public void onCreate(SQLiteDatabase db) {
//        db.execSQL("CREATE TABLE " + TABLE_NAME
//                + " (_id INTEGER PRIMARY KEY AUTOINCREMENT, "
//                + COL_Line + " TEXT, " + COL_ID + " TEXT,"
//                + COL_Name +" TEXT,"+ COL_Lat +" TEXT,"+ COL_Lon
//                +" TEXT,"+COL_Trip+" TEXT);");
//
//        try {
//            BufferedReader br = new BufferedReader(
//                    new InputStreamReader(context.getAssets().open(
//                            "busline.csv")));
//            String readLine = null;
//            readLine = br.readLine();
//
//            try {
//                while ((readLine = br.readLine()) != null) {
//                    String[] str = readLine.split(",");
//                    db.execSQL("INSERT INTO " + TABLE_NAME
//                            + " (" + COL_Line + ", " + COL_ID
//                            + ", " + COL_Name +", " + COL_Lat
//                            + "," +COL_Lon+"," + COL_Trip + ") " + "VALUES ('" + str[0]
//                            + "', '" + str[1] + "', '" + str[2]
//                            + "', '" + str[3] + "','"  + str[4] + "','" + str[5] + "');");
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    public void onUpgrade(SQLiteDatabase db, int oldVersion
//            , int newVersion) {
//        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
//        onCreate(db);
//    }
//}
