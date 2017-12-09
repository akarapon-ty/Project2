package com.findtheway;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Ty on 12/6/2017.
 */

public class DB_listdis extends AppCompatActivity {
    dis b = new dis();
    SQLiteDatabase mDb;
    DBdis mHelper;
    Cursor mCursor;

    public DB_listdis() {
        mHelper = new DBdis(this);
        mDb = mHelper.getWritableDatabase();
        mHelper.onUpgrade(mDb, 1, 1);

        mCursor = mDb.rawQuery("SELECT " + DBdis.COL_Route + ", "
                + DBdis.COL_Linefrom + ", " + DBdis.COL_Lineto + ", "
                + DBdis.COL_IDform + ", " + DBdis.COL_IDto + " , "
                + DBdis.COL_Distance + ", " + DBdis.COL_Polyline + " FROM " + DBdis.TABLE_NAME, null);
        ArrayList<dis> disArray = new ArrayList<>();
        mCursor.moveToFirst();

        while (!mCursor.isAfterLast()) {
            dis b = new dis();
            b.setRoute(mCursor.getInt(mCursor.getColumnIndex(DBdis.COL_Route)));
            b.setLinefrom(mCursor.getInt(mCursor.getColumnIndex(DBdis.COL_Linefrom)));
            b.setLineto(mCursor.getInt(mCursor.getColumnIndex(DBdis.COL_Lineto)));
            b.setIdfrom(mCursor.getInt(mCursor.getColumnIndex(DBdis.COL_IDform)));
            b.setIdto(mCursor.getInt(mCursor.getColumnIndex(DBdis.COL_IDto)));
            b.setDistance(mCursor.getInt(mCursor.getColumnIndex(DBdis.COL_Distance)));
            b.setPolyline(mCursor.getString(mCursor.getColumnIndex(DBdis.COL_Polyline)));
            disArray.add(b);
            mCursor.moveToNext();
        }
        final CustomAdapterdis adapter = new CustomAdapterdis(this, disArray);
//        Log.d("test datanavi",dirArray.size()+", "+dirArray.get(0).getLine());

    }
}

