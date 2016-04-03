package com.example.toshiba.appenglish.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Toshiba on 23/3/2559.
 */
public class DatabaseAccess {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase database;
    private static DatabaseAccess instance;
    private DbHelper mHelper;

    private DatabaseAccess(Context context) {
        this.openHelper = new DbHelper(context);
    }

    public static DatabaseAccess getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseAccess(context);
        }
        return instance;
    }

    public void open() {
        this.database = openHelper.getWritableDatabase();
    }

    public void close() {
        if (database != null) {
            this.database.close();
        }
    }

    public List<Question> getTest() {
        database = openHelper.getWritableDatabase();
        List<Question> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM Question WHERE id_tense=1 ", null);
        //Cursor cursor = database.rawQuery("SELECT * FROM Question WHERE id_tense=2 ORDER BY RANDOM() Limit 6", null);
        /*Cursor cursor = database.rawQuery("SELECT * FROM Question " +
                "INNER JOIN  answer ON Question.id_question=answer.id_question WHERE Question.id_tense=1", null);*/

        //SELECT * FROM Question INNER JOIN  answer ON Question.id_question=answer.id_question WHERE Question.id_tense=1

        /*cursor.moveToFirst();Question.question, answer.answer, answer.key
        while (!cursor.isAfterLast()) {
            list.add(cursor.getString(1));
            cursor.moveToNext();
        }*/
        //Question quest = null;
        if (cursor != null && cursor.getCount() > 0) {
            if (cursor.moveToFirst()) {
                do {
                    Question quest = new Question();
                    quest.setID(cursor.getInt(0));
                    quest.setQUESTION(cursor.getString(1));
                    /*quest.setOPTA(cursor.getString(2));
                    quest.setOPTB(cursor.getString(3));
                    quest.setOPTC(cursor.getString(4));
                    quest.setOPTD(cursor.getString(5));
                    quest.setANSWER(cursor.getString(6));*/
                    list.add(quest);
                } while (cursor.moveToNext());
            }
        }
        cursor.close();
        //database.close();
        return list;

    }

    public List<Answer> getChoice() {
        database = openHelper.getWritableDatabase();
        List<Answer> ans = new ArrayList<>();
        //int num = 0;ORDER BY RANDOM() Limit 4
        Cursor cs = database.rawQuery("SELECT * FROM answer WHERE id_Question=1 ", null);
        if (cs != null && cs.getCount() > 0) {
            if (cs.moveToFirst()) {
                do {
                    Answer choice = new Answer();
                    choice.setID(cs.getInt(0));
                    choice.setOPTA(cs.getString(1));
                    choice.setOPTB(cs.getString(2));
                    choice.setOPTC(cs.getString(3));
                    choice.setOPTD(cs.getString(4));
                    choice.setANSWER(cs.getString(5));
                    ans.add(choice);
                    //num++;
                } while (cs.moveToNext());
            }
        }
        cs.close();
        return ans;
    }

    /*public List<Answer> getAnswer(){
        database = openHelper.getWritableDatabase();
        List<Answer> ans = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM answer WHERE id_tense=1 ", null);

        return ans;
    }*/

    public int addScore(Score score) {

/*        ContentValues values = new ContentValues();
        values.put("point", score.getScore());

        database = openHelper.getWritableDatabase();

        database.insert("Point", null, values);
        //database.update();
        database.close();*/


        database = mHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("point", score.getScore());
        database.insert("Point", null, values);

        database.close();
        return 1;
    }


    /*public void getClear() {
        getTest().clear();
    }*/


}
