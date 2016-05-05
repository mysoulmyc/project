package com.example.toshiba.appenglish.tutorial;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.toshiba.appenglish.PreTest;
import com.example.toshiba.appenglish.R;

/**
 * Created by Toshiba on 5/5/2559.
 */
public class Fragment7_tutorial_page4 extends Fragment implements View.OnClickListener {

    Button butPretest;

    public static Fragment7_tutorial_page4 newInstance() {
        Fragment7_tutorial_page4 fragment = new Fragment7_tutorial_page4();
        return fragment;
    }

    public Fragment7_tutorial_page4() { }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.turtorial_layout_page4, container, false);

        butPretest = (Button) rootView.findViewById(R.id.button_startPre);
        butPretest.setOnClickListener(this);

        return rootView;
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.button_startPre){
            Toast.makeText(getActivity(), " เริ่มทำแบบทดสอบ Pre-Test! ", Toast.LENGTH_LONG).show();
            Intent i = new Intent(getActivity(), PreTest.class);
            startActivity(i);
            finish();
        }
    }

    private void finish() {
        finish();
    }
}
