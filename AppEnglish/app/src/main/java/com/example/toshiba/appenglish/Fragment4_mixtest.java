package com.example.toshiba.appenglish;

/*
 * Created by Toshiba on 29/12/2558.
 */

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.toshiba.appenglish.DB.DatabaseAccess;
import com.example.toshiba.appenglish.DB.Score;

public class Fragment4_mixtest extends Fragment {
    View rootview;
    Button starttest;
    Score scoreLt;
    int fu4, date;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.layout4_mixtest, container, false);


        starttest = (Button) rootview.findViewById(R.id.but_starttest);

        final DatabaseAccess databaseAccess = DatabaseAccess.getInstance(getActivity());
        databaseAccess.open();
        scoreLt = databaseAccess.get_ScoreFu4();
        databaseAccess.close();

        starttest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTestFuturePerCon();
            }
        });


        return rootview;
    }

    private void setTestFuturePerCon() {
        if (scoreLt != null) {
            fu4 = scoreLt.getScore();
            date = scoreLt.getDate();
            if (fu4 >= 2) {
                Log.d("score", "Your score FuPerCon : " + scoreLt.getScore());
                FragmentManager fm = getFragmentManager();
                fm.beginTransaction().replace(R.id.maincontent, new Fragment4_mixtestPage()).commit();
                Toast.makeText(getActivity(), " Unlock!! ", Toast.LENGTH_LONG).show();
            } else {
                AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
                dialog.setTitle("Error");
                dialog.setCancelable(true);
                dialog.setMessage(" ต้องผ่านแบบทดสอบ Future Perfect Continuous tense ก่อน ");

                dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                dialog.show();
            }
        } else {
            AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
            dialog.setTitle("Error");
            dialog.setCancelable(true);
            dialog.setMessage(" ต้องผ่านแบบทดสอบ Future Perfect Continuous tense ก่อน ");

            dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });

            dialog.show();
        }
    }
}
