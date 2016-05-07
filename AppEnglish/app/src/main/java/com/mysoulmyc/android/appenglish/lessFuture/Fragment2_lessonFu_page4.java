
package com.mysoulmyc.android.appenglish.lessFuture;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;

import com.mysoulmyc.android.appenglish.Fragment3_test;
import com.mysoulmyc.android.appenglish.R;


/**
 * Created by Toshiba on 22/1/2559.
 */

public class Fragment2_lessonFu_page4 extends Fragment implements View.OnClickListener {
    View rootview;
    Button butback,butnext;
    WebView webView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.layout2_lesson_page1, container, false);

        webView = (WebView) rootview.findViewById(R.id.webview);
        webView.loadUrl("file:///android_asset/Future/FuturePerCon.html");

        butback = (Button) rootview.findViewById(R.id.button_back);
        butback.setOnClickListener(this);

        butnext = (Button) rootview.findViewById(R.id.button_next);
        butnext.setOnClickListener(this);

        return rootview;
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.button_back){

            FragmentManager fm = getFragmentManager();
            fm.beginTransaction().replace(R.id.maincontent, new Fragment2_lessFuture()).commit();
        }
        else if (v.getId()==R.id.button_next){
            FragmentManager fm = getFragmentManager();
            fm.beginTransaction().replace(R.id.maincontent, new Fragment3_test()).commit();
        }
    }
}
