package com.example.toshiba.appenglish.lessPre;

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
import com.example.toshiba.appenglish.Fragment2_lesson;
import com.example.toshiba.appenglish.R;

/*
 * Created by Toshiba on 5/1/2559.
 */
public class Fragment2_lessPre extends Fragment implements View.OnClickListener {
    View rootview;
    Button butback, butSim, butCon, butPer, butPerCon;
    Score scoreLt, scoreLt2, scoreLt3;
    int pre1, pre2, pre3;
    int date;


    @Nullable
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.layout2_lesson_present, container, false);

        butback = (Button) rootview.findViewById(R.id.button_back);
        butSim = (Button) rootview.findViewById(R.id.but_lessPre1);
        butCon = (Button) rootview.findViewById(R.id.but_lessPre2);
        butPer = (Button) rootview.findViewById(R.id.but_lessPre3);
        butPerCon = (Button) rootview.findViewById(R.id.but_lessPre4);

        final DatabaseAccess databaseAccess = DatabaseAccess.getInstance(getActivity());
        databaseAccess.open();
        scoreLt = databaseAccess.get_Score();
        scoreLt2 = databaseAccess.get_ScorePre2();
        scoreLt3 = databaseAccess.get_ScorePre3();
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
                fm.beginTransaction().replace(R.id.maincontent, new Fragment2_lesson()).commit();
                break;
            case R.id.but_lessPre1:
                FragmentManager fm2 = getFragmentManager();
                fm2.beginTransaction().replace(R.id.maincontent, new Fragment2_lessonPre_page1()).commit();
                break;
            case R.id.but_lessPre2:
                setTestPreCon();
                break;
            case R.id.but_lessPre3:
                setTestPrePer();
                break;
            case R.id.but_lessPre4:
                setTestPrePerCon();
                break;
        }
    }

    private void setTestPreCon() {
        if (scoreLt != null) {
            pre1 = scoreLt.getScore();
            date = scoreLt.getDate();
            if (pre1 != 0 && pre1 >= 7) {
                Log.d("score", "Your score PreSim : " + scoreLt.getScore());
                FragmentManager fm = getFragmentManager();
                fm.beginTransaction().replace(R.id.maincontent, new Fragment2_lessonPre_page2()).commit();
                Toast.makeText(getActivity(), " Unlock!! ", Toast.LENGTH_LONG).show();
            } else {
                Log.d("score", "Your score PreSim : " + scoreLt.getScore());
                AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity(),R.style.Base_Theme_AppCompat_Dialog_Alert);
                dialog.setTitle("Error");
                dialog.setCancelable(true);
                dialog.setMessage(" ต้องผ่านแบบทดสอบ Present Simple tense ก่อน ");

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
            dialog.setMessage(" ต้องผ่านแบบทดสอบ Present Simple tense ก่อน ");

            dialog.setNegativeButton("ตกลง", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            dialog.show();
        }
    }

    private void setTestPrePer() {
        if (scoreLt2 != null) {
            pre2 = scoreLt2.getScore();
            date = scoreLt2.getDate();
            if (pre2 != 0 && pre2 >= 7) {
                Log.d("score", "Your score PreCon : " + scoreLt2.getScore());
                FragmentManager fm = getFragmentManager();
                fm.beginTransaction().replace(R.id.maincontent, new Fragment2_lessonPre_page3()).commit();
                Toast.makeText(getActivity(), " Unlock!! ", Toast.LENGTH_LONG).show();
            } else {
                Log.d("score", "Your score PreCon : " + scoreLt2.getScore());
                AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity(),R.style.Base_Theme_AppCompat_Dialog_Alert);
                dialog.setTitle("Error");
                dialog.setCancelable(true);
                dialog.setMessage(" ต้องผ่านแบบทดสอบ Present Continuous tense ก่อน ");

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
            dialog.setMessage(" ต้องผ่านแบบทดสอบ Present Continuous tense ก่อน ");

            dialog.setNegativeButton("ตกลง", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });

            dialog.show();
        }
    }

    private void setTestPrePerCon() {
        if (scoreLt3 != null) {
            pre3 = scoreLt3.getScore();
            date = scoreLt3.getDate();
            if (pre3 != 0 && pre3 >= 7) {
                Log.d("score", "Your score PrePer : " + scoreLt3.getScore());
                FragmentManager fm = getFragmentManager();
                fm.beginTransaction().replace(R.id.maincontent, new Fragment2_lessonPre_page4()).commit();
                Toast.makeText(getActivity(), " Unlock!! ", Toast.LENGTH_LONG).show();
            } else {
                Log.d("score", "Your score PrePer : " + scoreLt3.getScore());
                AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity(),R.style.Base_Theme_AppCompat_Dialog_Alert);
                dialog.setTitle("Error");
                dialog.setCancelable(true);
                dialog.setMessage(" ต้องผ่านแบบทดสอบ Present Perfect tense ก่อน ");

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
            dialog.setMessage(" ต้องผ่านแบบทดสอบ Present Perfect tense ก่อน ");

            dialog.setNegativeButton("ตกลง", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            dialog.show();
        }
    }
}

