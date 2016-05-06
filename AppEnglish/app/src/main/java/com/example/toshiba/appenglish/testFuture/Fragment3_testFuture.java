package com.example.toshiba.appenglish.testFuture;

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
public class Fragment3_testFuture extends Fragment implements View.OnClickListener {

    View rootview;
    Button butback,butSim, butCon, butPer, butPerCon;
    Score scoreLt, scoreLt2, scoreLt3, scoreLt4;
    int past4, fu1, fu2, fu3;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.layout3_test_future,container,false);

        butback = (Button) rootview.findViewById(R.id.button_back);
        butSim = (Button) rootview.findViewById(R.id.but_testFu1);
        butCon = (Button) rootview.findViewById(R.id.but_testFu2);
        butPer = (Button) rootview.findViewById(R.id.but_testFu3);
        butPerCon = (Button) rootview.findViewById(R.id.but_testFu4);

        final DatabaseAccess databaseAccess = DatabaseAccess.getInstance(getActivity());
        databaseAccess.open();
        scoreLt = databaseAccess.getScoreUnlockTest8();
        scoreLt2 = databaseAccess.getScoreUnlockTest9();
        scoreLt3 = databaseAccess.getScoreUnlockTest10();
        scoreLt4 = databaseAccess.getScoreUnlockTest11();
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
            case R.id.but_testFu1:
                setTestFutureSim();
                break;
            case R.id.but_testFu2:
                setTestFutureCon();
                break;
            case R.id.but_testFu3:
                setTestFuturePer();
                break;
            case R.id.but_testFu4:
                setTestFuturePerCon();
                break;
        }
    }

    private void setTestFutureSim() {
        if (scoreLt != null) {
            past4 = scoreLt.getScore();
            if (past4 != 0 && past4 >= 7) {
                Log.d("score", "Your score PastPerCon : " + scoreLt.getScore());
                FragmentManager fm = getFragmentManager();
                fm.beginTransaction().replace(R.id.maincontent, new Fragment3_testFuturePage1()).commit();
                Toast.makeText(getActivity(), " Unlock!! ", Toast.LENGTH_LONG).show();
            } else {
                Log.d("score", "Your score PastPerCon : " + scoreLt.getScore());
                AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity(),R.style.Base_Theme_AppCompat_Dialog_Alert);
                dialog.setTitle("Error");
                dialog.setCancelable(true);
                dialog.setMessage(" ต้องผ่านแบบทดสอบ Past Perfect Continuous tense ก่อน ");

                dialog.setNegativeButton("ตกลง", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                dialog.show();
            }
        } else {
            AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity(),R.style.Base_Theme_AppCompat_Dialog_Alert);
            dialog.setTitle("Error");
            dialog.setCancelable(true);
            dialog.setMessage(" ต้องผ่านแบบทดสอบ Present Perfect Continuous tense ก่อน ");

            dialog.setNegativeButton("ตกลง", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });

            dialog.show();
        }
    }

    private void setTestFutureCon() {
        if (scoreLt2 != null) {
            fu1 = scoreLt2.getScore();
            if (fu1 != 0 && fu1 >= 7) {
                Log.d("score", "Your score FutureSim : " + scoreLt2.getScore());
                FragmentManager fm = getFragmentManager();
                fm.beginTransaction().replace(R.id.maincontent, new Fragment3_testFuturePage2()).commit();
                Toast.makeText(getActivity(), " Unlock!! ", Toast.LENGTH_LONG).show();
            } else {
                Log.d("score", "Your score FutureSim : " + scoreLt2.getScore());
                AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity(),R.style.Base_Theme_AppCompat_Dialog_Alert);
                dialog.setTitle("Error");
                dialog.setCancelable(true);
                dialog.setMessage(" ต้องผ่านแบบทดสอบ Future Simple tense ก่อน ");

                dialog.setNegativeButton("ตกลง", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                dialog.show();
            }
        } else {
            AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity(),R.style.Base_Theme_AppCompat_Dialog_Alert);
            dialog.setTitle("Error");
            dialog.setCancelable(true);
            dialog.setMessage(" ต้องผ่านแบบทดสอบ Future Simple tense ก่อน ");

            dialog.setNegativeButton("ตกลง", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });

            dialog.show();
        }
    }

    private void setTestFuturePer() {
        if (scoreLt3 != null) {
            fu2 = scoreLt3.getScore();
            if (fu2 != 0 && fu2 >= 7) {
                Log.d("score", "Your score FutureCon : " + scoreLt3.getScore());
                FragmentManager fm = getFragmentManager();
                fm.beginTransaction().replace(R.id.maincontent, new Fragment3_testFuturePage3()).commit();
                Toast.makeText(getActivity(), " Unlock!! ", Toast.LENGTH_LONG).show();
            } else {
                Log.d("score", "Your score FutureCon : " + scoreLt3.getScore());
                AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity(),R.style.Base_Theme_AppCompat_Dialog_Alert);
                dialog.setTitle("Error");
                dialog.setCancelable(true);
                dialog.setMessage(" ต้องผ่านแบบทดสอบ Future Continuous tense ก่อน ");

                dialog.setNegativeButton("ตกลง", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                dialog.show();
            }
        } else {
            AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity(),R.style.Base_Theme_AppCompat_Dialog_Alert);
            dialog.setTitle("Error");
            dialog.setCancelable(true);
            dialog.setMessage(" ต้องผ่านแบบทดสอบ Future Continuous tense ก่อน ");

            dialog.setNegativeButton("ตกลง", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });

            dialog.show();
        }
    }

    private void setTestFuturePerCon() {
        if (scoreLt4 != null) {
            fu3 = scoreLt4.getScore();
            if (fu3 != 0 && fu3 >= 7) {
                Log.d("score", "Your score FuturePer : " + scoreLt4.getScore());
                FragmentManager fm = getFragmentManager();
                fm.beginTransaction().replace(R.id.maincontent, new Fragment3_testFuturePage4()).commit();
                Toast.makeText(getActivity(), " Unlock!! ", Toast.LENGTH_LONG).show();
            } else {
                Log.d("score", "Your score FuturePer : " + scoreLt4.getScore());
                AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity(),R.style.Base_Theme_AppCompat_Dialog_Alert);
                dialog.setTitle("Error");
                dialog.setCancelable(true);
                dialog.setMessage(" ต้องผ่านแบบทดสอบ Future Perfect tense ก่อน ");

                dialog.setNegativeButton("ตกลง", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                dialog.show();
            }
        } else {
            AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity(),R.style.Base_Theme_AppCompat_Dialog_Alert);
            dialog.setTitle("Error");
            dialog.setCancelable(true);
            dialog.setMessage(" ต้องผ่านแบบทดสอบ Future Perfect tense ก่อน ");

            dialog.setNegativeButton("ตกลง", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });

            dialog.show();
        }
    }

}
