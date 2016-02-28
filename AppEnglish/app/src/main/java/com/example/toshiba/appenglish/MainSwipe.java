/*


package com.example.toshiba.appenglish;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.TabHost;
import android.widget.TableLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;



*/
/**
 * Created by Toshiba on 11/1/2559.
 *//*



public class MainSwipe extends FragmentActivity implements ViewPager.OnPageChangeListener, TabHost.OnTabChangeListener {


    ViewPager viewPager;
    TabHost tabHost;
    //private FragmentPagerAdapter mPageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViewPager();

        initTabHost(savedInstanceState);

        //intialisePaging();

    }

    private void initTabHost(Bundle args) {
        tabHost = (TabHost) findViewById(R.id.tabhost);
        tabHost.setup();

        String[] tabNames = {"Tab1","Tab2","Tab3","Tab4","Tab5"};

        for (int i=0;i<tabNames.length;i++){
            TabHost.TabSpec tabSpec;
            tabSpec = tabHost.newTabSpec(tabNames[i]);
            tabSpec.setIndicator(tabNames[i]);
            tabSpec.setContent(new FakeContent(getApplicationContext()));
            tabHost.addTab(tabSpec);
        }

        tabHost.setOnTabChangedListener(this);

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int selectedItem) {
        tabHost.setCurrentTab(selectedItem);

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onTabChanged(String tabId) {
        int selectedItem = tabHost.getCurrentTab();
        viewPager.setCurrentItem(selectedItem);

        HorizontalScrollView horizontalScrollView = (HorizontalScrollView) findViewById(R.id.h_scroll_view);
        View tabView = tabHost.getCurrentTabView();
        int scrollPos = tabView.getLeft() - (horizontalScrollView.getWidth() - tabView.getWidth()) / 2;
        horizontalScrollView.smoothScrollTo(scrollPos, 0);

    }

    public class FakeContent implements TabHost.TabContentFactory{

        Context context;

        public FakeContent(Context mcontext){
            context = mcontext;
        }

        @Override
        public View createTabContent(String tag) {
            View fakeView = new View(context);
            fakeView.setMinimumHeight(0);
            fakeView.setMinimumWidth(0);
            return fakeView;
        }
    }

    private void initViewPager() {

        viewPager = (ViewPager) findViewById(R.id.pager);

        List<Fragment> listFragment = new Vector<>();
        listFragment.add(Fragment.instantiate(this,Fragment2_lessonPre_page1.class.getName()));
        listFragment.add(Fragment.instantiate(this,Fragment2_lessonPre_page2.class.getName()));
        listFragment.add(Fragment.instantiate(this,Fragment2_lessonPre_page3.class.getName()));
        listFragment.add(Fragment.instantiate(this,Fragment2_lessonPre_page4.class.getName()));

        MyFragmentPagerAdapter myFragmentPagerAdapter = new MyFragmentPagerAdapter(this.getSupportFragmentManager(), listFragment);
        viewPager.setAdapter(myFragmentPagerAdapter);
        viewPager.setOnPageChangeListener(this);


*/
/*        viewPager = (ViewPager) findViewById(R.id.pager);

        List<android.app.Fragment> listFragment = new ArrayList<android.app.Fragment>();
        listFragment.add(new Fragment2_lessonPre_page1());
        listFragment.add(new Fragment2_lessonPre_page2());
        listFragment.add(new Fragment2_lessonPre_page3());
        listFragment.add(new Fragment2_lessonPre_page4());

        MyFragmentPagerAdapter myFragmentPagerAdapter = new MyFragmentPagerAdapter(
                getSupportFragmentManager(), listFragment);
        viewPager.setAdapter(myFragmentPagerAdapter);*//*


    }


*/
/*    private void intialisePaging() {
        List<Fragment> listFragment = new Vector<Fragment>();
        listFragment.add(Fragment.instantiate(this,Fragment2_lessonPre_page1.class.getName()));
        listFragment.add(Fragment.instantiate(this,Fragment2_lessonPre_page2.class.getName()));
        listFragment.add(Fragment.instantiate(this,Fragment2_lessonPre_page3.class.getName()));
        listFragment.add(Fragment.instantiate(this,Fragment2_lessonPre_page4.class.getName()));

        mPageAdapter = new MyAdapter(this.getSupportFragmentManager(), listFragment);
        viewPager = (ViewPager) findViewById(R.id.pager);
        viewPager.setAdapter(mPageAdapter);

    }*//*


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}


*/
