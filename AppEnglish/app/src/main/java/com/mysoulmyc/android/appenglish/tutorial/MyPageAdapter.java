package com.mysoulmyc.android.appenglish.tutorial;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Toshiba on 5/5/2559.
 */
public class MyPageAdapter extends FragmentPagerAdapter  {
    private final int NUM_ITEMS = 4;

    public MyPageAdapter(FragmentManager fm) {
        super(fm);
    }

    public int getCount() {
        return NUM_ITEMS;
    }

    public Fragment getItem(int position) {
        if(position == 0)
            return Fragment7_tutorial_page1.newInstance();
        else if(position == 1)
            return Fragment7_tutorial_page2.newInstance();
        else if(position == 2)
            return Fragment7_tutorial_page3.newInstance();
        else if(position == 3)
            return Fragment7_tutorial_page4.newInstance();
        return null;
    }
}
