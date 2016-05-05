package com.example.toshiba.appenglish.testPre;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.toshiba.appenglish.DB.DatabaseAccess;
import com.example.toshiba.appenglish.DB.DbHelper;
import com.example.toshiba.appenglish.DB.MixQuestAns;
import com.example.toshiba.appenglish.DB.Score;
import com.example.toshiba.appenglish.Fragment3_Answer;
import com.example.toshiba.appenglish.R;

import java.util.List;

/*
 * Created by Toshiba on 22/2/2559.
 */
public class Fragment3_testPrePage1 extends Fragment {

    View rootview;
/*    TextSwitcher textSwitcher;
    //Button butnext;
    String[] TextToSwitched;
    int curIndex;
    SQLiteDatabase mDb;
    DbHelper mHelper;
    Cursor mCursor;*/

    //Score currentS;
    /*List<Question> quesList;
    List<Answer> answerList;
    List<Score> scoreList;*/

    List<MixQuestAns> mixList;
    MixQuestAns currentMIX;


    int score = 0;
    int qid = 0;
    int ans = 0;

    //Question currentQ;
    //Answer currentA;
    Score currentS;

    TextView txtQuestion,txtScore,txtTitle;
    RadioButton rda, rdb, rdc, rdd;
    Button butNext;
    //RadioGroup grp;
    //String answer;
    //String aa;

    String choice;

    SQLiteDatabase mDb;
    DbHelper mHelper;
    DatabaseAccess mDba;
    //Cursor mCursor;

    //DbHelper mHelper;

    private static final int rda_id = 1000;//first radio button id
    private static final int rdB_id = 1001;//second radio button id
    private static final int rdC_id = 1002;//third radio button id
    private static final int rdCDid = 1003;//third radio button id

    private static Context myContext;
    public static boolean btlog;

    //private int radioCheckedId = -1;

    ListView listView;

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


        //grp = (RadioGroup) rootview.findViewById(R.id.radioGroup1);
        //final RadioButton answer = (RadioButton) rootview.findViewById(grp.getCheckedRadioButtonId());

        final DatabaseAccess databaseAccess = DatabaseAccess.getInstance(getActivity());
        databaseAccess.open();
        //quesList = databaseAccess.getTest();
        //answerList = databaseAccess.getChoice();
        //scoreList = databaseAccess.getScoreTest();
        mixList = databaseAccess.getTest();

        //final List<Question> pois = databaseAccess.getPOIs();
        databaseAccess.close();


        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, pois);
        //listView.setAdapter(adapter);

        txtTitle.setText("Present Simple");
        currentMIX = mixList.get(qid);

        //quesList = mDb.getPOIs();
        //currentQ = quesList.get(qid);
        //++qid;
        //currentQ = quesList.get(qid);
        //currentA = answerList.get(ans);
        //currentS = scoreList.get(score);
        setQuestionView();
