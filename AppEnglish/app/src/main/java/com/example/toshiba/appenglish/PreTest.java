package com.example.toshiba.appenglish;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.toshiba.appenglish.DB.Answer;
import com.example.toshiba.appenglish.DB.DatabaseAccess;
import com.example.toshiba.appenglish.DB.Question;

import java.util.List;

/**
 * Created by Toshiba on 20/4/2559.
 */
public class PreTest extends Activity {

    List<Question> quesList;
    List<Answer> answerList;
    int score = 0;
    int qid = 0;
    int ans = 0;

    Question currentQ;
    Answer currentA;

    TextView txtQuestion,txtScore;
    RadioButton rda, rdb, rdc, rdd;
    Button butNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout3_test_page);

        txtQuestion = (TextView) findViewById(R.id.textView1);
        txtScore = (TextView) findViewById(R.id.textView_scoretest);
        rda = (RadioButton) findViewById(R.id.radioButton1);
        rdb = (RadioButton) findViewById(R.id.radioButton2);
        rdc = (RadioButton) findViewById(R.id.radioButton3);
        rdd = (RadioButton) findViewById(R.id.radioButton4);
        butNext = (Button) findViewById(R.id.button_next);

        final DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        quesList = databaseAccess.getPreTest();
        answerList = databaseAccess.getPreChoice();
        databaseAccess.close();

        currentQ = quesList.get(qid);
        currentA = answerList.get(ans);
        setQuestionView();


        butNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup1);
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
                        Toast.makeText(getApplicationContext(), "Please select your choice.", Toast.LENGTH_LONG).show();
                        break;
                }
            }

        });
    }

    private void setQuestionView() {
        txtQuestion.setText(currentQ.getQUESTION());
        rda.setText(currentA.getOPTA());
        rdb.setText(currentA.getOPTB());
        rdc.setText(currentA.getOPTC());
        rdd.setText(currentA.getOPTD());
        txtScore.setText(" " + score);
        qid++;
        ans++;
    }

    private void setActivity() {

        final RadioGroup grp = (RadioGroup) findViewById(R.id.radioGroup1);
        final RadioButton answer = (RadioButton) findViewById(grp.getCheckedRadioButtonId());

        grp.clearCheck();

        if (currentA.getANSWER().equals(answer.getText())) {
            score++;
            Log.d("score", "Your score PreTest : " + score);

        }
        if (qid < quesList.size() && ans != 0) {
            currentQ = quesList.get(qid);
            currentA = answerList.get(ans);
            setQuestionView();

        } else {
            setScoreTest();
            Intent intent = new Intent(this, Fragment3_Answer.class);
            Bundle b = new Bundle();
            b.putInt("score", score); //Your score
            b.putString("yourans", currentA.getANSWER());
            intent.putExtras(b); //Put your score to your next Intent
            startActivity(intent);
            this.finish();
        }
    }

    private void setScoreTest() {
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        databaseAccess.addScore(13, score);
        Toast.makeText(getApplicationContext(), "Inserted!", Toast.LENGTH_LONG).show();
        databaseAccess.close();
    }
}
