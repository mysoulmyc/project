package com.example.toshiba.appenglish.lessPre;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;

import com.example.toshiba.appenglish.Fragment3_test;
import com.example.toshiba.appenglish.R;

/*
 * Created by Toshiba on 8/1/2559.
 */
public class Fragment2_lessonPre_page1 extends Fragment implements View.OnClickListener {
    //
    View rootview;

    //ActionBar actionBar;
    Button butback, butnext;
    WebView webView;
/*    private ListView mlistView;
    private String mSelectLesson1;*/

    // LocalActivityManager mLocalActivityManager;

/*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout2_lesson_page1);

        mLocalActivityManager = new LocalActivityManager(this, false);
        mLocalActivityManager.dispatchCreate(savedInstanceState);

        TabHost tabHost = (TabHost) findViewById(R.id.tabhost);
        tabHost.setup(mLocalActivityManager);

        TabHost.TabSpec tabSpec = tabHost.newTabSpec("tab1")
                .setIndicator("Lesson")
                .setContent(new Intent(this, Tab1.class));

        TabHost.TabSpec tabSpec2 = tabHost.newTabSpec("tab2")
                .setIndicator("Test")
                .setContent(new Intent(this, Tab2.class));

        TabHost.TabSpec tabSpec3 = tabHost.newTabSpec("tab3")
                .setIndicator("MixTest")
                .setContent(new Intent(this, Tab3.class));

        TabHost.TabSpec tabSpec4 = tabHost.newTabSpec("tab4")
                .setIndicator("Score")
                .setContent(new Intent(this, Tab4.class));

        tabHost.addTab(tabSpec);
        tabHost.addTab(tabSpec2);
        tabHost.addTab(tabSpec3);
        tabHost.addTab(tabSpec4);

    }

    @Override
    protected void onPause() {
        super.onPause();
        mLocalActivityManager.dispatchPause(!isFinishing());

    }

    @Override
    protected void onResume() {
        super.onResume();
        mLocalActivityManager.dispatchResume();
    }*/

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //int resourceId = getArguments().getInt(Fragment2_lessPre.KEY_DRAWABLE_ID);
        rootview = inflater.inflate(R.layout.layout2_lesson_page1, container, false);

/*
        ImageView imageView = (ImageView) rootview.findViewById(R.id.imageLess);
        imageView.setImageResource(this);
*/
        webView = (WebView) rootview.findViewById(R.id.webview);
        //webView.setWebViewClient(new WebViewClient());
        //webView.getSettings().setJavaScriptEnabled(true);
/*        String folderPath = "file:android_assets/";
        String fileName = "testhtml.html";
        String file = folderPath + fileName;*/
        webView.loadUrl("file:///android_asset/Present/PreSim.html");

        butback = (Button) rootview.findViewById(R.id.button_back);
        butback.setOnClickListener(this);

        butnext = (Button) rootview.findViewById(R.id.button_next);
        butnext.setOnClickListener(this);


/*        actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        ActionBar.Tab tab1 = actionBar.newTab();
        tab1.setText("Tab1");
        tab1.setTabListener(this);

        ActionBar.Tab tab2 = actionBar.newTab();
        tab1.setText("Tab2");
        tab1.setTabListener(this);

        ActionBar.Tab tab3 = actionBar.newTab();
        tab1.setText("Tab3");
        tab1.setTabListener(this);

        ActionBar.Tab tab4 = actionBar.newTab();
        tab1.setText("Tab4");
        tab1.setTabListener(this);

        actionBar.addTab(tab1);
        actionBar.addTab(tab2);
        actionBar.addTab(tab3);
        actionBar.addTab(tab4);*/


        //mLocalActivityManager = new LocalActivityManager(this, false);
/*        mLocalActivityManager.dispatchCreate(savedInstanceState);

        TabHost tabHost = (TabHost) rootview.findViewById(R.id.tabhost);
        tabHost.setup(mLocalActivityManager);

        TabHost.TabSpec tabSpec = tabHost.newTabSpec("tab1")
                .setIndicator("Lesson")
                .setContent(new Intent(getActivity(), Tab1.class));

        TabHost.TabSpec tabSpec2 = tabHost.newTabSpec("tab2")
                .setIndicator("Test")
                .setContent(new Intent(getActivity(), Tab2.class));

        TabHost.TabSpec tabSpec3 = tabHost.newTabSpec("tab3")
                .setIndicator("MixTest")
                .setContent(new Intent(getActivity(), Tab3.class));

        TabHost.TabSpec tabSpec4 = tabHost.newTabSpec("tab4")
                .setIndicator("Score")
                .setContent(new Intent(getActivity(), Tab4.class));

        tabHost.addTab(tabSpec);
        tabHost.addTab(tabSpec2);
        tabHost.addTab(tabSpec3);
        tabHost.addTab(tabSpec4);*/

        return rootview;
    }


/*    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }*/

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button_back) {

            FragmentManager fm = getFragmentManager();
            fm.beginTransaction().replace(R.id.maincontent, new Fragment2_lessPre()).commit();
        } else if (v.getId() == R.id.button_next) {
            FragmentManager fm = getFragmentManager();
            fm.beginTransaction().replace(R.id.maincontent, new Fragment3_test()).commit();
        }
    }

}