/*        txtQuestion.setText(currentQ.getQUESTION());
        rda.setText(currentQ.getOPTA());
        rdb.setText(currentQ.getOPTB());
        rdc.setText(currentQ.getOPTC());
        rdd.setText(currentQ.getOPTD());*/

        /*RadioGroup radioGroup = (RadioGroup) getActivity().findViewById(R.id.radioGroup1);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // find which radio button is selected
                radioCheckedId = checkedId;
            }
        });*/



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


                //for(int i = 0;i<quesList.size();i++) {
                //do {

                /*final RadioGroup grp = (RadioGroup) getActivity().findViewById(R.id.radioGroup1);
                final RadioButton answer = (RadioButton) getActivity().findViewById(grp.getCheckedRadioButtonId());*/
                //grp.getCheckedRadioButtonId();
                //check button
                /*grp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        // find which radio button is selected
                        if (checkedId == R.id.radioButton1) {
                            Toast.makeText(getActivity(), "choice: " + answer.getText(),
                                    Toast.LENGTH_SHORT).show();
                        } else if (checkedId == R.id.radioButton2) {
                            Toast.makeText(getActivity(), "choice: " + answer.getText(),
                                    Toast.LENGTH_SHORT).show();
                        } else if (checkedId == R.id.radioButton3) {
                            Toast.makeText(getActivity(), "choice: " + answer.getText(),
                                    Toast.LENGTH_SHORT).show();
                        } else if (checkedId == R.id.radioButton4) {
                            Toast.makeText(getActivity(), "choice: " + answer.getText(),
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getActivity(),
                                    "No item is Selected", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                grp.clearCheck();
                int selectedId = grp.getCheckedRadioButtonId();*/


                /*int btn = grp.getCheckedRadioButtonId();
                switch (selectedId){
                    case R.id.radioButton1: setQuestionView();
                        break;
                    case R.id.radioButton2: setQuestionView();
                        break;
                    case R.id.radioButton3: setQuestionView();
                        break;
                    case R.id.radioButton4: setQuestionView();
                        break;
                    case -1: Toast.makeText(getActivity(), "Please select your choice.", Toast.LENGTH_LONG).show();
                        break;
                }*/


                    //Log.d("yourans", currentA.getANSWER() + " " + answer.getText());

/*                for (int i = 0; i < quesList.size(); i++) {
                    if (grp.getCheckedRadioButtonId() == -1) {
                        Toast.makeText(getActivity(), "Please select your choice.", Toast.LENGTH_LONG).show();
                    } else {
                        if (currentA.getANSWER().equals(answer.getText())) {
                            score++;
                            Log.d("score", "Your score" + score);
                        }
                    }
                }*/

                    /////////////////////////////////////////////////////////////////////////////
                   /* if (selectedId != answer.getId()) {
                        grp.setClickable(false);
                        butNext.setClickable(false);
                        Toast.makeText(getActivity(), "Please select your choice.", Toast.LENGTH_LONG).show();
                    }*/

                /*if (grp.getCheckedRadioButtonId()==-1){
                    butNext.setClickable(false);
                    Toast.makeText(getActivity(), "Please select your choice.", Toast.LENGTH_LONG).show();
                }*/
                /* if (currentA.getANSWER().equals(answer.getText())==false){
                    Toast.makeText(getActivity(), "Please select your choice.", Toast.LENGTH_LONG).show();
                }*/
                    /*if (currentA.getANSWER().equals(answer.getText())) {
                        //checkQuestion();
                        score++;
                        Log.d("score", "Your score" + score);

                    }
                    if (qid < quesList.size() && ans != 0) {
                        currentQ = quesList.get(qid);
                        currentA = answerList.get(ans);
                        *//*txtQuestion.setText(currentQ.getQUESTION());
                        rda.setText(currentQ.getOPTA());
                        rdb.setText(currentQ.getOPTB());
                        rdc.setText(currentQ.getOPTC());
                        rdd.setText(currentQ.getOPTD());
                        qid++;*//*
                        setQuestionView();

                    } else {
                        Intent intent = new Intent(getActivity(), Fragment3_Answer.class);
                        Bundle b = new Bundle();
                        b.putInt("score", score); //Your score
                        b.putString("yourans", currentA.getANSWER());
                        intent.putExtras(b); //Put your score to your next Intent
                        startActivity(intent);
                        getActivity().finish();
                    }*/
////////////////////////////////////////////////////////////////////////////////////////

                    //} while (quesList.size()==10);
                    //}
                }

        });


        ///////////////////////////////

        //checkDatabase();

