package com.example.toshiba.appenglish;

/*
 * Created by Toshiba on 29/12/2558.
 */

import android.app.Fragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.toshiba.appenglish.DB.CharacterInfo;
import com.example.toshiba.appenglish.DB.DatabaseAccess;
import com.example.toshiba.appenglish.DB.Score;


public class Fragment1_main extends Fragment {
    View rootview;

    TextView name, level;
    ImageView hp;
    CharacterInfo character, timeApp;
    Score scorePre4, scorePast4, scoreMix;
    GifMovieView gmv;
    int pre, past;
    //mix
    int lv;
    int time1, time2;

/*    ImageView imageView;
    WebView webView;*/

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.layout1_main, container, false);

        name = (TextView) rootview.findViewById(R.id.textView_namechar);
        level = (TextView) rootview.findViewById(R.id.textView_level);
        hp = (ImageView) rootview.findViewById(R.id.image_hp);

        final DatabaseAccess databaseAccess = DatabaseAccess.getInstance(getActivity());
        databaseAccess.open();
        character = databaseAccess.getCharacter();
        scorePre4 = databaseAccess.getLv2();
        scorePast4 = databaseAccess.getLv3();
        timeApp = databaseAccess.dateInOut();
        scoreMix = databaseAccess.dateScoreMix();
        databaseAccess.close();

        name.setText(character.getName());
        level.setText("" + character.getLEVEL());

        gmv = (GifMovieView) rootview.findViewById(R.id.gifMovieView);
        /*imageView = (ImageView) rootview.findViewById(R.id.imageView);
        imageView.setImageResource(R.drawable.gif1);*/
/*        webView = (WebView) rootview.findViewById(R.id.webview);
        webView.loadUrl("file:///android_asset/Credit.html");*/

        //timeHP();

        if (character.getSEX() == 1) {
            maleCharacter();
            timeHP();
        } else if (character.getSEX() == 2) {
            femaleCharacter();
            timeHP();
        }

        return rootview;
    }

    public void timeHP() {

        long d1 = timeApp.getDATEOUT();
        long d2 = timeApp.getDATEUSE();
        long diff = (d2-d1);

        Log.d("Time", "time diff : " + diff);

        if (scoreMix!=null){
            long mix = scoreMix.getDateMix();
            long diff2 = (d2 - mix);
            Log.d("Score Mix ","date : " + mix);
            Log.d("Time", "time diff2 : " + diff2);

            if(diff==0){
                if (diff2 == 0){
                    hp.setImageResource(R.drawable.hp100);
                }
                else if (diff2 >= 2){
                    hp.setImageResource(R.drawable.hp70);
                }
                else if (diff2 >= 4){
                    hp.setImageResource(R.drawable.hp40);
                }
                else if (diff2 >= 6){
                    hp.setImageResource(R.drawable.hp20);
                }
            }
            if (diff >= 2){
                if (diff2 == 0){
                    hp.setImageResource(R.drawable.hp100);
                }
                else if (diff2 >= 2 || diff2 < -69){
                    hp.setImageResource(R.drawable.hp70);
                    //gmv.setMovieResource(R.drawable.gifegg);
                }
            }
            if ((diff >= 4 )) {
                if (diff2 == 0) {
                    hp.setImageResource(R.drawable.hp70);
                } else if(diff2 >= 4 || diff2 < -69) {
                    hp.setImageResource(R.drawable.hp40);
                }
            }
            if (diff >= 6){
                if (diff2 == 0) {
                    hp.setImageResource(R.drawable.hp40);
                } else if (diff >= 6 || diff2 < -69 ){
                    hp.setImageResource(R.drawable.hp20);
                }
            }

        } else {
            hp.setImageResource(R.drawable.hp100);
        }

    }

    private void updateLevelChar() {
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(getActivity());
        databaseAccess.open();
        databaseAccess.updateLevel(character, lv);
        Toast.makeText(getActivity(), "Update level!", Toast.LENGTH_LONG).show();
        databaseAccess.close();
    }

    private void maleCharacter() {
        if (character.getLEVEL() == 1) {
            if (scorePre4 != null) {
                pre = scorePre4.getScore();
                if (pre >= 7) {
                    lv = 2;
                    updateLevelChar();
                    gmv.setMovieResource(R.drawable.mlv2);
                    AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
                    dialog.setTitle("ยินดีด้วย!");
                    dialog.setCancelable(true);
                    dialog.setMessage(" คุณผ่านแบบทดสอบ Present Tense ทั้งหมดแล้ว " + character.getName() + " ของคุณได้พัฒนาเป็นเลเวล 2 แล้ว! ^ ^ ");

                    dialog.setNegativeButton("ตกลง", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
                    dialog.show();
                }
            } else {
                gmv.setMovieResource(R.drawable.gifegg);

            }
        } else if (character.getLEVEL() == 2) {
            if (scorePast4 != null) {
                past = scorePast4.getScore();
                if (past >= 7) {
                    lv = 3;
                    updateLevelChar();
                    gmv.setMovieResource(R.drawable.mlv3);
                    AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
                    dialog.setTitle("ยินดีด้วย!");
                    dialog.setCancelable(true);
                    dialog.setMessage(" คุณผ่านแบบทดสอบ Past Tense ทั้งหมดแล้ว " + character.getName() + " ของคุณได้พัฒนาเป็นเลเวล 3 แล้ว! ^ ^ ");
                    dialog.setNegativeButton("ตกลง", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
                    dialog.show();
                }
            } else {
                gmv.setMovieResource(R.drawable.mlv2);
            }
        } else if (character.getLEVEL() == 3) {
            gmv.setMovieResource(R.drawable.mlv3);
        }
    }

    private void femaleCharacter() {
        if (character.getLEVEL() == 1) {
            if (scorePre4 != null) {
                pre = scorePre4.getScore();
                if (pre >= 7) {
                    lv = 2;
                    updateLevelChar();
                    gmv.setMovieResource(R.drawable.fmlv2);
                    AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
                    dialog.setTitle("ยินดีด้วย!");
                    dialog.setCancelable(true);
                    dialog.setMessage(" คุณผ่านแบบทดสอบ Present Tense ทั้งหมดแล้ว " + character.getName() + " ของคุณได้พัฒนาเป็นเลเวล 2 แล้ว! ^ ^ ");

                    dialog.setNegativeButton("ตกลง", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
                    dialog.show();
                }
            } else {
                gmv.setMovieResource(R.drawable.gifegg);

            }
        } else if (character.getLEVEL() == 2) {
            if (scorePast4 != null) {
                past = scorePast4.getScore();
                if (past >= 7) {
                    lv = 3;
                    updateLevelChar();
                    gmv.setMovieResource(R.drawable.fmlv3);
                    AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
                    dialog.setTitle("ยินดีด้วย!");
                    dialog.setCancelable(true);
                    dialog.setMessage(" คุณผ่านแบบทดสอบ Past Tense ทั้งหมดแล้ว " + character.getName() + " ของคุณได้พัฒนาเป็นเลเวล 3 แล้ว! ^ ^ ");

                    dialog.setNegativeButton("ตกลง", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
                    dialog.show();
                }
            } else {
                gmv.setMovieResource(R.drawable.fmlv2);
            }
        } else if (character.getLEVEL() == 3) {
            gmv.setMovieResource(R.drawable.fmlv3);
        }
    }


/*    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    public void onDestroyView() {
        super.onDestroyView();
    }*/
}
