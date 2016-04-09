package com.example.toshiba.appenglish;

/*
 * Created by Toshiba on 29/12/2558.
 */

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class Fragment1_main extends Fragment {
    View rootview;
/*    ImageView imageView;
    WebView webView;*/

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.layout1_main,container,false);

        /*imageView = (ImageView) rootview.findViewById(R.id.imageView);
        imageView.setImageResource(R.drawable.gif1);*/
/*        webView = (WebView) rootview.findViewById(R.id.webview);
        webView.loadUrl("file:///android_asset/Credit.html");*/

        GifMovieView gmv = (GifMovieView) rootview.findViewById(R.id.gifMovieView);
        gmv.setMovieResource(R.drawable.woman2);


        return rootview;



//        return super.onCreateView(inflater, container, savedInstanceState);
    }


/*    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    public void onDestroyView() {
        super.onDestroyView();
    }*/
}
