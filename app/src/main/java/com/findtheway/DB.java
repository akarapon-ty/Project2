package com.findtheway;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
/**
 * Created by Ty on 12/5/2017.
 */

public class DB extends SQLiteOpenHelper {
    private static final String DB_NAME = "bus";
    private static final int DB_VERSION = 1;

    public static final String TABLE_NAME = "Customer";

    public static final String COL_NAME = "Name Station";
    public static final String COL_Lat = "Latitude";
    public static final String COL_Lon = "Longitude";
    public static final String COL_Bus11 = "Busline11";
    public static final String COL_Bus09 = "Busline09";
    public static final String COL_Bus10 = "Busline10";
    public static final String COL_Bus70 = "Busline70";

    Context context;

    public DB(Context ctx) {
        super(ctx, DB_NAME, null, DB_VERSION);
        context = ctx;
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME
                + " (_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COL_NAME + "TEXT, " + COL_Lat + " DOUBLE, "
                + COL_Lon  + " DOUBLE, " + COL_Bus11 + " INTEGER, "
                + COL_Bus09 + "INTEGER," + COL_Bus10 + "INTEGER,"
                + COL_Bus70 + "INTEGER);");


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
                            + " (" + COL_NAME + ", " + COL_Lat
                            + ", " + COL_Lon + ", " + COL_Bus11
                            + "," + COL_Bus09 +", " + COL_Bus10 +"," + COL_Bus70 +") VALUES ('" + str[0]
                            + "', '" + str[1] + "', " + str[2]
                            + ", '" + str[3] + "', '" + str[4] + "', '" + str[5] + "', '" + str[6] + "', '" + str[7] + "');");
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
