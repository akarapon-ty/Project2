//package com.findtheway;
//
//import android.database.Cursor;
//import android.database.sqlite.SQLiteDatabase;
//import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
//import android.util.Log;
//import android.widget.ListView;
//
//import java.util.ArrayList;
//
///**
// * Created by Ty on 12/6/2017.
// */
//
//public class DB_listnavi extends AppCompatActivity {
//    ListView lst;
//    Navi b = new Navi();
//    SQLiteDatabase mDb;
//    DBnavi mHelper;
//    Cursor mCursor;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.navi);
//        lst= (ListView) findViewById(R.id.list);
//        mHelper = new DBnavi(this);
//        mDb = mHelper.getWritableDatabase();
//        mHelper.onUpgrade(mDb, 1, 1);
//
//        mCursor = mDb.rawQuery("SELECT " + DBnavi.COL_Line + ", "
//                + DBnavi.COL_ID + ", " + DBnavi.COL_Name + ", " + DBnavi.COL_Lat+ ", "
//                + DBnavi.COL_Lon+ ", " + DBnavi.COL_Trip + " FROM " + DBcan.TABLE_NAME, null);
//
//        ArrayList<Navi> dirArray = new ArrayList<>();
//        mCursor.moveToFirst();
//
//        while ( !mCursor.isAfterLast() ){
//            Navi b = new Navi();
//            b.setLine(mCursor.getString(mCursor.getColumnIndex(DBnavi.COL_Line)));
//            b.setID(mCursor.getString(mCursor.getColumnIndex(DBnavi.COL_ID)));
//            b.setName(mCursor.getString(mCursor.getColumnIndex(DBnavi.COL_Name)));
//            b.setLat(mCursor.getString(mCursor.getColumnIndex(DBnavi.COL_Lat)));
//            b.setLon(mCursor.getString(mCursor.getColumnIndex(DBnavi.COL_Lon)));
//            b.setTrip(mCursor.getString(mCursor.getColumnIndex(DBnavi.COL_Trip)));
//            dirArray.add(b);
//            mCursor.moveToNext();
//        }
//        CustomAdapterNavi adapter = new CustomAdapterNavi(this,dirArray);
////        Log.d("test datanavi",dirArray.size()+", "+dirArray.get(0).getLine());
//        ListView listView = (ListView)findViewById(R.id.list);
//        listView.setAdapter(adapter);
//    }
//}
