package com.example.toshiba.appenglish.lessFuture;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.toshiba.appenglish.Fragment2_lesson;
import com.example.toshiba.appenglish.R;
import com.example.toshiba.appenglish.lessFuture.Fragment2_lessonFu_page1;

/**
 * Created by Toshiba on 5/1/2559.
 */
public class Fragment2_lessFuture extends Fragment implements View.OnClickListener {

    View rootview;
    Button butback,butSim,butCon,butPer,butPerCon;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.layout2_lesson_future,container,false);

        butback = (Button) rootview.findViewById(R.id.button_back);
        butSim = (Button) rootview.findViewById(R.id.but_lessFu1);
        butCon = (Button) rootview.findViewById(R.id.but_lessFu2);
        butPer = (Button) rootview.findViewById(R.id.but_lessFu3);
        butPerCon = (Button) rootview.findViewById(R.id.but_lessFu4);

        butback.setOnClickListener(this);
        butSim.setOnClickListener(this);
        butCon.setOnClickListener(this);
        butPer.setOnClickListener(this);
        butPerCon.setOnClickListener(this);

        return rootview;
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.button_back){
            FragmentManager fm = getFragmentManager();
            fm.beginTransaction().replace(R.id.maincontent, new Fragment2_lesson()).commit();
        }
        else if (v.getId()==R.id.but_lessFu1){
            FragmentManager fm = getFragmentManager();
            fm.beginTransaction().replace(R.id.maincontent, new Fragment2_lessonFu_page1()).commit();
            Toast.makeText(getActivity(), " Lesson Future Simple Tense was selected. ", Toast.LENGTH_LONG).show();
        }
        else if (v.getId()==R.id.but_lessFu2){
            FragmentManager fm = getFragmentManager();
            fm.beginTransaction().replace(R.id.maincontent, new Fragment2_lessonFu_page2()).commit();
            Toast.makeText(getActivity(), " Lesson Future Continuous Tense was selected. ", Toast.LENGTH_LONG).show();
        }
        else if (v.getId()==R.id.but_lessFu3){
            FragmentManager fm = getFragmentManager();
            fm.beginTransaction().replace(R.id.maincontent, new Fragment2_lessonFu_page3()).commit();
            Toast.makeText(getActivity(), " Lesson Future Perfect Tense was selected. ", Toast.LENGTH_LONG).show();
        }
        else if (v.getId()==R.id.but_lessFu4){
            FragmentManager fm = getFragmentManager();
            fm.beginTransaction().replace(R.id.maincontent, new Fragment2_lessonFu_page4()).commit();
            Toast.makeText(getActivity(), " Lesson Future Perfect Continuous Tense was selected. ", Toast.LENGTH_LONG).show();
        }
    }

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.layout2_lesson_future);
//
//    }

//    public void replaceFragment() {
//        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//        transaction.replace(R.id.maincontent, objFragment);
//        transaction.commit();
//    }
}
