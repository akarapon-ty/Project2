package com.findtheway;

import android.content.Intent;
import android.os.Bundle;
import com.findtheway.MapsActivity;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import java.util.ArrayList;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @Override
protected void onCreate(Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
    fab.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View view) {

            Intent intent = new Intent(MainActivity.this, MapsActivity.class);
            startActivity(intent);


        }
    });

    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
}
//
//    public class Main extends Activity {
//        SQLiteDatabase mDb;
//        Database mHelper;
//        Cursor mCursor;
//
//        public void onCreate(Bundle savedInstanceState) {
//            super.onCreate(savedInstanceState);
//            requestWindowFeature(Window.FEATURE_NO_TITLE);
//            setContentView(R.layout.main);
//
//            ListView listView1 = (ListView)findViewById(R.id.listview1);
//
//            mHelper = new Database(this);
//            mDb = mHelper.getWritableDatabase();
//            mHelper.onUpgrade(mDb, 1, 1);
//
//            mCursor = mDb.rawQuery("SELECT " + Database.COL_NAME + ", "
//                    + Database.COL_Latitude + ", " + Database.COL_Longitude + ", "
//                    + Database.Bus_line09 + " FROM " + Database.TABLE_NAME, null);
//
//            ArrayList<String> dirArray = new ArrayList<String>();
//            mCursor.moveToFirst();
//
//            while ( !mCursor.isAfterLast() ){
//                dirArray.add("Name : " + mCursor.getString
//                        (mCursor.getColumnIndex(Database.COL_NAME)) + "\n"
//                        + "LAT : " + mCursor.getString(mCursor.getColumnIndex
//                        (Database.COL_Latitude)) + "\n"
//                        + "LONG : " + mCursor.getString(mCursor.getColumnIndex
//                        (Database.COL_Longitude)) + "\n"
//                        + "BUS : " + mCursor.getString(mCursor.getColumnIndex
//                        (Database.Bus_line09)));
//                mCursor.moveToNext();
//            }
//
//            ArrayAdapter<String> adapterDir =
//                    new ArrayAdapter<String>(getApplicationContext()
//                            , android.R.layout.simple_list_item_1, dirArray);
//            listView1.setAdapter(adapterDir);
//        }
//
//        public void onPause() {
//            super.onPause();
//            mHelper.close();
//            mDb.close();
//        }
//    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    //@Override
    //public boolean onCreateOptionsMenu(Menu menu) {
      //  // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.main, menu);
        //return true;
    //}

   // @Override
    //public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
      //  int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        //if (id == R.id.action_settings) {
          //  return true;
        //}

        //return super.onOptionsItemSelected(item);
    //}



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_share) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
