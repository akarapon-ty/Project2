package com.findtheway;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * Created by Ty on 12/6/2017.
 */

public class DB_listbus extends AppCompatActivity {
    ListView lst;
    Bus b = new Bus();
    SQLiteDatabase mDb;
    DBbus mHelper;
    Cursor mCursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bus);
        mHelper = new DBbus(this);
        mDb = mHelper.getWritableDatabase();
        mHelper.onUpgrade(mDb, 1, 1);

        mCursor = mDb.rawQuery("SELECT " + DBbus.COL_Line + ", "
                + DBbus.COL_Polyline + ", " + DBbus.COL_Level + ", "
                + DBbus.COL_Polyline +", " + DBbus.COL_PolylineB + " , "
                + DBbus.COL_LevelB + " FROM " + DBbus.TABLE_NAME, null);

        ArrayList<Bus> dirArray = new ArrayList<>();
        mCursor.moveToFirst();

        while ( !mCursor.isAfterLast() ){
            Bus b = new Bus();
            b.setLine(mCursor.getString(mCursor.getColumnIndex(DBbus.COL_Line)));
            b.setPolyline(mCursor.getString(mCursor.getColumnIndex(DBbus.COL_Polyline)));
            b.setLevel(mCursor.getString(mCursor.getColumnIndex(DBbus.COL_Level)));
            b.setPolylineB(mCursor.getString(mCursor.getColumnIndex(DBbus.COL_PolylineB)));
            b.setLevelB(mCursor.getString(mCursor.getColumnIndex(DBbus.COL_LevelB)));
            dirArray.add(b);
            mCursor.moveToNext();
        }
        final CustomAdaptercan adapter = new CustomAdaptercan(this,dirArray);
       Log.d("test databus",dirArray.size()+", "+dirArray.get(0).getLine());
        ListView listView = (ListView)findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Bus b = (Bus) adapter.getItem(i);
                Log.d("testinside","pass");
                Intent intent = new Intent(DB_listbus.this,Mapforpoly.class);
                intent.putExtra("x",b);
                startActivity(intent);
            }
        });

    }

}

