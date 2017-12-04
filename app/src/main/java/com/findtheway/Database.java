package com.findtheway;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

class Database extends SQLiteOpenHelper {
    private static final String DB_NAME = "BTS";
    private static final int DB_VERSION = 1;
    public static final String TABLE_NAME = "BTS";
    public static final String COL_NAME = "Data_station";
    public static final String COL_Latitude = "Latitude";
    public static final String COL_Longitude = "Longitude";

    public Database(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        SQLiteDatabase db = this.getWritableDatabase()
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME +" (_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COL_NAME + " TEXT, " + COL_Latitude + " INTEGER, "
                + COL_Longitude + " INTEGER);");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (" + COL_NAME + ", " + COL_Latitude
                + ", " + COL_Longitude + ") VALUES ('Central Rama II', 13.662943, 100.43951);");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (" + COL_NAME + ", " + COL_Latitude
                + ", " + COL_Longitude + ") VALUES ('Asiatique', 13.7034852, 100.5040301);");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (" + COL_NAME + ", " + COL_Latitude
                + ", " + COL_Longitude + ") VALUES ('BTS สะพานตากสิน',13.71802,100.514838);");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (" + COL_NAME + ", " + COL_Latitude
                + ", " + COL_Longitude + ") VALUES ('Max value ประชาอุทิศ', 13.639456, 100.500413);");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (" + COL_NAME + ", " + COL_Latitude
                + ", " + COL_Longitude + ") VALUES ('ตลาด61', 95, 750);");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (" + COL_NAME + ", " + COL_Latitude
                + ", " + COL_Longitude + ") VALUES ('ตลาดบางปะกอก', 13.6868331, 100.4128637);");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (" + COL_NAME + ", " + COL_Latitude
                + ", " + COL_Longitude + ") VALUES ('Siam square', 13.7451167, 100.5333712);");
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}