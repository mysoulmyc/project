package com.mysoulmyc.android.appenglish.testPre;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.mysoulmyc.android.appenglish.DB.DatabaseAccess;
import com.mysoulmyc.android.appenglish.DB.MixQuestAns;
import com.mysoulmyc.android.appenglish.Fragment3_Answer;
import com.mysoulmyc.android.appenglish.R;

import java.util.List;

/*
 * Created by Toshiba on 22/2/2559.
 */
public class Fragment3_testPrePage2 extends Fragment {

    View rootview;

    List<MixQuestAns> mixList;
    MixQuestAns currentMIX;

    int score = 0;
    int qid = 0;
    int ans = 0;


    TextView txtQuestion,txtScore,txtTitle;
    RadioButton rda, rdb, rdc, rdd;
    Button butNext;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.layout3_test_page, container, false);

        txtTitle = (TextView) rootview.findViewById(R.id.textView_title);
        txtQuestion = (TextView) rootview.findViewById(R.id.textView1);
        txtScore = (TextView) rootview.findViewById(R.id.textView_scoretest);
        rda = (RadioButton) rootview.findViewById(R.id.radioButton1);
        rdb = (RadioButton) rootview.findViewById(R.id.radioButton2);
        rdc = (RadioButton) rootview.findViewById(R.id.radioButton3);
        rdd = (RadioButton) rootview.findViewById(R.id.radioButton4);
        butNext = (Button) rootview.findViewById(R.id.button_next);

        final DatabaseAccess databaseAccess = DatabaseAccess.getInstance(getActivity());
        databaseAccess.open();
        mixList = databaseAccess.getTestPre2();

        databaseAccess.close();

        txtTitle.setText("Present Continuous");
        currentMIX = mixList.get(qid);
        setQuestionView();


        butNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RadioGroup radioGroup = (RadioGroup) getActivity().findViewById(R.id.radioGroup1);

                int radioCheckedId = radioGroup.getCheckedRadioButtonId();

                switch (radioCheckedId){
                    case R.id.radioButton1 : setActivity();
                        break;
                    case R.id.radioButton2 : setActivity();
                        break;
                    case R.id.radioButton3 : setActivity();
                        break;
                    case R.id.radioButton4 : setActivity();
                        break;
                    case -1 : Toast.makeText(getActivity(), "Please select your choice.", Toast.LENGTH_LONG).show();
                        break;
                }

                }

        });

        return rootview;
    }

    private void setQuestionView() {
        txtQuestion.setText(currentMIX.getMixQUESTION());
        rda.setText(currentMIX.getMixOPTA());
        rdb.setText(currentMIX.getMixOPTB());
        rdc.setText(currentMIX.getMixOPTC());
        rdd.setText(currentMIX.getMixOPTD());
        txtScore.setText(" " + score);
        qid++;
        ans++;
    }

    private void setActivity(){

        final RadioGroup grp = (RadioGroup) getActivity().findViewById(R.id.radioGroup1);
        final RadioButton answer = (RadioButton) getActivity().findViewById(grp.getCheckedRadioButtonId());

        grp.clearCheck();

        if (currentMIX.getMixANSWER().equals(answer.getText())) {
            score++;
            Log.d("score", "Your score PreCon : " + score);

        }
        if (qid < mixList.size() && ans != 0) {
            currentMIX = mixList.get(qid);
            setQuestionView();

        } else {
            setScoreTest();
            Intent intent = new Intent(getActivity(), Fragment3_Answer.class);
            Bundle b = new Bundle();
            b.putInt("score", score); //Your score
            intent.putExtras(b); //Put your score to your next Intent
            startActivity(intent);
            getActivity().finish();
        }
    }

   private void setScoreTest(){

       DatabaseAccess databaseAccess = DatabaseAccess.getInstance(getActivity());
       databaseAccess.open();
       databaseAccess.addScore(2,score);
       Toast.makeText(getActivity(), "Inserted!", Toast.LENGTH_LONG).show();
       databaseAccess.close();
    }

}
