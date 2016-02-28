package com.example.toshiba.appenglish;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

/*
 * Created by Toshiba on 11/2/2559.
 */
public class Fragment6_credit extends Activity implements View.OnClickListener {

    Button butback;
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout0_credit);

        webView = (WebView) findViewById(R.id.webview);
        webView.loadUrl("file:///android_asset/Credit.html");

        butback = (Button) findViewById(R.id.button_back);
        butback.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        finish();
    }
}
