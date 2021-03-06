package com.mysoulmyc.android.appenglish;

import android.app.AlarmManager;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.mysoulmyc.android.appenglish.DB.CharacterInfo;
import com.mysoulmyc.android.appenglish.DB.DatabaseAccess;

import java.util.Calendar;

//import android.support.v4.app.Fragment;



public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {


    private DrawerLayout mDrawerLayout;
    private ListView mlistView;
    private String[] mSelectActivity;
    private ActionBarDrawerToggle mdrawerListener;
    CharacterInfo dateout;
    private PendingIntent pendingIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDrawerLayout=(DrawerLayout) findViewById(R.id.drawer_layout);
        mSelectActivity=getResources().getStringArray(R.array.SelectActivity);
        mlistView=(ListView) findViewById(R.id.left_drawer);
        mlistView.setAdapter(new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, mSelectActivity));
        mlistView.setOnItemClickListener(this);
        //Animation actionbar
        mdrawerListener= new ActionBarDrawerToggle(this, mDrawerLayout,
                //R.drawable.ic_drawer,
                R.string.drawer_open,
                R.string.drawer_close){
            @Override
            public void onDrawerClosed(View drawerView){
                super.onDrawerClosed(drawerView);
            }
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };
        mDrawerLayout.setDrawerListener(mdrawerListener);

        //ให้แท็บจากปุ่มด้านบนก็ได้หรือสไลด์เองก็ได้
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //load first fragment as main page
        FragmentManager fm = getFragmentManager();
        fm.beginTransaction().replace(R.id.maincontent, new Fragment1_main()).commit();

        final DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        dateout = databaseAccess.getCharacter();
        databaseAccess.close();


        ///////////// alarm manager
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        Intent notificationIntent = new Intent(MainActivity.this, AlarmReceiver.class);
        //Intent notificationIntent = new Intent("android.media.action.DISPLAY_NOTIFICATION");
        //notificationIntent.addCategory("android.intent.category.DEFAULT");

        pendingIntent = PendingIntent.getBroadcast(this, 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        Calendar alarmStartTime = Calendar.getInstance();
        //Calendar now = Calendar.getInstance();
        alarmStartTime.setTimeInMillis(System.currentTimeMillis());
        alarmStartTime.set(Calendar.HOUR_OF_DAY, 8);
        alarmStartTime.set(Calendar.MINUTE,0);
        alarmStartTime.set(Calendar.SECOND,0);

        /*if (now.after(alarmStartTime)){
            Log.d("Hey"," Added a day");
            //alarmStartTime.add(Calendar.DATE,1);
            alarmManager.cancel(pendingIntent);
        }*/
        //cal.set(Calendar.MINUTE,52);
        //alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, alarmStartTime.getTimeInMillis(), AlarmManager.INTERVAL_HALF_DAY, pendingIntent);
        alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP, alarmStartTime.getTimeInMillis(), 1000 * 60 * 60 * 12 , pendingIntent);
        Log.d("Alarm", " Alarm set for everyday 8.00 am and Repeat again in 8.00 pm");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(mdrawerListener.onOptionsItemSelected(item))
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Forward the new configuration the drawer toggle component.
        mdrawerListener.onConfigurationChanged(newConfig);
    }


    @Override
    protected void onPostCreate(Bundle savedInstanceState){
        super.onPostCreate(savedInstanceState);
        mdrawerListener.syncState();
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this,mSelectActivity[position]+" was selected. ", Toast.LENGTH_LONG).show();
        selectItem(position);
    }

    private void selectItem(int position) {
        mlistView.setItemChecked(position, true);
        setTitle(mSelectActivity[position]);

        Fragment objFragment = null;
        switch (position) {
            case 0:
                objFragment = new Fragment1_main();
                mDrawerLayout.closeDrawers();
                break;
            case 1:
                objFragment = new Fragment2_lesson();
                mDrawerLayout.closeDrawers();
                break;
            case 2:
                objFragment = new Fragment3_test();
                mDrawerLayout.closeDrawers();
                break;
            case 3:
                objFragment = new Fragment4_mixtest();
                mDrawerLayout.closeDrawers();
                break;
            case 4:
                objFragment = new Fragment5_scroe();
                mDrawerLayout.closeDrawers();
                break;
            case 5:
                objFragment = new Fragment6_credit();
                mDrawerLayout.closeDrawers();
                break;
/*            case 6:
                objFragment = new Notifify();
                mDrawerLayout.closeDrawers();
                break;*/
        }

        //update the main content by replacing fragment
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.maincontent, objFragment).commit();

    }

    private Context getActivity() {
        return null;
    }


    public void setTitle(String title){
        getSupportActionBar().setTitle(title);
    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        FragmentManager fm = getFragmentManager();
        fm.beginTransaction().replace(R.id.maincontent, new Notifify()).commit();

        return true;
    }*/

    // exit app
    public void onBackPressed() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this,R.style.Base_Theme_AppCompat_Dialog_Alert);
        dialog.setTitle("Exit");
        dialog.setCancelable(true);
        dialog.setMessage("Do you want to exit?");
        dialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                updateTime();
                finish();
            }
        });

        dialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        dialog.show();

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    private void updateTime() {
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        databaseAccess.updateTimeOut(dateout);
        Toast.makeText(this, "Update date time!", Toast.LENGTH_LONG).show();
        databaseAccess.close();
    }



}