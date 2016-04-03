package com.example.toshiba.appenglish;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;

/*
 * Created by Toshiba on 11/2/2559.
 */
public class Fragment6_credit extends Fragment {

    Button butback;
    WebView webView;
    View rootview;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        rootview = inflater.inflate(R.layout.layout0_credit,container,false);

        webView = (WebView) rootview.findViewById(R.id.webview);
        webView.loadUrl("file:///android_asset/Credit.html");

        return rootview;
    }

    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout0_credit);

        webView = (WebView) findViewById(R.id.webview);
        webView.loadUrl("file:///android_asset/Credit.html");

        butback = (Button) findViewById(R.id.button_back);
        butback.setOnClickListener(this);

    }*/

    /*@Override
    public void onClick(View v) {
        finish();
    }*/
}
