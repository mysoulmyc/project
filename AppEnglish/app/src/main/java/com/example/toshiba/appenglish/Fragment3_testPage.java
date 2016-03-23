package com.example.toshiba.appenglish;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.toshiba.appenglish.DB.DatabaseAccess;
import com.example.toshiba.appenglish.DB.DbHelper;
import com.example.toshiba.appenglish.DB.Question;

import java.util.List;

/*
 * Created by Toshiba on 22/2/2559.
 */
public class Fragment3_testPage extends Fragment {

    View rootview;
/*    TextSwitcher textSwitcher;
    //Button butnext;
    String[] TextToSwitched;
    int curIndex;
    SQLiteDatabase mDb;
    DbHelper mHelper;
    Cursor mCursor;*/

    List<Question> quesList;
    int score = 0;
    int qid = 0;
    Question currentQ;
    TextView txtQuestion;
    RadioButton rda, rdb, rdc,rdd;
    Button butNext;

    SQLiteDatabase mDb;
    DbHelper mHelper;
    //Cursor mCursor;

    //DbHelper mHelper;

    private static Context myContext;
    public static boolean btlog;

    ListView listView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.layout3_test_page, container, false);

        listView = (ListView) rootview.findViewById(R.id.listView);

        txtQuestion = (TextView) rootview.findViewById(R.id.textView1);
        butNext = (Button) rootview.findViewById(R.id.button_next);

        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(getActivity());
        databaseAccess.open();
        quesList = databaseAccess.getPOIs();
        //final List<Question> pois = databaseAccess.getPOIs();
        databaseAccess.close();

        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, pois);
        //listView.setAdapter(adapter);


        //quesList = mDb.getPOIs();
        currentQ = quesList.get(qid);

        butNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(qid < 5){
                    currentQ = quesList.get(qid);
                    txtQuestion.setText(currentQ.getQUESTION());
                    qid++;
                }
                else {
                    Intent intent = new Intent(getActivity(), Fragment3_Answer.class);
                    startActivity(intent);
                }
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

}
