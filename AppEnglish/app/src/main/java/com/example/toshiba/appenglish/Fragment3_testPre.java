package com.example.toshiba.appenglish;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/*
 * Created by Toshiba on 5/1/2559.
 */
public class Fragment3_testPre extends Fragment implements View.OnClickListener {
    View rootview;
    Button butback,butSim,butCon,butPer,butPerCon;

    @Nullable
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.layout3_test_present,container,false);

        butback = (Button) rootview.findViewById(R.id.button_back);
        butSim = (Button) rootview.findViewById(R.id.but_testPre1);
        butCon = (Button) rootview.findViewById(R.id.but_testPre2);
        butPer = (Button) rootview.findViewById(R.id.but_testPre3);
        butPerCon = (Button) rootview.findViewById(R.id.but_testPre4);

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
            fm.beginTransaction().replace(R.id.maincontent, new Fragment3_test()).commit();
        }
        if (v.getId()==R.id.but_testPre1){
            FragmentManager fm = getFragmentManager();
            fm.beginTransaction().replace(R.id.maincontent, new Fragment3_testPage()).commit();
        }

    }

}
