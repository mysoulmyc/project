package com.example.toshiba.appenglish.tutorial;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;

import com.example.toshiba.appenglish.R;
import com.viewpagerindicator.CirclePageIndicator;

/**
 * Created by Toshiba on 5/5/2559.
 */
public class TutorialPage extends FragmentActivity {

    MyPageAdapter adapter;
    ViewPager pager;
    CirclePageIndicator indicator;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tutorial_layout);

        adapter = new MyPageAdapter(getSupportFragmentManager());

        pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(adapter);

        indicator = (CirclePageIndicator)findViewById(R.id.indicator);
        indicator .setViewPager(pager);
    }

    public void onBackPressed() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this,R.style.Base_Theme_AppCompat_Dialog_Alert);
        dialog.setTitle("Exit");
        dialog.setCancelable(true);
        dialog.setMessage("Do you want to exit?");
        dialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
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

}
