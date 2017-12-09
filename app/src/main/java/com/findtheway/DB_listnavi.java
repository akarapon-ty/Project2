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

public class DB_listnavi extends AppCompatActivity {
    ListView lst;
    Station b = new Station();
    SQLiteDatabase mDb;
    DBnavi mHelper;
    Cursor mCursor;
    double latsent;
    double lonsent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navi);
        lst= (ListView) findViewById(R.id.list);
        mHelper = new DBnavi(this);
        mDb = mHelper.getWritableDatabase();
        mHelper.onUpgrade(mDb, 1, 1);
        getIntent().getDoubleExtra("lat",latsent);
        getIntent().getDoubleExtra("lon",lonsent);
        Log.d("lat lon listnavi",+latsent+","+lonsent);

        mCursor = mDb.rawQuery("SELECT DISTINCT " + DBnavi.COL_Name + " FROM " + DBnavi.TABLE_NAME , null);

        ArrayList<Station> dirArray = new ArrayList<>();
        mCursor.moveToFirst();

        while ( !mCursor.isAfterLast() ){
            Station b = new Station();
            b.setName(mCursor.getString(mCursor.getColumnIndex(DBnavi.COL_Name)));
            dirArray.add(b);
            mCursor.moveToNext();
        }
       final CustomAdapterNavi adapter = new CustomAdapterNavi(this,dirArray);
//        Log.d("test datanavi",dirArray.size()+", "+dirArray.get(0).getLine());
        ListView listView = (ListView)findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Station b = (Station) adapter.getItem(i);
                Log.d("testinside","pass");
                Intent intent = new Intent(DB_listnavi.this,Mapforpoly2.class);
                intent.putExtra("x",b);
                intent.putExtra("latsent",latsent);
                intent.putExtra("lonsent",lonsent);
                startActivity(intent);
            }
        });
    }
}
