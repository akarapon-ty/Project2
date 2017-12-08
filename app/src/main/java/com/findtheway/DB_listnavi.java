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
    Navi b = new Navi();
    SQLiteDatabase mDb;
    DBnavi mHelper;
    Cursor mCursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navi);
        lst= (ListView) findViewById(R.id.list);
        mHelper = new DBnavi(this);
        mDb = mHelper.getWritableDatabase();
        mHelper.onUpgrade(mDb, 1, 1);

        mCursor = mDb.rawQuery("SELECT DISTINCT " + DBnavi.COL_Name + " FROM " + DBnavi.TABLE_NAME , null);

        ArrayList<Navi> dirArray = new ArrayList<>();
        mCursor.moveToFirst();

        while ( !mCursor.isAfterLast() ){
            Navi b = new Navi();
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
                Navi b = (Navi) adapter.getItem(i);
                Log.d("testinside","pass");
                Intent intent = new Intent(DB_listnavi.this,Mapcal.class);
                intent.putExtra("x",b);
                startActivity(intent);
            }
        });
    }
}
