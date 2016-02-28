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
import android.widget.Button;
import android.widget.TextView;

public class Fragment5_scroe extends Fragment {
    View rootview;
    TextView pre1,pre2,pre3,pre4;
    Button bt;

    @Nullable
    //@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.layout5_scroe,container,false);

        //pre1 = (TextView) rootview.findViewById(R.id.textView_presimtest1);

/*
        Bundle bundle = getArguments();


        if(bundle != null) {
            if (bt.getId() == R.id.but_testPre1){
                pre1.setText(String.valueOf(score));

            }


        }*/

        return rootview;
//        return super.onCreateView(inflater, container, savedInstanceState);
    }

}
