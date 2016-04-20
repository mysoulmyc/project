package com.example.toshiba.appenglish;

/*
 * Created by Toshiba on 29/12/2558.
 */

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

import com.example.toshiba.appenglish.DB.DatabaseAccess;
import com.example.toshiba.appenglish.DB.MixQuestAns;

import java.util.List;

public class Fragment4_mixtestPage extends Fragment {
    View rootview;

    List<MixQuestAns> mixList;
    MixQuestAns currentMIX;
    int score = 0;
    int qid = 0;

    TextView txtQuestion;
    RadioButton rda, rdb, rdc, rdd;
    Button butNext;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.layout3_test_page, container, false);

        txtQuestion = (TextView) rootview.findViewById(R.id.textView1);
        rda = (RadioButton) rootview.findViewById(R.id.radioButton1);
        rdb = (RadioButton) rootview.findViewById(R.id.radioButton2);
        rdc = (RadioButton) rootview.findViewById(R.id.radioButton3);
        rdd = (RadioButton) rootview.findViewById(R.id.radioButton4);
        butNext = (Button) rootview.findViewById(R.id.button_next);

        final DatabaseAccess databaseAccess = DatabaseAccess.getInstance(getActivity());
        databaseAccess.open();
        mixList = databaseAccess.getMixQuestAns();
        databaseAccess.close();

        currentMIX = mixList.get(qid);
        setQuestionView();

        butNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RadioGroup radioGroup = (RadioGroup) getActivity().findViewById(R.id.radioGroup1);
                int radioCheckedId = radioGroup.getCheckedRadioButtonId();

                switch (radioCheckedId) {
                    case R.id.radioButton1:
                        setActivity();
                        break;
                    case R.id.radioButton2:
                        setActivity();
                        break;
                    case R.id.radioButton3:
                        setActivity();
                        break;
                    case R.id.radioButton4:
                        setActivity();
                        break;
                    case -1:
                        Toast.makeText(getActivity(), "Please select your choice.", Toast.LENGTH_LONG).show();
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
        qid++;
    }

    private void setActivity() {

        final RadioGroup grp = (RadioGroup) getActivity().findViewById(R.id.radioGroup1);
        final RadioButton answer = (RadioButton) getActivity().findViewById(grp.getCheckedRadioButtonId());

        grp.clearCheck();

        if (currentMIX.getMixANSWER().equals(answer.getText())) {
            score++;
            Log.d("score", "Your score MixTest : " + score);
        }
        if (qid < mixList.size()) {
            currentMIX = mixList.get(qid);
            setQuestionView();
        } else {
            setScoreTest();
            Intent intent = new Intent(getActivity(), Fragment3_AnswerMixtest.class);
            Bundle b = new Bundle();
            b.putInt("score", score); //Your score
            intent.putExtras(b); //Put your score to your next Intent
            startActivity(intent);
            getActivity().finish();
        }

    }


    private void setScoreTest() {
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(getActivity());
        databaseAccess.open();
        databaseAccess.addScore(14, score);
        Toast.makeText(getActivity(), "Inserted!", Toast.LENGTH_LONG).show();
        databaseAccess.close();
    }


    ////SQL
    /*SELECT * FROM Question
    INNER JOIN answer
    WHERE answer.id_answer=Question.id_question
    ORDER BY RANDOM() LIMIT 2
*/

}
