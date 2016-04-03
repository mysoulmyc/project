package com.example.toshiba.appenglish.lessPast;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.toshiba.appenglish.Fragment2_lesson;
import com.example.toshiba.appenglish.R;

/**
 * Created by Toshiba on 5/1/2559.
 */
public class Fragment2_lessPast extends Fragment implements OnClickListener {

    View rootview;
    Button butback, butSim, butCon, butPer, butPerCon;
    int a = 0;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.layout2_lesson_past, container, false);

        butback = (Button) rootview.findViewById(R.id.button_back);
        butSim = (Button) rootview.findViewById(R.id.but_lessPast1);
        butCon = (Button) rootview.findViewById(R.id.but_lessPast2);
        butPer = (Button) rootview.findViewById(R.id.but_lessPast3);
        butPerCon = (Button) rootview.findViewById(R.id.but_lessPast4);

        butback.setOnClickListener(this);
        butSim.setOnClickListener(this);
        butCon.setOnClickListener(this);
        butPer.setOnClickListener(this);
        butPerCon.setOnClickListener(this);

        return rootview;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button_back) {
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
        }

    }

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.layout2_lesson_past);
//
//    }


}
