package com.findtheway;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Ty on 12/5/2017.
 */

public class DBdis extends SQLiteOpenHelper {
    private static final String DB_NAME = "distance";
    private static final int DB_VERSION = 1;

    public static final String TABLE_NAME = "st2";
    public static final String COL_Route = "Route";
    public static final String COL_Linefrom = "Linefrom";
    public static final String COL_Lineto = "Lineto";
    public static final String COL_IDform = "IDform";
    public static final String COL_IDto ="IDto";
    public static final String COL_Distance ="Distance";
    public static final String COL_Polyline ="Polyline";

    Context context;

    public DBdis(Context ctx) {
        super(ctx, DB_NAME, null, DB_VERSION);
        context = ctx;
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL("CREATE TABLE " + TABLE_NAME
                + " (_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COL_Route + " INTEGER, " + COL_Linefrom + " INTEGER, "
                + COL_Lineto + " INTEGER, " + COL_IDform + " INTEGER, "
                + COL_IDto + " INTEGER, " + COL_Distance + " INTEGER, "
                + COL_Polyline +" TEXT);");

        try {
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(context.getAssets().open(
                            "dis.csv")));
            String readLine = null;
            readLine = br.readLine();

            try {
                while ((readLine = br.readLine()) != null) {
                    String[] str = readLine.split(",");
                    db.execSQL("INSERT INTO " + TABLE_NAME
                            + " (" + COL_Route + ", " + COL_Linefrom
                            + ", " + COL_Lineto + ", " + COL_IDform
                            + ", " + COL_IDto + ", " + COL_Distance + ", " + COL_Polyline + ") " + "VALUES (" + str[0]
                            + ", " + str[1] + ", " + str[2]
                            + ", " + str[3] + ", "  + str[4] + ", " + str[5] + ", '" + str[6] + "');");
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