/*
        DbHelper db = new DbHelper(getActivity());
        try {
            db.createDataBase();
            //db.openDataBase();
        }catch (SQLException e){
            throw new Error("Unable to create database");
            //db.checkDataBase();

        }
*/

        /*mDb = db.getReadableDatabase();
        quesList = db.getAllQuestions();
        currentQ = quesList.get(qid);
        txtQuestion = (TextView) rootview.findViewById(R.id.textView1);
        rda = (RadioButton) rootview.findViewById(R.id.radioButton1);
        rdb = (RadioButton) rootview.findViewById(R.id.radioButton2);
        rdc = (RadioButton) rootview.findViewById(R.id.radioButton3);
        butNext = (Button) rootview.findViewById(R.id.button_next);

        setQuestionView();


        butNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (qid < 2) {
                    currentQ = quesList.get(qid);
                    setQuestionView();
                }
                else {
                    Intent intent = new Intent(getActivity(), Fragment3_Answer.class);
                    startActivity(intent);
                }

            }
        });*/


/*
        ListView listView1 = (ListView)rootview.findViewById(R.id.listView1);

        mHelper = new MyDbHelper(getActivity());
        mDb = mHelper.getWritableDatabase();
        mCursor = mDb.rawQuery("SELECT " + MyDbHelper.COL_NAME + ", " + MyDbHelper.COL_PIECE_PRICE
                + ", " + MyDbHelper.COL_CAKE_PRICE + " FROM " + MyDbHelper.TABLE_NAME, null);

        ArrayList<String> dirArray = new ArrayList<String>();
        mCursor.moveToFirst();

        while ( !mCursor.isAfterLast() ){
            dirArray.add(mCursor.getString(mCursor.getColumnIndex(MyDbHelper.COL_NAME)) + "\n"
                    + "Piece : " + mCursor.getString(mCursor.getColumnIndex(MyDbHelper.COL_PIECE_PRICE)) + "\t\t"
                    + "Cake : " + mCursor.getString(mCursor.getColumnIndex(MyDbHelper.COL_CAKE_PRICE)));
            mCursor.moveToNext();
        }

        ArrayAdapter<String> adapterDir = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, dirArray);
        listView1.setAdapter(adapterDir);
        listView1.setAdapter(adapterDir);
*/

/*
        textSwitcher = (TextSwitcher) rootview.findViewById(R.id.textSwitcher);
        butnext = (Button) rootview.findViewById(R.id.button_next);

        textSwitcher.setInAnimation(getActivity(), android.R.anim.fade_in);
        textSwitcher.setOutAnimation(getActivity(), android.R.anim.fade_out);

        textSwitcher.setFactory(new ViewSwitcher.ViewFactory() {

            @Override
            public View makeView() {
                TextView textView = new TextView(getActivity());
                textView.setTextSize(30);
                textView.setTextColor(Color.RED);
                textView.setGravity(Gravity.CENTER_HORIZONTAL);
                textView.setTypeface(Typeface.DEFAULT_BOLD);
                return textView;
            }
        });
*/


/*
        curIndex = 0;
        textSwitcher.setText(TextToSwitched[curIndex]);

        butnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                if(curIndex == TextToSwitched.length-1){
                    curIndex = 0;
                    textSwitcher.setText(TextToSwitched[curIndex]);
                }else{
                    textSwitcher.setText(TextToSwitched[++curIndex]);
                }
            }
        });
*/

/*      DbHelper db = new DbHelper(getActivity());
        quesList = db.getAllQuestions();
        currentQ = quesList.get(qid);
        txtQuestion = (TextView) rootview.findViewById(R.id.textView1);
        rda = (RadioButton) rootview.findViewById(R.id.radioButton1);
        rdb = (RadioButton) rootview.findViewById(R.id.radioButton2);
        rdc = (RadioButton) rootview.findViewById(R.id.radioButton3);
        butNext = (Button) rootview.findViewById(R.id.button_next);
        setQuestionView();

        butNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioGroup grp = (RadioGroup) getActivity().findViewById(R.id.radioGroup1);
                RadioButton answer = (RadioButton) getActivity().findViewById(grp.getCheckedRadioButtonId());
                Log.d("yourans", currentQ.getANSWER() + " " + answer.getText());
                if (currentQ.getANSWER().equals(answer.getText())) {
                    score++;
                    Log.d("score", "Your score" + score);
                }
                if (qid < 5) {
                    currentQ = quesList.get(qid);
                    setQuestionView();
                }
*//*                if (btlog!=answer.isChecked()){
                    AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
                    dialog.setTitle("Error");
                    dialog.setCancelable(false);
                    dialog.setMessage("Pleas select your choice.");
                    dialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });

                    dialog.show();

                }*//*
                else {
                    Intent intent = new Intent(getActivity(), Fragment3_Answer.class);
                    Bundle b = new Bundle();
                    b.putInt("score", score); //Your score
                    intent.putExtras(b); //Put your score to your next Intent
                    startActivity(intent);
                    //fffffffinish();
                }
            }
        });*/

