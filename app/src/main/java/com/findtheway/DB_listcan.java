package com.findtheway;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * Created by Ty on 12/6/2017.
 */

public class DB_listcan extends AppCompatActivity {
    ListView lst;
    Bus b = new Bus();
    SQLiteDatabase mDb;
    DBcan mHelper;
    Cursor mCursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.can);
        mHelper = new DBcan(this);
        mDb = mHelper.getWritableDatabase();
        mHelper.onUpgrade(mDb, 1, 1);

        mCursor = mDb.rawQuery("SELECT " + DBcan.COL_Line + ", "
                + DBcan.COL_Polyline + ", " + DBcan.COL_Level + ", "
                + DBcan.COL_Polyline + ", " + DBcan.COL_PolylineB + ", "
                + DBcan.COL_LevelB + " FROM " + DBcan.TABLE_NAME, null);

        ArrayList<Bus> dirArray = new ArrayList<>();
        mCursor.moveToFirst();

        while ( !mCursor.isAfterLast() ){
            Bus b = new Bus();
            b.setLine(mCursor.getString(mCursor.getColumnIndex(DBcan.COL_Line)));
            b.setPolyline(mCursor.getString(mCursor.getColumnIndex(DBcan.COL_Polyline)));
            b.setLevel(mCursor.getString(mCursor.getColumnIndex(DBcan.COL_Level)));
            b.setPolylineB(mCursor.getString(mCursor.getColumnIndex(DBcan.COL_PolylineB)));
            b.setLevelB(mCursor.getString(mCursor.getColumnIndex(DBcan.COL_LevelB)));
            dirArray.add(b);
            mCursor.moveToNext();
        }

       final CustomAdaptercan adapter = new CustomAdaptercan(this,dirArray);
//        Log.d("test datacan",dirArray.size()+", "+dirArray.get(0).getLine());
        ListView listView = (ListView)findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Bus b = (Bus) adapter.getItem(i);
                Log.d("testinside","pass");
                Intent intent = new Intent(DB_listcan.this,Mapforpoly.class);
                intent.putExtra("x",b);
                startActivity(intent);
            }
        });


    }

}

