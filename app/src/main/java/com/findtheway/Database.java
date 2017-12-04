package com.findtheway;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

class Database extends SQLiteOpenHelper {
    private static final String DB_NAME = "BTS.db";
    private static final int DB_VERSION = 1;
    public static final String TABLE_NAME = "BTS";
    public static final String ID = "ID";
    public static final String COL_NAME = "Data_station";
    public static final String COL_Latitude = "Latitude";
    public static final String COL_Longitude = "Longitude";

    public Database(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    public void onCreate(SQLiteDatabase db) {
      db.execSQL("create table " + TABLE_NAME +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,Data_station TEXT,Latitude DOUBLE, Longitude DOUBLE )");

    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}