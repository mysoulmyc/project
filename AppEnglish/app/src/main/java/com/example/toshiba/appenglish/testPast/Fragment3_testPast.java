package com.example.toshiba.appenglish.testPast;

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
import com.example.toshiba.appenglish.Fragment3_test;
import com.example.toshiba.appenglish.R;

/*
 * Created by Toshiba on 5/1/2559.
 */
public class Fragment3_testPast extends Fragment implements View.OnClickListener {

    View rootview;
    Button butback,butSim, butCon, butPer, butPerCon;
    Score scoreLt, scoreLt2, scoreLt3, scoreLt4;
    int pre4, past1, past2, past3;
    int date;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.layout3_test_past,container,false);

        butback = (Button) rootview.findViewById(R.id.button_back);
        butSim = (Button) rootview.findViewById(R.id.but_testPast1);
        butCon = (Button) rootview.findViewById(R.id.but_testPast2);
        butPer = (Button) rootview.findViewById(R.id.but_testPast3);
        butPerCon = (Button) rootview.findViewById(R.id.but_testPast4);


        final DatabaseAccess databaseAccess = DatabaseAccess.getInstance(getActivity());
        databaseAccess.open();
        scoreLt = databaseAccess.getScoreUnlockTest4();
        scoreLt2 = databaseAccess.getScoreUnlockTest5();
        scoreLt3 = databaseAccess.getScoreUnlockTest6();
        scoreLt4 = databaseAccess.getScoreUnlockTest7();
        databaseAccess.close();


        butback.setOnClickListener(this);
        butSim.setOnClickListener(this);
        butCon.setOnClickListener(this);
        butPer.setOnClickListener(this);
        butPerCon.setOnClickListener(this);

        return rootview;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.button_back:
                FragmentManager fm = getFragmentManager();
                fm.beginTransaction().replace(R.id.maincontent, new Fragment3_test()).commit();
                break;
            case R.id.but_testPast1:
                setTestPastSim();
                break;
            case R.id.but_testPast2:
                setTestPastCon();
                break;
            case R.id.but_testPast3:
                setTestPastPer();
                break;
            case R.id.but_testPast4:
                setTestPastPerCon();
                break;
        }

    }

    private void setTestPastSim() {
        if (scoreLt != null) {
            pre4 = scoreLt.getScore();
            //date = scoreLt.getDate();
            if (pre4 != 0 && pre4 >= 7) {
                Log.d("score", "Your score PrePerCon : " + scoreLt.getScore());
                FragmentManager fm = getFragmentManager();
                fm.beginTransaction().replace(R.id.maincontent, new Fragment3_testPastPage1()).commit();
                Toast.makeText(getActivity(), " Unlock!! ", Toast.LENGTH_LONG).show();
            } else {
                Log.d("score", "Your score PrePerCon : " + scoreLt.getScore());
                AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
                dialog.setTitle("Error");
                dialog.setCancelable(true);
                dialog.setMessage(" ต้องผ่านแบบทดสอบ Present Perfect Continuous tense ก่อน ");

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
            dialog.setMessage(" ต้องผ่านแบบทดสอบ Present Perfect Continuous tense ก่อน ");

            dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });

            dialog.show();
        }
    }

    private void setTestPastCon() {
        if (scoreLt2 != null) {
            past1 = scoreLt2.getScore();
            //date = scoreLt2.getDate();
            if (past1 != 0 && past1 >= 7) {
                Log.d("score", "Your score PastSim : " + scoreLt2.getScore());
                FragmentManager fm = getFragmentManager();
                fm.beginTransaction().replace(R.id.maincontent, new Fragment3_testPastPage2()).commit();
                Toast.makeText(getActivity(), " Unlock!! ", Toast.LENGTH_LONG).show();
            } else {
                Log.d("score", "Your score PastSim : " + scoreLt2.getScore());
                AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
                dialog.setTitle("Error");
                dialog.setCancelable(true);
                dialog.setMessage(" ต้องผ่านแบบทดสอบ Past Simple tense ก่อน ");

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
            dialog.setMessage(" ต้องผ่านแบบทดสอบ Past Simple tense ก่อน ");

            dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });

            dialog.show();
        }
    }

    private void setTestPastPer() {
        if (scoreLt3 != null) {
            past2 = scoreLt3.getScore();
            //date = scoreLt3.getDate();
            if (past2 != 0 && past2 >= 7) {
                Log.d("score", "Your score PastCon : " + scoreLt3.getScore());
                FragmentManager fm = getFragmentManager();
                fm.beginTransaction().replace(R.id.maincontent, new Fragment3_testPastPage3()).commit();
                Toast.makeText(getActivity(), " Unlock!! ", Toast.LENGTH_LONG).show();
            } else {
                Log.d("score", "Your score PastCon : " + scoreLt3.getScore());
                AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
                dialog.setTitle("Error");
                dialog.setCancelable(true);
                dialog.setMessage(" ต้องผ่านแบบทดสอบ Past Continuous tense ก่อน ");

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
            dialog.setMessage(" ต้องผ่านแบบทดสอบ Past Continuous tense ก่อน ");

            dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });

            dialog.show();
        }
    }

    private void setTestPastPerCon() {
        if (scoreLt4 != null) {
            past3 = scoreLt4.getScore();
            //date = scoreLt4.getDate();
            if (past3 != 0 && past3 >= 7) {
                Log.d("score", "Your score PastPer : " + scoreLt4.getScore());
                FragmentManager fm = getFragmentManager();
                fm.beginTransaction().replace(R.id.maincontent, new Fragment3_testPastPage4()).commit();
                Toast.makeText(getActivity(), " Unlock!! ", Toast.LENGTH_LONG).show();
            } else {
                Log.d("score", "Your score PastPer : " + scoreLt4.getScore());
                AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
                dialog.setTitle("Error");
                dialog.setCancelable(true);
                dialog.setMessage(" ต้องผ่านแบบทดสอบ Past Perfect tense ก่อน ");

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
            dialog.setMessage(" ต้องผ่านแบบทดสอบ Past Perfect tense ก่อน ");

            dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });

            dialog.show();
        }
    }



}
