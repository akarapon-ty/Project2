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
    DBdis mHelperdis;
    Cursor mCursordis;

    public DB_listdis() {
        mHelperdis = new DBdis(this);
        mDb = mHelperdis.getWritableDatabase();
        mHelperdis.onUpgrade(mDb, 1, 1);

        mCursordis = mDb.rawQuery("SELECT " + DBdis.COL_Route + ", "
                + DBdis.COL_Linefrom + ", " + DBdis.COL_Lineto + ", "
                + DBdis.COL_IDform + ", " + DBdis.COL_IDto + " , "
                + DBdis.COL_Distance + ", " + DBdis.COL_Polyline + " FROM " + DBdis.TABLE_NAME, null);
        ArrayList<dis> disArray = new ArrayList<>();
        mCursordis.moveToFirst();

        while (!mCursordis.isAfterLast()) {
            dis b = new dis();
            b.setRoute(mCursordis.getInt(mCursordis.getColumnIndex(DBdis.COL_Route)));
            b.setLinefrom(mCursordis.getInt(mCursordis.getColumnIndex(DBdis.COL_Linefrom)));
            b.setLineto(mCursordis.getInt(mCursordis.getColumnIndex(DBdis.COL_Lineto)));
            b.setIdfrom(mCursordis.getInt(mCursordis.getColumnIndex(DBdis.COL_IDform)));
            b.setIdto(mCursordis.getInt(mCursordis.getColumnIndex(DBdis.COL_IDto)));
            b.setDistance(mCursordis.getInt(mCursordis.getColumnIndex(DBdis.COL_Distance)));
            b.setPolyline(mCursordis.getString(mCursordis.getColumnIndex(DBdis.COL_Polyline)));
            disArray.add(b);
            mCursordis.moveToNext();
        }
        final CustomAdapterdis adapter = new CustomAdapterdis(this, disArray);
//        Log.d("test datanavi",dirArray.size()+", "+dirArray.get(0).getLine());

    }
}

