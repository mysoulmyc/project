package com.mysoulmyc.android.appenglish;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.mysoulmyc.android.appenglish.DB.DatabaseAccess;
import com.mysoulmyc.android.appenglish.DB.MixQuestAns;

import java.util.List;

/**
 * Created by Toshiba on 20/4/2559.
 */
public class PreTest extends Activity {

    List<MixQuestAns> mixList;
    MixQuestAns currentMIX;
    int score = 0;
    int qid = 0;
    int ans = 0;

    TextView txtQuestion,txtScore,txtTitle;
    RadioButton rda, rdb, rdc, rdd;
    Button butNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout3_test_page);

        Toast.makeText(getApplicationContext(), " เริ่มทำแบบทดสอบ Pre-Test! ", Toast.LENGTH_LONG).show();

        txtTitle = (TextView) findViewById(R.id.textView_title);
        txtQuestion = (TextView) findViewById(R.id.textView1);
        txtScore = (TextView) findViewById(R.id.textView_scoretest);
        rda = (RadioButton) findViewById(R.id.radioButton1);
        rdb = (RadioButton) findViewById(R.id.radioButton2);
        rdc = (RadioButton) findViewById(R.id.radioButton3);
        rdd = (RadioButton) findViewById(R.id.radioButton4);
        butNext = (Button) findViewById(R.id.button_next);

        final DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        mixList = databaseAccess.getPreTest();
        databaseAccess.close();

        txtTitle.setText("Pre-Test");
        currentMIX = mixList.get(qid);
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
        txtQuestion.setText(currentMIX.getMixQUESTION());
        rda.setText(currentMIX.getMixOPTA());
        rdb.setText(currentMIX.getMixOPTB());
        rdc.setText(currentMIX.getMixOPTC());
        rdd.setText(currentMIX.getMixOPTD());
        txtScore.setText(" " + score);
        qid++;
        ans++;
    }

    private void setActivity() {

        final RadioGroup grp = (RadioGroup) findViewById(R.id.radioGroup1);
        final RadioButton answer = (RadioButton) findViewById(grp.getCheckedRadioButtonId());

        grp.clearCheck();

        if (currentMIX.getMixANSWER().equals(answer.getText())) {
            score++;
            Log.d("score", "Your score PreTest : " + score);

        }
        if (qid < mixList.size() && ans != 0) {
            currentMIX = mixList.get(qid);
            setQuestionView();

        } else {
            setScoreTest();
            Intent intent = new Intent(this, Fragment3_AnswerMixtest.class);
            Bundle b = new Bundle();
            b.putInt("score", score); //Your score
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

    public void onBackPressed() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this,R.style.Base_Theme_AppCompat_Dialog_Alert);
        dialog.setTitle("Exit");
        dialog.setCancelable(true);
        dialog.setMessage("Do you want to exit?");
        dialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        dialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        dialog.show();
    }
}
