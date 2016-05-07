package com.mysoulmyc.android.appenglish.tutorial;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mysoulmyc.android.appenglish.R;

/**
 * Created by Toshiba on 5/5/2559.
 */
public class Fragment7_tutorial_page3 extends Fragment {

    public static Fragment7_tutorial_page3 newInstance() {
        Fragment7_tutorial_page3 fragment = new Fragment7_tutorial_page3();
        return fragment;
    }

    public Fragment7_tutorial_page3() { }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.turtorial_layout_page3, container, false);

        return rootView;
    }
}
