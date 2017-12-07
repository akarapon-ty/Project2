package com.findtheway;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Ty on 12/6/2017.
 */

public class listbus extends AppCompatActivity {
    ListView lst;
    Bus b = new Bus();
    SQLiteDatabase mDb;
    DB mHelper;
    Cursor mCursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigator);
        lst= (ListView) findViewById(R.id.list);
        mHelper = new DB(this);
        mDb = mHelper.getWritableDatabase();
        mHelper.onUpgrade(mDb, 1, 1);

        mCursor = mDb.rawQuery("SELECT " + DB.COL_Line + ", "
                + DB.COL_Polyline + ", " + DB.COL_Trip + " FROM " + DB.TABLE_NAME, null);

        ArrayList<Bus> dirArray = new ArrayList<>();
        mCursor.moveToFirst();

        while ( !mCursor.isAfterLast() ){
            Bus b = new Bus();
            b.setLine(mCursor.getString(mCursor.getColumnIndex(DB.COL_Line)));
            b.setPolyline(mCursor.getString(mCursor.getColumnIndex(DB.COL_Polyline)));
            b.setTrip(mCursor.getString(mCursor.getColumnIndex(DB.COL_Trip)));
            dirArray.add(b);
            mCursor.moveToNext();
        }
    }
}
