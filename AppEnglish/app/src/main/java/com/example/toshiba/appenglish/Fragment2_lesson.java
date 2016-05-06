package com.example.toshiba.appenglish;

/*
 * Created by Toshiba on 29/12/2558.
 */

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.toshiba.appenglish.lessFuture.Fragment2_lessFuture;
import com.example.toshiba.appenglish.lessPast.Fragment2_lessPast;
import com.example.toshiba.appenglish.lessPre.Fragment2_lessPre;

public class Fragment2_lesson extends Fragment implements View.OnClickListener {
    View rootview;
    Button butPre,butPast,butFuture;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        rootview = inflater.inflate(R.layout.layout2_lesson,container,false);

        butPre = (Button) rootview.findViewById(R.id.but_lessPre);
        butPast = (Button)rootview.findViewById(R.id.but_lessPast);
        butFuture = (Button)rootview.findViewById(R.id.but_lessFuture);
        butPre.setOnClickListener(this);
        butPast.setOnClickListener(this);
        butFuture.setOnClickListener(this);

        //อีกแบบ
//        butPre.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //((Fragment2_lessPre)getActivity()).replaceFragment();
//                Intent newActivityReminder=new Intent();
//                newActivityReminder.setClass(getActivity(),Fragment2_lessPre.class);
//                newActivityReminder.putExtra("index","test");//ส่งค่าตัวหลังเป็น Value
//
//                startActivity(newActivityReminder);
//            }
//        });

        return rootview;
    }

    public void onClick(View v) {

        if (v.getId()==R.id.but_lessPre){
            FragmentManager fm = getFragmentManager();
            fm.beginTransaction().replace(R.id.maincontent, new Fragment2_lessPre()).addToBackStack(null).commit();
            Toast.makeText(getActivity(), " Lesson Present Tense was selected. ", Toast.LENGTH_LONG).show();

            //อีกแบบ
//                //FragmentTransaction transaction = getFragmentManager().beginTransaction();
//                //transaction.replace(R.id.maincontent,new Fragment2_lessPre());
//                //transaction.commit();
        }
        else if(v.getId()==R.id.but_lessPast) {
            FragmentManager fm = getFragmentManager();
            fm.beginTransaction().replace(R.id.maincontent, new Fragment2_lessPast()).addToBackStack(null).commit();
            Toast.makeText(getActivity(), " Lesson Past Tense was selected. ", Toast.LENGTH_LONG).show();
        }
        else if(v.getId()==R.id.but_lessFuture){
            FragmentManager fm = getFragmentManager();
            fm.beginTransaction().replace(R.id.maincontent, new Fragment2_lessFuture()).addToBackStack(null).commit();
            Toast.makeText(getActivity(), " Lesson Future Tense was selected. ", Toast.LENGTH_LONG).show();
        }


    }

}