/*        DbHelper db = new DbHelper(getActivity());
        try {
            db.createDataBase();
            db.openDataBase();
        }catch (SQLException e){

        }
        try{
            Cursor cursor =
        }*/

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
            //checkQuestion();
            score++;
            //choice = answer.getText().toString();
            //currentS = scoreList.get(score);
            Log.d("score", "Your score PreSim : " + score);

        }
        if (qid < mixList.size() && ans != 0) {
            currentMIX = mixList.get(qid);
            //currentQ = quesList.get(qid);
            //currentA = answerList.get(ans);
            //currentS = scoreList.get(score);
                        /*txtQuestion.setText(currentQ.getQUESTION());
                        rda.setText(currentQ.getOPTA());
                        rdb.setText(currentQ.getOPTB());
                        rdc.setText(currentQ.getOPTC());
                        rdd.setText(currentQ.getOPTD());
                        qid++;*/
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

       /*Album_db db = new Album_db(this);

       String artiste = ((EditText) this.findViewById(R.id.editArtist))
               .getText().toString();
       String titre = ((EditText) this.findViewById(R.id.editTitle))
               .getText().toString();

       Album album = new Album(artiste, titre);
       db.insertAlbum(album);
       updateList();*/

       DatabaseAccess databaseAccess = DatabaseAccess.getInstance(getActivity());
       databaseAccess.open();

       //databaseAccess.getScoreTest();
       databaseAccess.addScore(1,score);
       //databaseAccess.updateScore(score,1);
       Toast.makeText(getActivity(), "Inserted!", Toast.LENGTH_LONG).show();
       databaseAccess.close();
    }

/*    private void checkQuestion() {
        grp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == rda.getId()) {
                    aa = rda.getText().toString();


                } else if (checkedId == rdb.getId()) {
                    aa = rdb.getText().toString();


                } else if (checkedId == rdc.getId()) {
                    aa = rdc.getText().toString();

                } else if (checkedId == rdd.getId()) {
                    aa = rdd.getText().toString();


                }
            }
        });
    }*/

/*    private void setQuestionView() {
        txtQuestion.setText(currentQ.getQUESTION());
        rda.setText(currentQ.getOPTA());
        rdb.setText(currentQ.getOPTB());
        rdc.setText(currentQ.getOPTC());
        qid++;
    }*/


/*    public void onPause() {
        super.onPause();
        mHelper.close();
        mDb.close();
    }*/

/*    public void checkDatabase() {
        String url = "/data/data/com.example.toshiba.appenglish/databases/data";
        File f = new File(url);
        if (!f.exists()) {
            try {
                mHelper = new DbHelper(getActivity());
                mDb = mHelper.getWritableDatabase();
                mDb.close();
                mHelper.close();
                InputStream in = getActivity().getAssets().open("data");
                OutputStream out = new FileOutputStream(url);
                byte[] buffer = new byte[1024];
                //in.read(buffer);
                //out.write(buffer, 0, buffer.length);
                int length;
                while ((length = in.read(buffer)) > 0) {
                    out.write(buffer, 0, length);
                }

                in.close();
                out.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void onPause() {
        super.onPause();
        mHelper.close();
        mDb.close();
    }*/

/*    public void onStop(){
        super.onStop();
        quesList.clear();
    }*/

}
