package com.example.toshiba.appenglish.testPre;

//import android.app.AlertDialog;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.toshiba.appenglish.DB.DatabaseAccess;
import com.example.toshiba.appenglish.DB.DbHelper;
import com.example.toshiba.appenglish.DB.Score;
import com.example.toshiba.appenglish.Fragment3_test;
import com.example.toshiba.appenglish.R;

import java.util.List;

/*
 * Created by Toshiba on 5/1/2559.
 */
public class Fragment3_testPre extends Fragment implements View.OnClickListener {
    View rootview;
    Button butback, butSim, butCon, butPer, butPerCon;
    int score = 0;
    int num = 0;
    int pre1, pre2, pre3;
    int date;

    Boolean a, b, c, d;

    Score scoreLt, scoreLt2, scoreLt3;
    //Score addScore;

    List<Score> scoreList;
    Score currentS;
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase database;

    private DbHelper mHelper;
    private SQLiteDatabase mDb;
    Cursor mCursor;

    private RelativeLayout myLayout;

    @Nullable
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.layout3_test_present, container, false);

        /*myLayout = (RelativeLayout) rootview.findViewById(R.id.testpre_layout);
        myLayout.requestFocus();*/

        butback = (Button) rootview.findViewById(R.id.button_back);
        butSim = (Button) rootview.findViewById(R.id.but_testPre1);
        butCon = (Button) rootview.findViewById(R.id.but_testPre2);
        butPer = (Button) rootview.findViewById(R.id.but_testPre3);
        butPerCon = (Button) rootview.findViewById(R.id.but_testPre4);

        /*mHelper = new DbHelper(getActivity());
        mDb = mHelper.getReadableDatabase();
        scoreList = getScoreTest();
        mDb.close();*/

        final DatabaseAccess databaseAccess = DatabaseAccess.getInstance(getActivity());
        databaseAccess.open();
        //scoreList = databaseAccess.getScoreTest();
        scoreLt = databaseAccess.get_Score();
        scoreLt2 = databaseAccess.get_ScorePre2();
        scoreLt3 = databaseAccess.get_ScorePre3();
        //a = scoreLt.getScore();
        databaseAccess.close();


        /*if (scoreLt != null) {
            pre1 = scoreLt.getScore();
            date = scoreLt.getDate();
        } else if (scoreLt2 != null) {
            pre2 = scoreLt2.getScore();
            date = scoreLt2.getDate();
        } else if (scoreLt3 != null) {
            pre3 = scoreLt3.getScore();
            date = scoreLt3.getDate();
        } else {
            return null;
        }*/

        //Log.d("Score", "score : " + scoreLt.getScore() );

        //currentS = scoreList.get(a);
        //currentS = scoreLt.setScore(a);
        //setSC();
        //Log.d("score", "score : " + currentS.getScore());

        //setSC();

        /*mCursor = mDb.rawQuery("SELECT * FROM Point " + num, null);
        ArrayList<String> arr_list = new ArrayList<String>();
        mCursor.moveToFirst();
        while (!mCursor.isAfterLast()) {
            arr_list.add(
                    mCursor.getString(mCursor.getColumnIndex("point"))
                    + mCursor.getString(mCursor.getColumnIndex("id_tense"))
            );
            mCursor.moveToNext();
        }*/


        /*mHelper = new DbHelper(getActivity());
        mDb = mHelper.getReadableDatabase();

        //database = openHelper.getReadableDatabase();
        scoreList = getScoreTest();
        mDb.close();

        currentS.getScore();*/

        /*a = butCon.isFocused();
        b = butPer.isFocused();
        c = butPerCon.isFocused();
*/

        butback.setOnClickListener(this);
        butSim.setOnClickListener(this);
        butCon.setOnClickListener(this);
        butPer.setOnClickListener(this);
        butPerCon.setOnClickListener(this);


