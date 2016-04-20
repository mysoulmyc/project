package com.example.toshiba.appenglish;

/*
 * Created by Toshiba on 29/12/2558.
 */

import android.app.Fragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.toshiba.appenglish.DB.CharacterInfo;
import com.example.toshiba.appenglish.DB.DatabaseAccess;
import com.example.toshiba.appenglish.DB.Score;


public class Fragment1_main extends Fragment {
    View rootview;

    TextView name, level;
    CharacterInfo character;
    Score scorePre4, scorePast4;
    int pre, past;
    int lv;

/*    ImageView imageView;
    WebView webView;*/

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.layout1_main, container, false);

        name = (TextView) rootview.findViewById(R.id.textView_namechar);
        level = (TextView) rootview.findViewById(R.id.textView_level);

        final DatabaseAccess databaseAccess = DatabaseAccess.getInstance(getActivity());
        databaseAccess.open();
        character = databaseAccess.getCharacter();
        scorePre4 = databaseAccess.getLv2();
        scorePast4 = databaseAccess.getLv3();
        databaseAccess.close();

        name.setText(character.getName());
        level.setText("" + character.getLEVEL());

        //lv = character.getLEVEL();

        GifMovieView gmv = (GifMovieView) rootview.findViewById(R.id.gifMovieView);
        /*imageView = (ImageView) rootview.findViewById(R.id.imageView);
        imageView.setImageResource(R.drawable.gif1);*/
/*        webView = (WebView) rootview.findViewById(R.id.webview);
        webView.loadUrl("file:///android_asset/Credit.html");*/

        if (character.getLEVEL() == 1) {
            if (scorePre4 != null) {
                pre = scorePre4.getScore();
                if (pre >= 2) {
                    lv = 2;
                    updateLevelChar();
                    gmv.setMovieResource(R.drawable.fmlv2);
                    AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
                    dialog.setTitle("ยินดีด้วย!");
                    dialog.setCancelable(true);
                    dialog.setMessage(" คุณผ่านแบบทดสอบ Present Tense ทั้งหมดแล้ว " + character.getName() + " ของคุณได้พัฒนาเป็นเลเวล 2 แล้ว! ^ ^ ");

                    dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
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
                if (past >= 2) {
                    lv = 3;
                    updateLevelChar();
                    gmv.setMovieResource(R.drawable.fmlv3);
                    AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
                    dialog.setTitle("ยินดีด้วย!");
                    dialog.setCancelable(true);
                    dialog.setMessage(" คุณผ่านแบบทดสอบ Past Tense ทั้งหมดแล้ว " + character.getName() + " ของคุณได้พัฒนาเป็นเลเวล 3 แล้ว! ^ ^ ");

                    dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
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

        return rootview;


//        return super.onCreateView(inflater, container, savedInstanceState);
    }

    private void updateLevelChar() {
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(getActivity());
        databaseAccess.open();
        databaseAccess.updateLevel(character, lv);
        Toast.makeText(getActivity(), "Update level!", Toast.LENGTH_LONG).show();
        databaseAccess.close();
    }


/*    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    public void onDestroyView() {
        super.onDestroyView();
    }*/
}
