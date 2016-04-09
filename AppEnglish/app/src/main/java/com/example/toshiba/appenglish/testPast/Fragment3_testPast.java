package com.example.toshiba.appenglish.testPast;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.toshiba.appenglish.Fragment3_test;
import com.example.toshiba.appenglish.R;

/*
 * Created by Toshiba on 5/1/2559.
 */
public class Fragment3_testPast extends Fragment implements OnClickListener {

    View rootview;
    Button butback;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.layout3_test_past,container,false);

        butback = (Button) rootview.findViewById(R.id.button_back);

        butback.setOnClickListener(this);

        return rootview;
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.button_back){
            FragmentManager fm = getFragmentManager();
            fm.beginTransaction().replace(R.id.maincontent, new Fragment3_test()).commit();
        }

    }



}