/*        getActivity().getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);*/


        return rootview;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.button_back:
                FragmentManager fm = getFragmentManager();
                fm.beginTransaction().replace(R.id.maincontent, new Fragment3_test()).commit();
                //setTestpage(butback);
                break;
            case R.id.but_testPre1:
                //butSim.requestFocus();
                FragmentManager fm1 = getFragmentManager();
                fm1.beginTransaction().replace(R.id.maincontent, new Fragment3_testPrePage1()).commit();
                //butSim.clearFocus();
                //setTestpage(butSim);
                break;
            case R.id.but_testPre2:
                //butCon.requestFocus();
                setTestPreCon();
                //butCon.clearFocus();
                //setTestpage(butCon);
                break;
            case R.id.but_testPre3:
                //butPer.isFocused();
                //butPer.requestFocus();
                setTestPrePer();
                //butPer.clearFocus();
                //setTestpage(butPer);
                break;
            case R.id.but_testPre4:
                //butPerCon.requestFocus();
                setTestPrePerCon();
                //butPerCon.clearFocus();
                //setTestpage(butPerCon);
                break;
        }

    }

    /*@Override
    public void onClick(View v) {
        while (true){
            if (v.getId() == R.id.button_back) {
                FragmentManager fm = getFragmentManager();
                fm.beginTransaction().replace(R.id.maincontent, new Fragment3_test()).commit();
                break;
            }

            if (v.getId() == R.id.but_testPre1) {
                FragmentManager fm = getFragmentManager();
                fm.beginTransaction().replace(R.id.maincontent, new Fragment3_testPrePage1()).commit();
                //getActivity().finish();
                break;
            }

            if (v.getId() == R.id.but_testPre2) {
                //FragmentManager fm = getFragmentManager();
                //fm.beginTransaction().replace(R.id.maincontent, new Fragment3_testPrePage2()).commit();

                //currentS.setScore(a);
                //setSC();
                //num=2;
                if (scoreLt != null) {
                    if (pre1 != 0 && pre1 > 2) {
                        Log.d("score", "Your score PreSim : " + scoreLt.getScore());
                        FragmentManager fm = getFragmentManager();
                        fm.beginTransaction().replace(R.id.maincontent, new Fragment3_testPrePage2()).commit();
                        Toast.makeText(getActivity(), " Unlock!! ", Toast.LENGTH_LONG).show();
                        //getActivity().finish();
                        break;
                    } else if (pre1 == 0 || pre1 < 2) {
                        Log.d("score", "Your score" + scoreLt.getScore());
                        butCon.setClickable(false);
                        //Toast.makeText(getActivity(), " ต้องผ่านแบบทดสอบ Present Simple tense ก่อน ", Toast.LENGTH_LONG).show();
                        AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
                        dialog.setTitle("Error");
                        dialog.setCancelable(true);
                        dialog.setMessage(" ต้องผ่านแบบทดสอบ Present Simple tense ก่อน ");

                        dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });

                        dialog.show();
                        break;
                    }
                } else {
                    butCon.setClickable(false);
                    AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
                    dialog.setTitle("Error");
                    dialog.setCancelable(true);
                    dialog.setMessage(" ต้องผ่านแบบทดสอบ Present Simple tense ก่อน ");

                    dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });

                    dialog.show();
                    break;
                }
            }

            if (v.getId() == R.id.but_testPre3) {
                if (scoreLt2 != null) {
                    if (pre2 != 0 && pre2 > 2) {
                        Log.d("score", "Your score PreCon : " + scoreLt3.getScore());
                        FragmentManager fm = getFragmentManager();
                        fm.beginTransaction().replace(R.id.maincontent, new Fragment3_testPrePage3()).commit();
                        Toast.makeText(getActivity(), " Unlock!! ", Toast.LENGTH_LONG).show();
                        //getActivity().finish();
                        break;
                    } else if (pre2 == 0 || pre2 < 2) {
                        Log.d("score", "Your score PreCon : " + scoreLt2.getScore());
                        butCon.setClickable(false);
                        AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
                        dialog.setTitle("Error");
                        dialog.setCancelable(true);
                        dialog.setMessage(" ต้องผ่านแบบทดสอบ Present Continuous tense ก่อน ");

                        dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });

                        dialog.show();
                        break;
                    }
                } else {
                    butCon.setClickable(false);
                    AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
                    dialog.setTitle("Error");
                    dialog.setCancelable(true);
                    dialog.setMessage(" ต้องผ่านแบบทดสอบ Present Continuous tense ก่อน ");

                    dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });

                    dialog.show();
                    break;
                }
            }

            if (v.getId() == R.id.but_testPre4) {
                if (scoreLt3 != null) {
                    if (pre3 != 0 && pre3 > 2) {
                        Log.d("score", "Your score PrePer : " + scoreLt3.getScore());
                        FragmentManager fm = getFragmentManager();
                        fm.beginTransaction().replace(R.id.maincontent, new Fragment3_testPrePage4()).commit();
                        Toast.makeText(getActivity(), " Unlock!! ", Toast.LENGTH_LONG).show();
                        //getActivity().finish();
                        break;
                    } else if (pre3 == 0 || pre3 < 2) {
                        Log.d("score", "Your score PrePer : " + scoreLt3.getScore());
                        butCon.setClickable(false);
                        AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
                        dialog.setTitle("Error");
                        dialog.setCancelable(true);
                        dialog.setMessage(" ต้องผ่านแบบทดสอบ Present Perfect tense ก่อน ");

                        dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });

                        dialog.show();
                        break;
                    }
                } else {
                    butCon.setClickable(false);
                    AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
                    dialog.setTitle("Error");
                    dialog.setCancelable(true);
                    dialog.setMessage(" ต้องผ่านแบบทดสอบ Present Perfect tense ก่อน ");

                    dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });

                    dialog.show();
                    break;
                }

            }
        }

    }*/


    /*private void setSC() {
        currentS.getScore();
    }*/

    private void setTestPreCon() {
        if (scoreLt != null) {
            //butCon.isFocused();
            pre1 = scoreLt.getScore();
            date = scoreLt.getDate();
            //a = true;
            if (pre1 != 0 && pre1 >= 2) {
                Log.d("score", "Your score PreSim : " + scoreLt.getScore());
                FragmentManager fm = getFragmentManager();
                fm.beginTransaction().replace(R.id.maincontent, new Fragment3_testPrePage2()).commit();
                Toast.makeText(getActivity(), " Unlock!! ", Toast.LENGTH_LONG).show();
                //butCon.clearFocus();
                //getActivity().finish();
            } else {
                //if (pre1 == 0 || pre1 < 2)
                Log.d("score", "Your score PreSim : " + scoreLt.getScore());
                //butCon.setClickable(false);
                //Toast.makeText(getActivity(), " ต้องผ่านแบบทดสอบ Present Simple tense ก่อน ", Toast.LENGTH_LONG).show();
                AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
                dialog.setTitle("Error");
                dialog.setCancelable(true);
                dialog.setMessage(" ต้องผ่านแบบทดสอบ Present Simple tense ก่อน ");

                dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                /*dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialog) {
                        dialog.dismiss();
                    }
                });*/

                dialog.show();
                //butCon.clearFocus();
            }
        } else {
            //a = false;
            //butCon.setClickable(false);
            AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
            dialog.setTitle("Error");
            dialog.setCancelable(true);
            dialog.setMessage(" ต้องผ่านแบบทดสอบ Present Simple tense ก่อน ");

            dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });

            dialog.show();
            //butCon.clearFocus();
        }
    }

    private void setTestPrePer() {
        if (scoreLt2 != null) {
            //butPer.isFocused();
            pre2 = scoreLt2.getScore();
            date = scoreLt2.getDate();
            //b = true;
            if (pre2 != 0 && pre2 >= 2) {
                Log.d("score", "Your score PreCon : " + scoreLt2.getScore());
                FragmentManager fm = getFragmentManager();
                fm.beginTransaction().replace(R.id.maincontent, new Fragment3_testPrePage3()).commit();
                Toast.makeText(getActivity(), " Unlock!! ", Toast.LENGTH_LONG).show();
                //butPer.clearFocus();
            } else {
                //if (pre2 == 0 || pre2 < 2)
                Log.d("score", "Your score PreCon : " + scoreLt2.getScore());
                //butPer.setClickable(false);
                AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
                dialog.setTitle("Error");
                dialog.setCancelable(true);
                dialog.setMessage(" ต้องผ่านแบบทดสอบ Present Continuous tense ก่อน ");

                dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                dialog.show();
                //butPer.clearFocus();
            }
        } else {
            //b = false;
            //butPer.setClickable(false);
            AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
            dialog.setTitle("Error");
            dialog.setCancelable(true);
            dialog.setMessage(" ต้องผ่านแบบทดสอบ Present Continuous tense ก่อน ");

            dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });

            dialog.show();
            //butPer.clearFocus();
        }
    }

    private void setTestPrePerCon() {
        if (scoreLt3 != null) {
            pre3 = scoreLt3.getScore();
            date = scoreLt3.getDate();
            if (pre3 != 0 && pre3 >= 2) {
                Log.d("score", "Your score PrePer : " + scoreLt3.getScore());
                FragmentManager fm = getFragmentManager();
                fm.beginTransaction().replace(R.id.maincontent, new Fragment3_testPrePage4()).commit();
                Toast.makeText(getActivity(), " Unlock!! ", Toast.LENGTH_LONG).show();
                //butPerCon.clearFocus();
            } else {
                //if (pre3 == 0 || pre3 < 2)
                Log.d("score", "Your score PrePer : " + scoreLt3.getScore());
                //butPerCon.setClickable(false);
                AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
                dialog.setTitle("Error");
                dialog.setCancelable(true);
                dialog.setMessage(" ต้องผ่านแบบทดสอบ Present Perfect tense ก่อน ");

                dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                dialog.show();
                //butPerCon.clearFocus();
            }
        } else {
            //butPerCon.setClickable(false);
            AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
            dialog.setTitle("Error");
            dialog.setCancelable(true);
            dialog.setMessage(" ต้องผ่านแบบทดสอบ Present Perfect tense ก่อน ");

            dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });

            dialog.show();
            //butPerCon.clearFocus();
        }
    }

}
