package com.example.toshiba.appenglish.lessPast;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.toshiba.appenglish.DB.DatabaseAccess;
import com.example.toshiba.appenglish.DB.Score;
import com.example.toshiba.appenglish.Fragment2_lesson;
import com.example.toshiba.appenglish.R;

/**
 * Created by Toshiba on 5/1/2559.
 */
public class Fragment2_lessPast extends Fragment implements OnClickListener {

    View rootview;
    Button butback, butSim, butCon, butPer, butPerCon;

    Score scoreLt, scoreLt2, scoreLt3, scoreLt4;
    int pre4, past1, past2, past3;
    int date;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.layout2_lesson_past, container, false);

        butback = (Button) rootview.findViewById(R.id.button_back);
        butSim = (Button) rootview.findViewById(R.id.but_lessPast1);
        butCon = (Button) rootview.findViewById(R.id.but_lessPast2);
        butPer = (Button) rootview.findViewById(R.id.but_lessPast3);
        butPerCon = (Button) rootview.findViewById(R.id.but_lessPast4);

        final DatabaseAccess databaseAccess = DatabaseAccess.getInstance(getActivity());
        databaseAccess.open();
        scoreLt = databaseAccess.get_ScorePre4();
        scoreLt2 = databaseAccess.get_ScorePast1();
        scoreLt3 = databaseAccess.get_ScorePast2();
        scoreLt4 = databaseAccess.get_ScorePast3();
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
            case R.id.but_lessPast1:
                setTestPastSim();
                break;
            case R.id.but_lessPast2:
                setTestPastCon();
                break;
            case R.id.but_lessPast3:
                setTestPastPer();
                break;
            case R.id.but_lessPast4:
                setTestPastPerCon();
                break;
        }

    }

    private void setTestPastSim() {
        if (scoreLt != null) {
            pre4 = scoreLt.getScore();
            date = scoreLt.getDate();
            if (pre4 != 0 && pre4 >= 7) {
                Log.d("score", "Your score PrePerCon : " + scoreLt.getScore());
                FragmentManager fm = getFragmentManager();
                fm.beginTransaction().replace(R.id.maincontent, new Fragment2_lessonPast_page1()).commit();
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
            date = scoreLt2.getDate();
            if (past1 != 0 && past1 >= 7) {
                Log.d("score", "Your score PastSim : " + scoreLt2.getScore());
                FragmentManager fm = getFragmentManager();
                fm.beginTransaction().replace(R.id.maincontent, new Fragment2_lessonPast_page2()).commit();
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
            date = scoreLt3.getDate();
            if (past2 != 0 && past2 >= 7) {
                Log.d("score", "Your score PastCon : " + scoreLt3.getScore());
                FragmentManager fm = getFragmentManager();
                fm.beginTransaction().replace(R.id.maincontent, new Fragment2_lessonPast_page3()).commit();
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
            date = scoreLt4.getDate();
            if (past3 != 0 && past3 >= 7) {
                Log.d("score", "Your score PastPer : " + scoreLt4.getScore());
                FragmentManager fm = getFragmentManager();
                fm.beginTransaction().replace(R.id.maincontent, new Fragment2_lessonPast_page4()).commit();
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

    /////////////////////////////////
    /*if (v.getId() == R.id.button_back) {
            FragmentManager fm = getFragmentManager();
            fm.beginTransaction().replace(R.id.maincontent, new Fragment2_lesson()).commit();
        } else if (v.getId() == R.id.but_lessPast1) {
            if (a == 1) {
                FragmentManager fm = getFragmentManager();
                fm.beginTransaction().replace(R.id.maincontent, new Fragment2_lessonPast_page1()).commit();
                Toast.makeText(getActivity(), " Lesson Past Simple Tense was selected. ", Toast.LENGTH_LONG).show();
            } else {
                butSim.setClickable(false);
                Toast.makeText(getActivity(), " ต้องผ่านแบบทดสอบ Present Perfect Continuous tense ก่อน ", Toast.LENGTH_LONG).show();
            }
        } else if (v.getId() == R.id.but_lessPast2) {
            if (a == 2) {
                FragmentManager fm = getFragmentManager();
                fm.beginTransaction().replace(R.id.maincontent, new Fragment2_lessonPast_page2()).commit();
                Toast.makeText(getActivity(), " Lesson Past Continuous Tense was selected. ", Toast.LENGTH_LONG).show();
            } else {
                butCon.setClickable(false);
                Toast.makeText(getActivity(), " ต้องผ่านแบบทดสอบ Past Simple tense ก่อน ", Toast.LENGTH_LONG).show();
            }
        } else if (v.getId() == R.id.but_lessPast3) {
            if (a == 3) {
                FragmentManager fm = getFragmentManager();
                fm.beginTransaction().replace(R.id.maincontent, new Fragment2_lessonPast_page3()).commit();
                Toast.makeText(getActivity(), " Lesson Past Perfect Tense was selected. ", Toast.LENGTH_LONG).show();
            } else {
                butPer.setClickable(false);
                Toast.makeText(getActivity(), " ต้องผ่านแบบทดสอบ Past Continuous tense ก่อน ", Toast.LENGTH_LONG).show();
            }
        } else if (v.getId() == R.id.but_lessPast4) {
            if (a == 4) {
                FragmentManager fm = getFragmentManager();
                fm.beginTransaction().replace(R.id.maincontent, new Fragment2_lessonPast_page4()).commit();
                Toast.makeText(getActivity(), " Lesson Past Perfect Continuous Tense was selected. ", Toast.LENGTH_LONG).show();
            } else {
                butPerCon.setClickable(false);
                Toast.makeText(getActivity(), " ต้องผ่านแบบทดสอบ Past Perfect tense ก่อน ", Toast.LENGTH_LONG).show();
            }
        }*/


}
