package com.example.toshiba.appenglish;

/*
 * Created by Toshiba on 29/12/2558.
 */

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.toshiba.appenglish.DB.DatabaseAccess;
import com.example.toshiba.appenglish.DB.Score;

public class Fragment5_scroe extends Fragment {
    View rootview;

    TextView pre, post ,pre1, pre2, pre3, pre4, past1, past2, past3, past4, fu1, fu2, fu3, fu4;

    TextView test;

    Score scorePre, scorePost, scorePre1, scorePre2, scorePre3, scorePre4, scorePast1, scorePast2, scorePast3,
            scorePast4, scoreFu1, scoreFu2, scoreFu3, scoreFu4;

    Score currentS;
    int sc1;
    int date;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.layout5_scroe, container, false);

        pre = (TextView) rootview.findViewById(R.id.textView_pretest1);
        post = (TextView) rootview.findViewById(R.id.textView_posttest1);

        pre1 = (TextView) rootview.findViewById(R.id.textView_presimtest1);
        pre2 = (TextView) rootview.findViewById(R.id.textView_precontest1);
        pre3 = (TextView) rootview.findViewById(R.id.textView_prepertest1);
        pre4 = (TextView) rootview.findViewById(R.id.textView_prepercontest1);

        past1 = (TextView) rootview.findViewById(R.id.textView_pastsimtest1);
        past2 = (TextView) rootview.findViewById(R.id.textView_pastcontest1);
        past3 = (TextView) rootview.findViewById(R.id.textView_pastpertest1);
        past4 = (TextView) rootview.findViewById(R.id.textView_pastpercontest1);

        fu1 = (TextView) rootview.findViewById(R.id.textView_fusimtest1);
        fu2 = (TextView) rootview.findViewById(R.id.textView_fucontest1);
        fu3 = (TextView) rootview.findViewById(R.id.textView_fupertest1);
        fu4 = (TextView) rootview.findViewById(R.id.textView_fupercontest1);

        //test = (TextView) rootview.findViewById(R.id.textView_presimtest2);

        final DatabaseAccess databaseAccess = DatabaseAccess.getInstance(getActivity());
        databaseAccess.open();

        scorePre = databaseAccess.get_PreScore();
        scorePost = databaseAccess.get_ScoreMix();

        scorePre1 = databaseAccess.get_Score();
        scorePre2 = databaseAccess.get_ScorePre2();
        scorePre3 = databaseAccess.get_ScorePre3();
        scorePre4 = databaseAccess.get_ScorePre4();

        scorePast1 = databaseAccess.get_ScorePast1();
        scorePast2 = databaseAccess.get_ScorePast2();
        scorePast3 = databaseAccess.get_ScorePast3();
        scorePast4 = databaseAccess.get_ScorePast4();

        scoreFu1 = databaseAccess.get_ScoreFu1();
        scoreFu2 = databaseAccess.get_ScoreFu2();
        scoreFu3 = databaseAccess.get_ScoreFu3();
        scoreFu4 = databaseAccess.get_ScoreFu4();

        databaseAccess.close();

        //sc1 = scorePre1.getScore();

        //scorePre1.getScore();

        setScoreView();

        return rootview;

    }

    private void setScoreView() {
        pre.setText(" " + scorePre.getScore());
        post.setText(" " + scorePost.getScore());

        pre1.setText(" " + scorePre1.getScore());
        pre2.setText(" " + scorePre2.getScore());
        pre3.setText(" " + scorePre3.getScore());
        pre4.setText(" " + scorePre4.getScore());

        past1.setText(" " + scorePast1.getScore());
        past2.setText(" " + scorePast2.getScore());
        past3.setText(" " + scorePast3.getScore());
        past4.setText(" " + scorePast4.getScore());

        fu1.setText(" " + scoreFu1.getScore());
        fu2.setText(" " + scoreFu2.getScore());
        fu3.setText(" " + scoreFu3.getScore());
        fu4.setText(" " + scoreFu4.getScore());
    }

}
