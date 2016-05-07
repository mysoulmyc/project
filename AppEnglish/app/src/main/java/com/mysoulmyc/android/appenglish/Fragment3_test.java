package com.mysoulmyc.android.appenglish;

/*
 * Created by Toshiba on 29/12/2558.
 */

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.mysoulmyc.android.appenglish.testFuture.Fragment3_testFuture;
import com.mysoulmyc.android.appenglish.testPast.Fragment3_testPast;
import com.mysoulmyc.android.appenglish.testPre.Fragment3_testPre;

public class Fragment3_test extends Fragment implements View.OnClickListener {
    View rootview;
    Button butTPre,butTPast,butTFuture;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.layout3_test,container,false);

        butTPre = (Button) rootview.findViewById(R.id.but_testPre);
        butTPast = (Button)rootview.findViewById(R.id.but_testPast);
        butTFuture = (Button)rootview.findViewById(R.id.but_testFuture);
        butTPre.setOnClickListener(this);
        butTPast.setOnClickListener(this);
        butTFuture.setOnClickListener(this);

        return rootview;
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.but_testPre){
            FragmentManager fm = getFragmentManager();
            fm.beginTransaction().replace(R.id.maincontent, new Fragment3_testPre()).commit();
            Toast.makeText(getActivity(), " Test Present Tense was selected. ", Toast.LENGTH_LONG).show();
        }
        else if(v.getId()==R.id.but_testPast) {
            FragmentManager fm = getFragmentManager();
            fm.beginTransaction().replace(R.id.maincontent, new Fragment3_testPast()).commit();
            Toast.makeText(getActivity(), " Test Past Tense was selected. ", Toast.LENGTH_LONG).show();
        }
        else if(v.getId()==R.id.but_testFuture){
            FragmentManager fm = getFragmentManager();
            fm.beginTransaction().replace(R.id.maincontent, new Fragment3_testFuture()).commit();
            Toast.makeText(getActivity(), " Test Future Tense was selected. ", Toast.LENGTH_LONG).show();
        }
    }
}
