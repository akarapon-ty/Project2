package com.findtheway;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * Created by Ty on 12/6/2017.
 */

public class listmanu extends AppCompatActivity {
    ListView lst;
    st_bus b = new st_bus();
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
                + DB.COL_Polyline + ", " + DB.COL_Trip + ","+ DB.COL_Level +" FROM " + DB.TABLE_NAME, null);

        ArrayList<st_bus> dirArray = new ArrayList<>();
        mCursor.moveToFirst();

        while ( !mCursor.isAfterLast() ){
            st_bus b = new st_bus();
            b.setLine(mCursor.getString(mCursor.getColumnIndex(DB.COL_Line)));
            b.setPolyline(mCursor.getString(mCursor.getColumnIndex(DB.COL_Polyline)));
            b.setTrip(mCursor.getString(mCursor.getColumnIndex(DB.COL_Trip)));
            b.setLevel(mCursor.getString(mCursor.getColumnIndex(DB.COL_Level)));
            dirArray.add(b);
            mCursor.moveToNext();
        }
        ArrayAdapter<st_bus> adapterDir = new ArrayAdapter<st_bus>(this, android.R.layout.simple_list_item_1,dirArray);
        lst.setAdapter(adapterDir);
        Log.d("test",dirArray.size()+", "+dirArray.get(0).getLine());

    }

}

