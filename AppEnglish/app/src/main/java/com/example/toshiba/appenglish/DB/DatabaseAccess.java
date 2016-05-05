package com.example.toshiba.appenglish.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

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

    ////////////////////// create character /////////////////////////////////////
    public void createCharacter(String name, int sex, int level) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        Date date = new Date();

        ContentValues values = new ContentValues();
        values.put("Name", name);
        values.put("id_sex", sex);
        values.put("date", dateFormat.format(date));
        values.put("level", level);
        values.put("date_use",dateFormat.format(date));
        database.insert("Member", null, values);

        Log.d("DB insert : ", "Create CharacterInfo....");
    }

    ////////////////////// read character ///////////////////////////////////////
    public CharacterInfo getCharacter() {
        database = openHelper.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM member ", null);
        if (cursor != null && cursor.getCount() > 0) {
            if (cursor.moveToFirst()) {
                CharacterInfo characterInfo = new CharacterInfo();
                characterInfo.setID(cursor.getInt(0));
                characterInfo.setNAME(cursor.getString(1));
                characterInfo.setSEX(cursor.getInt(2));
                characterInfo.setLEVEL(cursor.getInt(3));
                cursor.close();
                database.close();
                return characterInfo;
            }
        }
        return null;
    }

    ////////////////////// Change Character //////////////////////////////////

    //// Lv2
    public Score getLv2() {
        database = openHelper.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT id_tense,point FROM Point Where id_tense= 4 ", null);
        if (cursor != null && cursor.getCount() > 0) {
            if (cursor.moveToFirst()) {
                Score ss = new Score();
                ss.setiD(cursor.getInt(0));
                ss.setScore(cursor.getInt(1));
                cursor.close();
                database.close();
                return ss;
            }
        }
        return null;
    }

    //// Lv3
    public Score getLv3() {
        database = openHelper.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT id_tense,point FROM Point Where id_tense=8 ", null);
        if (cursor != null && cursor.getCount() > 0) {
            if (cursor.moveToFirst()) {
                Score ss = new Score();
                ss.setiD(cursor.getInt(0));
                ss.setScore(cursor.getInt(1));
                cursor.close();
                database.close();
                return ss;
            }
        }
        return null;
    }

    //// Lv4 unLock MixTest
    public Score getUnLockMixtest() {
        database = openHelper.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT id_tense,point FROM Point Where id_tense=12 ", null);
        if (cursor != null && cursor.getCount() > 0) {
            if (cursor.moveToFirst()) {
                Score ss = new Score();
                ss.setiD(cursor.getInt(0));
                ss.setScore(cursor.getInt(1));
                cursor.close();
                database.close();
                return ss;
            }
        }
        return null;
    }

    /////// date in / out app
    public CharacterInfo dateInOut(){
        database = openHelper.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT date_use, date_out , date_use - date_out AS total_date FROM Member ", null);
        if (cursor != null && cursor.getCount() > 0) {
            if (cursor.moveToFirst()) {
                CharacterInfo characterInfo = new CharacterInfo();
                characterInfo.setDATEUSE(cursor.getInt(0));
                characterInfo.setDATEOUT(cursor.getInt(1));
                cursor.close();
                database.close();
                return characterInfo;
            }
        }
        return null;
    }
    //////// date test mix test
    public Score dateScoreMix(){
        database = openHelper.getReadableDatabase();
        //Cursor cursor = database.rawQuery("SELECT datehp FROM Point Where id_tense=14 ", null);
        Cursor cursor = database.rawQuery("SELECT datehp, date FROM Point Where id_tense=14 " +
                "AND datehp = (SELECT MAX(datehp) FROM Point Where id_tense=14)", null);
        if (cursor != null && cursor.getCount() > 0) {
            if (cursor.moveToFirst()) {
                Score sc = new Score();
                sc.setDateMix(cursor.getInt(0));
                sc.setDateTime(cursor.getInt(1));
                cursor.close();
                database.close();
                return sc;
            }
        }
        return null;
    }


    ////////////////////// update Level Character //////////////////////////////////
    public void updateLevel(CharacterInfo oldLevel, int newLevel) {
        ContentValues values = new ContentValues();
        values.put("level", newLevel);
        database.update("Member", values, "id_mem = ?", new String[]{String.valueOf(oldLevel.getID())});
        //return oldTime;
    }


    ////////////////////// update date time come and out application  //////////////////////////////////

    public void updateTime(CharacterInfo oldTime) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd", Locale.getDefault());
        Date date = new Date();
        ContentValues values = new ContentValues();
        values.put("date_use", dateFormat.format(date));
/*        values.put("last_name", newContact.getLastName());
        values.put("phone", newContact.getPhone());
        values.put("email", newContact.getEmail());*/
        database.update("Member", values, "id_mem = ?", new String[]{String.valueOf(oldTime.getID())});
        //return oldTime;
    }

    public void updateTimeOut(CharacterInfo oldTime) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd", Locale.getDefault());
        Date date = new Date();
        ContentValues values = new ContentValues();
        values.put("date_out", dateFormat.format(date));
        database.update("Member", values, "id_mem = ?", new String[]{String.valueOf(oldTime.getID())});
    }

    ////////////////////// add score test to database  //////////////////////////////////
    public void addScore(int id, int score) {

/*        ContentValues values = new ContentValues();
        values.put("point", score.getScore());

        database = openHelper.getWritableDatabase();

        database.insert("Point", null, values);
        //database.update();
        database.close();*/

        //, Locale.getDefault()
        //"yyyy-MM-dd HH:mm:ss"

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        SimpleDateFormat dateHP = new SimpleDateFormat("yyyyMMdd", Locale.getDefault());
        Date date = new Date();

        //database = openHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("id_tense", id);
        values.put("point", score);
        values.put("date", dateFormat.format(date));
        values.put("datehp", dateHP.format(date));
        database.insert("Point", null, values);

        Log.d("DB insert : ", "Insert score....");

        //database.close();
        //return 1;

    }


//+++++++++++++++++++++++++++++++++++++++++++++ Test Part +++++++++++++++++++++++++++++++++++++++++++++++++++++++//

    ////////////////////// Pre Test //////////////////////////////////
    /*public List<Question> getPreTest() {
        database = openHelper.getReadableDatabase();
        List<Question> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM Question WHERE id_tense=13 ", null);
        if (cursor != null && cursor.getCount() > 0) {
            if (cursor.moveToFirst()) {
                do {
                    Question quest = new Question();
                    quest.setID(cursor.getInt(0));
                    quest.setQUESTION(cursor.getString(1));
                    list.add(quest);
                } while (cursor.moveToNext());
            }
        }
        cursor.close();
        database.close();
        return list;

    }

    public List<Answer> getPreChoice() {
        database = openHelper.getReadableDatabase();
        List<Answer> ans = new ArrayList<>();
        Cursor cs = database.rawQuery("SELECT * FROM answer WHERE id_Question=13 ", null);
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
                } while (cs.moveToNext());
            }
        }
        cs.close();
        database.close();
        return ans;
    }*/

    public List<MixQuestAns> getPreTest(){
        database = openHelper.getReadableDatabase();
        List<MixQuestAns> MIX = new ArrayList<>();
        Cursor cs = database.rawQuery("SELECT Question.question, answer.optA, answer.optB, " +
                "answer.optC, answer.optD, answer.key " +
                " FROM Question\n" +
                "    INNER JOIN answer\n" +
                "    WHERE answer.id_answer=Question.id_question\n" +
                "    ORDER BY RANDOM() LIMIT 20 ", null);
        if (cs != null && cs.getCount() > 0) {
            if (cs.moveToFirst()) {
                do {
                    MixQuestAns mix = new MixQuestAns();
                    mix.setMixQUESTION(cs.getString(0));
                    mix.setMixOPTA(cs.getString(1));
                    mix.setMixOPTB(cs.getString(2));
                    mix.setMixOPTC(cs.getString(3));
                    mix.setMixOPTD(cs.getString(4));
                    mix.setMixANSWER(cs.getString(5));
                    MIX.add(mix);
                } while (cs.moveToNext());
            }
        }
        cs.close();
        database.close();
        return MIX;
    }

    public Score get_PreScore() {
        database = openHelper.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT id_tense,point FROM Point Where id_tense= 13", null);
        // and point>=2,MAX(date)ss.setDateTime(cursor.getInt(2));
        if (cursor != null && cursor.getCount() > 0) {
            if (cursor.moveToFirst()) {
                Score ss = new Score();
                ss.setiD(cursor.getInt(0));
                ss.setScore(cursor.getInt(1));
                cursor.close();
                database.close();
                return ss;
            }
        }
        return null;
    }



    ////////////////////// Test Present Simple  //////////////////////////////////
    /*public List<Question> getTest() {
        database = openHelper.getReadableDatabase();
        List<Question> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM Question WHERE id_tense=1 ", null);
        //Cursor cursor = database.rawQuery("SELECT * FROM Question WHERE id_tense=2 ORDER BY RANDOM() Limit 6", null);
        *//*Cursor cursor = database.rawQuery("SELECT * FROM Question " +
                "INNER JOIN  answer ON Question.id_question=answer.id_question WHERE Question.id_tense=1", null);*//*

        //SELECT * FROM Question INNER JOIN  answer ON Question.id_question=answer.id_question WHERE Question.id_tense=1

        *//*cursor.moveToFirst();Question.question, answer.answer, answer.key
        while (!cursor.isAfterLast()) {
            list.add(cursor.getString(1));
            cursor.moveToNext();
        }*//*
        //Question quest = null;
        if (cursor != null && cursor.getCount() > 0) {
            if (cursor.moveToFirst()) {
                do {
                    Question quest = new Question();
                    quest.setID(cursor.getInt(0));
                    quest.setQUESTION(cursor.getString(1));
                    *//*quest.setOPTA(cursor.getString(2));
                    quest.setOPTB(cursor.getString(3));
                    quest.setOPTC(cursor.getString(4));
                    quest.setOPTD(cursor.getString(5));
                    quest.setANSWER(cursor.getString(6));*//*
                    list.add(quest);
                } while (cursor.moveToNext());
            }
        }
        cursor.close();
        //database.close();
        return list;

    }

    public List<Answer> getChoice() {
        database = openHelper.getReadableDatabase();
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
    }*/

    /*public List<Answer> getAnswer(){
        database = openHelper.getWritableDatabase();
        List<Answer> ans = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM answer WHERE id_tense=1 ", null);

        return ans;
    }*/

    /*public List<Score> getScoreTest(){
        database = openHelper.getWritableDatabase();
        List<Score> sc = new ArrayList<>();
        //int num = 0;
        Cursor cs = database.rawQuery("SELECT * FROM Point Where id_tense= 1 " , null);
        if (cs != null && cs.getCount() > 0) {
            if (cs.moveToFirst()) {
                do {
                    Score st = new Score();
                    st.setiD(cs.getInt(0));
                    st.setScore(cs.getInt(1));
                    *//*st.setOPTB(cs.getString(2));
                    choice.setOPTC(cs.getString(3));
                    choice.setOPTD(cs.getString(4));
                    choice.setANSWER(cs.getString(5));*//*
                    sc.add(st);
                    //num++;
                } while (cs.moveToNext());
            }
        }
        cs.close();
        return sc;

    }*/

    public List<MixQuestAns> getTest(){
        database = openHelper.getReadableDatabase();
        List<MixQuestAns> MIX = new ArrayList<>();
        Cursor cs = database.rawQuery("SELECT Question.question, answer.optA, answer.optB, answer.optC, answer.optD, answer.key " +
                " FROM Question\n" +
                "    INNER JOIN answer\n" +
                "    WHERE answer.id_answer=Question.id_question AND id_tense=1\n" +
                "    ORDER BY RANDOM() LIMIT 10 ", null);
        if (cs != null && cs.getCount() > 0) {
            if (cs.moveToFirst()) {
                do {
                    MixQuestAns mix = new MixQuestAns();
                    mix.setMixQUESTION(cs.getString(0));
                    mix.setMixOPTA(cs.getString(1));
                    mix.setMixOPTB(cs.getString(2));
                    mix.setMixOPTC(cs.getString(3));
                    mix.setMixOPTD(cs.getString(4));
                    mix.setMixANSWER(cs.getString(5));
                    MIX.add(mix);
                } while (cs.moveToNext());
            }
        }
        cs.close();
        database.close();
        return MIX;
    }

    public Score get_Score() {
        database = openHelper.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT id_tense,point,MAX(date) " +
                "FROM Point Where id_tense= 1 ", null);
        // and point>=2
        if (cursor != null && cursor.getCount() > 0) {
            if (cursor.moveToFirst()) {
                //do{
                Score ss = new Score();
                ss.setiD(cursor.getInt(0));
                ss.setScore(cursor.getInt(1));
                ss.setDateTime(cursor.getInt(2));
                cursor.close();
                database.close();
                return ss;
                //}while (cursor.moveToNext());
            }
        }
        return null;
    }

    public Score getScoreUnlockTest1() {
        database = openHelper.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT id_tense,MAX(point) " +
                "FROM Point Where id_tense=1 ", null);
        if (cursor != null && cursor.getCount() > 0) {
            if (cursor.moveToFirst()) {
                Score ss = new Score();
                ss.setiD(cursor.getInt(0));
                ss.setScore(cursor.getInt(1));
                cursor.close();
                database.close();
                return ss;
            }
        }
        return null;
    }

    ////////////////////// Test Present Continuous  //////////////////////////////////

    public List<MixQuestAns> getTestPre2(){
        database = openHelper.getReadableDatabase();
        List<MixQuestAns> MIX = new ArrayList<>();
        Cursor cs = database.rawQuery("SELECT Question.question, answer.optA, answer.optB, answer.optC, answer.optD, answer.key " +
                " FROM Question\n" +
                "    INNER JOIN answer\n" +
                "    WHERE answer.id_answer=Question.id_question AND id_tense=2 \n" +
                "    ORDER BY RANDOM() LIMIT 10 ", null);
        if (cs != null && cs.getCount() > 0) {
            if (cs.moveToFirst()) {
                do {
                    MixQuestAns mix = new MixQuestAns();
                    mix.setMixQUESTION(cs.getString(0));
                    mix.setMixOPTA(cs.getString(1));
                    mix.setMixOPTB(cs.getString(2));
                    mix.setMixOPTC(cs.getString(3));
                    mix.setMixOPTD(cs.getString(4));
                    mix.setMixANSWER(cs.getString(5));
                    MIX.add(mix);
                } while (cs.moveToNext());
            }
        }
        cs.close();
        database.close();
        return MIX;
    }

    /*public List<Question> getTestPre2() {
        database = openHelper.getReadableDatabase();
        List<Question> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM Question WHERE id_tense=2 ", null);
        if (cursor != null && cursor.getCount() > 0) {
            if (cursor.moveToFirst()) {
                do {
                    Question quest = new Question();
                    quest.setID(cursor.getInt(0));
                    quest.setQUESTION(cursor.getString(1));
                    list.add(quest);
                } while (cursor.moveToNext());
            }
        }
        cursor.close();
        database.close();
        return list;

    }

    public List<Answer> getChoicePre2() {
        database = openHelper.getReadableDatabase();
        List<Answer> ans = new ArrayList<>();
        Cursor cs = database.rawQuery("SELECT * FROM answer WHERE id_Question=2 ", null);
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
                } while (cs.moveToNext());
            }
        }
        cs.close();
        database.close();
        return ans;
    }*/

    public Score get_ScorePre2() {
        database = openHelper.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT id_tense,point,MAX(date) FROM Point Where id_tense= 2", null);
        // and point>=2
        if (cursor != null && cursor.getCount() > 0) {
            if (cursor.moveToFirst()) {
                Score ss = new Score();
                ss.setiD(cursor.getInt(0));
                ss.setScore(cursor.getInt(1));
                ss.setDateTime(cursor.getInt(2));
                cursor.close();
                database.close();
                return ss;
            }
        }
        return null;
    }

    public Score getScoreUnlockTest2() {
        database = openHelper.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT id_tense,MAX(point) FROM Point Where id_tense=2 ", null);
        if (cursor != null && cursor.getCount() > 0) {
            if (cursor.moveToFirst()) {
                Score ss = new Score();
                ss.setiD(cursor.getInt(0));
                ss.setScore(cursor.getInt(1));
                cursor.close();
                database.close();
                return ss;
            }
        }
        return null;
    }

    ////////////////////// Test Present Perfect  //////////////////////////////////

    public List<MixQuestAns> getTestPre3(){
        database = openHelper.getReadableDatabase();
        List<MixQuestAns> MIX = new ArrayList<>();
        Cursor cs = database.rawQuery("SELECT Question.question, answer.optA, answer.optB, answer.optC, answer.optD, answer.key " +
                " FROM Question\n" +
                "    INNER JOIN answer\n" +
                "    WHERE answer.id_answer=Question.id_question AND id_tense=3 \n" +
                "    ORDER BY RANDOM() LIMIT 10 ", null);
        if (cs != null && cs.getCount() > 0) {
            if (cs.moveToFirst()) {
                do {
                    MixQuestAns mix = new MixQuestAns();
                    mix.setMixQUESTION(cs.getString(0));
                    mix.setMixOPTA(cs.getString(1));
                    mix.setMixOPTB(cs.getString(2));
                    mix.setMixOPTC(cs.getString(3));
                    mix.setMixOPTD(cs.getString(4));
                    mix.setMixANSWER(cs.getString(5));
                    MIX.add(mix);
                } while (cs.moveToNext());
            }
        }
        cs.close();
        database.close();
        return MIX;
    }

    /*public List<Question> getTestPre3() {
        database = openHelper.getReadableDatabase();
        List<Question> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM Question WHERE id_tense=3 ", null);
        if (cursor != null && cursor.getCount() > 0) {
            if (cursor.moveToFirst()) {
                do {
                    Question quest = new Question();
                    quest.setID(cursor.getInt(0));
                    quest.setQUESTION(cursor.getString(1));
                    list.add(quest);
                } while (cursor.moveToNext());
            }
        }
        cursor.close();
        database.close();
        return list;

    }

    public List<Answer> getChoicePre3() {
        database = openHelper.getReadableDatabase();
        List<Answer> ans = new ArrayList<>();
        Cursor cs = database.rawQuery("SELECT * FROM answer WHERE id_Question=3 ", null);
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
                } while (cs.moveToNext());
            }
        }
        cs.close();
        database.close();
        return ans;
    }*/

    public Score get_ScorePre3() {
        database = openHelper.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT id_tense,point,MAX(date) FROM Point Where id_tense= 3 ", null);
        //and point>=2
        if (cursor != null && cursor.getCount() > 0) {
            if (cursor.moveToFirst()) {
                Score ss = new Score();
                ss.setiD(cursor.getInt(0));
                ss.setScore(cursor.getInt(1));
                ss.setDateTime(cursor.getInt(2));
                cursor.close();
                database.close();
                return ss;
            }
        }
        return null;
    }

    public Score getScoreUnlockTest3() {
        database = openHelper.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT id_tense,MAX(point) FROM Point Where id_tense=3 ", null);
        if (cursor != null && cursor.getCount() > 0) {
            if (cursor.moveToFirst()) {
                Score ss = new Score();
                ss.setiD(cursor.getInt(0));
                ss.setScore(cursor.getInt(1));
                cursor.close();
                database.close();
                return ss;
            }
        }
        return null;
    }

    ////////////////////// Test Present Perfect Continuous  //////////////////////////////////

    public List<MixQuestAns> getTestPre4(){
        database = openHelper.getReadableDatabase();
        List<MixQuestAns> MIX = new ArrayList<>();
        Cursor cs = database.rawQuery("SELECT Question.question, answer.optA, answer.optB, answer.optC, answer.optD, answer.key " +
                " FROM Question\n" +
                "    INNER JOIN answer\n" +
                "    WHERE answer.id_answer=Question.id_question AND id_tense=4 \n" +
                "    ORDER BY RANDOM() LIMIT 10 ", null);
        if (cs != null && cs.getCount() > 0) {
            if (cs.moveToFirst()) {
                do {
                    MixQuestAns mix = new MixQuestAns();
                    mix.setMixQUESTION(cs.getString(0));
                    mix.setMixOPTA(cs.getString(1));
                    mix.setMixOPTB(cs.getString(2));
                    mix.setMixOPTC(cs.getString(3));
                    mix.setMixOPTD(cs.getString(4));
                    mix.setMixANSWER(cs.getString(5));
                    MIX.add(mix);
                } while (cs.moveToNext());
            }
        }
        cs.close();
        database.close();
        return MIX;
    }

    /*public List<Question> getTestPre4() {
        database = openHelper.getReadableDatabase();
        List<Question> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM Question WHERE id_tense=4 ", null);
        if (cursor != null && cursor.getCount() > 0) {
            if (cursor.moveToFirst()) {
                do {
                    Question quest = new Question();
                    quest.setID(cursor.getInt(0));
                    quest.setQUESTION(cursor.getString(1));
                    list.add(quest);
                } while (cursor.moveToNext());
            }
        }
        cursor.close();
        database.close();
        return list;

    }

    public List<Answer> getChoicePre4() {
        database = openHelper.getReadableDatabase();
        List<Answer> ans = new ArrayList<>();
        Cursor cs = database.rawQuery("SELECT * FROM answer WHERE id_Question=4 ", null);
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
                } while (cs.moveToNext());
            }
        }
        cs.close();
        database.close();
        return ans;
    }*/

    public Score get_ScorePre4() {
        database = openHelper.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT id_tense,point,MAX(date) FROM Point Where id_tense= 4 ", null);
        //and point>=2
        if (cursor != null && cursor.getCount() > 0) {
            if (cursor.moveToFirst()) {
                Score ss = new Score();
                ss.setiD(cursor.getInt(0));
                ss.setScore(cursor.getInt(1));
                ss.setDateTime(cursor.getInt(2));
                cursor.close();
                database.close();
                return ss;
            }
        }
        return null;
    }

    public Score getScoreUnlockTest4() {
        database = openHelper.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT id_tense,MAX(point) FROM Point Where id_tense=4 ", null);
        if (cursor != null && cursor.getCount() > 0) {
            if (cursor.moveToFirst()) {
                Score ss = new Score();
                ss.setiD(cursor.getInt(0));
                ss.setScore(cursor.getInt(1));
                cursor.close();
                database.close();
                return ss;
            }
        }
        return null;
    }

        ////////////////////// Test Past Simple  //////////////////////////////////

    public List<MixQuestAns> getTestPast1(){
        database = openHelper.getReadableDatabase();
        List<MixQuestAns> MIX = new ArrayList<>();
        Cursor cs = database.rawQuery("SELECT Question.question, answer.optA, answer.optB, answer.optC, answer.optD, answer.key " +
                " FROM Question\n" +
                "    INNER JOIN answer\n" +
                "    WHERE answer.id_answer=Question.id_question AND id_tense=5 \n" +
                "    ORDER BY RANDOM() LIMIT 10 ", null);
        if (cs != null && cs.getCount() > 0) {
            if (cs.moveToFirst()) {
                do {
                    MixQuestAns mix = new MixQuestAns();
                    mix.setMixQUESTION(cs.getString(0));
                    mix.setMixOPTA(cs.getString(1));
                    mix.setMixOPTB(cs.getString(2));
                    mix.setMixOPTC(cs.getString(3));
                    mix.setMixOPTD(cs.getString(4));
                    mix.setMixANSWER(cs.getString(5));
                    MIX.add(mix);
                } while (cs.moveToNext());
            }
        }
        cs.close();
        database.close();
        return MIX;
    }

    /*public List<Question> getTestPast1() {
        database = openHelper.getReadableDatabase();
        List<Question> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM Question WHERE id_tense=5 ", null);
        if (cursor != null && cursor.getCount() > 0) {
            if (cursor.moveToFirst()) {
                do {
                    Question quest = new Question();
                    quest.setID(cursor.getInt(0));
                    quest.setQUESTION(cursor.getString(1));
                    list.add(quest);
                } while (cursor.moveToNext());
            }
        }
        cursor.close();
        database.close();
        return list;

    }

    public List<Answer> getChoicePast1() {
        database = openHelper.getReadableDatabase();
        List<Answer> ans = new ArrayList<>();
        Cursor cs = database.rawQuery("SELECT * FROM answer WHERE id_Question=5 ", null);
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
                } while (cs.moveToNext());
            }
        }
        cs.close();
        database.close();
        return ans;
    }*/

    public Score get_ScorePast1() {
        database = openHelper.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT id_tense,point,MAX(date) FROM Point Where id_tense=5 ", null);
        // and point>=2
        if (cursor != null && cursor.getCount() > 0) {
            if (cursor.moveToFirst()) {
                Score ss = new Score();
                ss.setiD(cursor.getInt(0));
                ss.setScore(cursor.getInt(1));
                ss.setDateTime(cursor.getInt(2));
                cursor.close();
                database.close();
                return ss;
            }
        }
        return null;
    }

    public Score getScoreUnlockTest5() {
        database = openHelper.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT id_tense,MAX(point) FROM Point Where id_tense=5 ", null);
        if (cursor != null && cursor.getCount() > 0) {
            if (cursor.moveToFirst()) {
                Score ss = new Score();
                ss.setiD(cursor.getInt(0));
                ss.setScore(cursor.getInt(1));
                cursor.close();
                database.close();
                return ss;
            }
        }
        return null;
    }

    ////////////////////// Test Past Continuous  //////////////////////////////////

    public List<MixQuestAns> getTestPast2(){
        database = openHelper.getReadableDatabase();
        List<MixQuestAns> MIX = new ArrayList<>();
        Cursor cs = database.rawQuery("SELECT Question.question, answer.optA, answer.optB, answer.optC, answer.optD, answer.key " +
                " FROM Question\n" +
                "    INNER JOIN answer\n" +
                "    WHERE answer.id_answer=Question.id_question AND id_tense=6 \n" +
                "    ORDER BY RANDOM() LIMIT 10 ", null);
        if (cs != null && cs.getCount() > 0) {
            if (cs.moveToFirst()) {
                do {
                    MixQuestAns mix = new MixQuestAns();
                    mix.setMixQUESTION(cs.getString(0));
                    mix.setMixOPTA(cs.getString(1));
                    mix.setMixOPTB(cs.getString(2));
                    mix.setMixOPTC(cs.getString(3));
                    mix.setMixOPTD(cs.getString(4));
                    mix.setMixANSWER(cs.getString(5));
                    MIX.add(mix);
                } while (cs.moveToNext());
            }
        }
        cs.close();
        database.close();
        return MIX;
    }


    /*public List<Question> getTestPast2() {
        database = openHelper.getReadableDatabase();
        List<Question> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM Question WHERE id_tense=6 ", null);
        if (cursor != null && cursor.getCount() > 0) {
            if (cursor.moveToFirst()) {
                do {
                    Question quest = new Question();
                    quest.setID(cursor.getInt(0));
                    quest.setQUESTION(cursor.getString(1));
                    list.add(quest);
                } while (cursor.moveToNext());
            }
        }
        cursor.close();
        database.close();
        return list;

    }

    public List<Answer> getChoicePast2() {
        database = openHelper.getReadableDatabase();
        List<Answer> ans = new ArrayList<>();
        Cursor cs = database.rawQuery("SELECT * FROM answer WHERE id_Question=6 ", null);
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
                } while (cs.moveToNext());
            }
        }
        cs.close();
        database.close();
        return ans;
    }*/

    public Score get_ScorePast2() {
        database = openHelper.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT id_tense,point,MAX(date) FROM Point Where id_tense=6 ", null);
        // and point>=2
        if (cursor != null && cursor.getCount() > 0) {
            if (cursor.moveToFirst()) {
                Score ss = new Score();
                ss.setiD(cursor.getInt(0));
                ss.setScore(cursor.getInt(1));
                ss.setDateTime(cursor.getInt(2));
                cursor.close();
                database.close();
                return ss;
            }
        }
        return null;
    }

    public Score getScoreUnlockTest6() {
        database = openHelper.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT id_tense,MAX(point) FROM Point Where id_tense=6 ", null);
        if (cursor != null && cursor.getCount() > 0) {
            if (cursor.moveToFirst()) {
                Score ss = new Score();
                ss.setiD(cursor.getInt(0));
                ss.setScore(cursor.getInt(1));
                cursor.close();
                database.close();
                return ss;
            }
        }
        return null;
    }

    ////////////////////// Test Past Perfect  //////////////////////////////////

    public List<MixQuestAns> getTestPast3(){
        database = openHelper.getReadableDatabase();
        List<MixQuestAns> MIX = new ArrayList<>();
        Cursor cs = database.rawQuery("SELECT Question.question, answer.optA, answer.optB, answer.optC, answer.optD, answer.key " +
                " FROM Question\n" +
                "    INNER JOIN answer\n" +
                "    WHERE answer.id_answer=Question.id_question AND id_tense=7 \n" +
                "    ORDER BY RANDOM() LIMIT 10 ", null);
        if (cs != null && cs.getCount() > 0) {
            if (cs.moveToFirst()) {
                do {
                    MixQuestAns mix = new MixQuestAns();
                    mix.setMixQUESTION(cs.getString(0));
                    mix.setMixOPTA(cs.getString(1));
                    mix.setMixOPTB(cs.getString(2));
                    mix.setMixOPTC(cs.getString(3));
                    mix.setMixOPTD(cs.getString(4));
                    mix.setMixANSWER(cs.getString(5));
                    MIX.add(mix);
                } while (cs.moveToNext());
            }
        }
        cs.close();
        database.close();
        return MIX;
    }


    /*public List<Question> getTestPast3() {
        database = openHelper.getReadableDatabase();
        List<Question> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM Question WHERE id_tense=7 ", null);
        if (cursor != null && cursor.getCount() > 0) {
            if (cursor.moveToFirst()) {
                do {
                    Question quest = new Question();
                    quest.setID(cursor.getInt(0));
                    quest.setQUESTION(cursor.getString(1));
                    list.add(quest);
                } while (cursor.moveToNext());
            }
        }
        cursor.close();
        database.close();
        return list;

    }

    public List<Answer> getChoicePast3() {
        database = openHelper.getReadableDatabase();
        List<Answer> ans = new ArrayList<>();
        Cursor cs = database.rawQuery("SELECT * FROM answer WHERE id_Question=7 ", null);
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
                } while (cs.moveToNext());
            }
        }
        cs.close();
        database.close();
        return ans;
    }*/

    public Score get_ScorePast3() {
        database = openHelper.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT id_tense,point,MAX(date) FROM Point Where id_tense=7 ", null);
        // and point>=2
        if (cursor != null && cursor.getCount() > 0) {
            if (cursor.moveToFirst()) {
                Score ss = new Score();
                ss.setiD(cursor.getInt(0));
                ss.setScore(cursor.getInt(1));
                ss.setDateTime(cursor.getInt(2));
                cursor.close();
                database.close();
                return ss;
            }
        }
        return null;
    }

    public Score getScoreUnlockTest7() {
        database = openHelper.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT id_tense,MAX(point) FROM Point Where id_tense=7 ", null);
        if (cursor != null && cursor.getCount() > 0) {
            if (cursor.moveToFirst()) {
                Score ss = new Score();
                ss.setiD(cursor.getInt(0));
                ss.setScore(cursor.getInt(1));
                cursor.close();
                database.close();
                return ss;
            }
        }
        return null;
    }

    ////////////////////// Test Past Perfect Continuous  //////////////////////////////////

    public List<MixQuestAns> getTestPast4(){
        database = openHelper.getReadableDatabase();
        List<MixQuestAns> MIX = new ArrayList<>();
        Cursor cs = database.rawQuery("SELECT Question.question, answer.optA, answer.optB, answer.optC, answer.optD, answer.key " +
                " FROM Question\n" +
                "    INNER JOIN answer\n" +
                "    WHERE answer.id_answer=Question.id_question AND id_tense=8 \n" +
                "    ORDER BY RANDOM() LIMIT 10 ", null);
        if (cs != null && cs.getCount() > 0) {
            if (cs.moveToFirst()) {
                do {
                    MixQuestAns mix = new MixQuestAns();
                    mix.setMixQUESTION(cs.getString(0));
                    mix.setMixOPTA(cs.getString(1));
                    mix.setMixOPTB(cs.getString(2));
                    mix.setMixOPTC(cs.getString(3));
                    mix.setMixOPTD(cs.getString(4));
                    mix.setMixANSWER(cs.getString(5));
                    MIX.add(mix);
                } while (cs.moveToNext());
            }
        }
        cs.close();
        database.close();
        return MIX;
    }

    /*public List<Question> getTestPast4() {
        database = openHelper.getReadableDatabase();
        List<Question> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM Question WHERE id_tense=8 ", null);
        if (cursor != null && cursor.getCount() > 0) {
            if (cursor.moveToFirst()) {
                do {
                    Question quest = new Question();
                    quest.setID(cursor.getInt(0));
                    quest.setQUESTION(cursor.getString(1));
                    list.add(quest);
                } while (cursor.moveToNext());
            }
        }
        cursor.close();
        database.close();
        return list;

    }

    public List<Answer> getChoicePast4() {
        database = openHelper.getReadableDatabase();
        List<Answer> ans = new ArrayList<>();
        Cursor cs = database.rawQuery("SELECT * FROM answer WHERE id_Question=8 ", null);
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
                } while (cs.moveToNext());
            }
        }
        cs.close();
        database.close();
        return ans;
    }*/

    public Score get_ScorePast4() {
        database = openHelper.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT id_tense,point,MAX(date) FROM Point Where id_tense=8 ", null);
        // and point>=2
        if (cursor != null && cursor.getCount() > 0) {
            if (cursor.moveToFirst()) {
                Score ss = new Score();
                ss.setiD(cursor.getInt(0));
                ss.setScore(cursor.getInt(1));
                ss.setDateTime(cursor.getInt(2));
                cursor.close();
                database.close();
                return ss;
            }
        }
        return null;
    }

    public Score getScoreUnlockTest8() {
        database = openHelper.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT id_tense,MAX(point) FROM Point Where id_tense=8 ", null);
        if (cursor != null && cursor.getCount() > 0) {
            if (cursor.moveToFirst()) {
                Score ss = new Score();
                ss.setiD(cursor.getInt(0));
                ss.setScore(cursor.getInt(1));
                cursor.close();
                database.close();
                return ss;
            }
        }
        return null;
    }

    ////////////////////// Test Future Simple  //////////////////////////////////

    public List<MixQuestAns> getTestFu1(){
        database = openHelper.getReadableDatabase();
        List<MixQuestAns> MIX = new ArrayList<>();
        Cursor cs = database.rawQuery("SELECT Question.question, answer.optA, answer.optB, answer.optC, answer.optD, answer.key " +
                " FROM Question\n" +
                "    INNER JOIN answer\n" +
                "    WHERE answer.id_answer=Question.id_question AND id_tense=9 \n" +
                "    ORDER BY RANDOM() LIMIT 10 ", null);
        if (cs != null && cs.getCount() > 0) {
            if (cs.moveToFirst()) {
                do {
                    MixQuestAns mix = new MixQuestAns();
                    mix.setMixQUESTION(cs.getString(0));
                    mix.setMixOPTA(cs.getString(1));
                    mix.setMixOPTB(cs.getString(2));
                    mix.setMixOPTC(cs.getString(3));
                    mix.setMixOPTD(cs.getString(4));
                    mix.setMixANSWER(cs.getString(5));
                    MIX.add(mix);
                } while (cs.moveToNext());
            }
        }
        cs.close();
        database.close();
        return MIX;
    }

    /*public List<Question> getTestFu1() {
        database = openHelper.getReadableDatabase();
        List<Question> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM Question WHERE id_tense=9 ", null);
        if (cursor != null && cursor.getCount() > 0) {
            if (cursor.moveToFirst()) {
                do {
                    Question quest = new Question();
                    quest.setID(cursor.getInt(0));
                    quest.setQUESTION(cursor.getString(1));
                    list.add(quest);
                } while (cursor.moveToNext());
            }
        }
        cursor.close();
        database.close();
        return list;

    }

    public List<Answer> getChoiceFu1() {
        database = openHelper.getReadableDatabase();
        List<Answer> ans = new ArrayList<>();
        Cursor cs = database.rawQuery("SELECT * FROM answer WHERE id_Question=9 ", null);
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
                } while (cs.moveToNext());
            }
        }
        cs.close();
        database.close();
        return ans;
    }*/

    public Score get_ScoreFu1() {
        database = openHelper.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT id_tense,point,MAX(date) FROM Point Where id_tense=9 ", null);
        // and point>=2
        if (cursor != null && cursor.getCount() > 0) {
            if (cursor.moveToFirst()) {
                Score ss = new Score();
                ss.setiD(cursor.getInt(0));
                ss.setScore(cursor.getInt(1));
                ss.setDateTime(cursor.getInt(2));
                cursor.close();
                database.close();
                return ss;
            }
        }
        return null;
    }

    public Score getScoreUnlockTest9() {
        database = openHelper.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT id_tense,MAX(point) FROM Point Where id_tense=9 ", null);
        if (cursor != null && cursor.getCount() > 0) {
            if (cursor.moveToFirst()) {
                Score ss = new Score();
                ss.setiD(cursor.getInt(0));
                ss.setScore(cursor.getInt(1));
                cursor.close();
                database.close();
                return ss;
            }
        }
        return null;
    }

    ////////////////////// Test Future Continuous  //////////////////////////////////

    public List<MixQuestAns> getTestFu2(){
        database = openHelper.getReadableDatabase();
        List<MixQuestAns> MIX = new ArrayList<>();
        Cursor cs = database.rawQuery("SELECT Question.question, answer.optA, answer.optB, answer.optC, answer.optD, answer.key " +
                " FROM Question\n" +
                "    INNER JOIN answer\n" +
                "    WHERE answer.id_answer=Question.id_question AND id_tense=10 \n" +
                "    ORDER BY RANDOM() LIMIT 10 ", null);
        if (cs != null && cs.getCount() > 0) {
            if (cs.moveToFirst()) {
                do {
                    MixQuestAns mix = new MixQuestAns();
                    mix.setMixQUESTION(cs.getString(0));
                    mix.setMixOPTA(cs.getString(1));
                    mix.setMixOPTB(cs.getString(2));
                    mix.setMixOPTC(cs.getString(3));
                    mix.setMixOPTD(cs.getString(4));
                    mix.setMixANSWER(cs.getString(5));
                    MIX.add(mix);
                } while (cs.moveToNext());
            }
        }
        cs.close();
        database.close();
        return MIX;
    }

    /*public List<Question> getTestFu2() {
        database = openHelper.getReadableDatabase();
        List<Question> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM Question WHERE id_tense=10 ", null);
        if (cursor != null && cursor.getCount() > 0) {
            if (cursor.moveToFirst()) {
                do {
                    Question quest = new Question();
                    quest.setID(cursor.getInt(0));
                    quest.setQUESTION(cursor.getString(1));
                    list.add(quest);
                } while (cursor.moveToNext());
            }
        }
        cursor.close();
        database.close();
        return list;

    }

    public List<Answer> getChoiceFu2() {
        database = openHelper.getReadableDatabase();
        List<Answer> ans = new ArrayList<>();
        Cursor cs = database.rawQuery("SELECT * FROM answer WHERE id_Question=10 ", null);
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
                } while (cs.moveToNext());
            }
        }
        cs.close();
        database.close();
        return ans;
    }*/

    public Score get_ScoreFu2() {
        database = openHelper.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT id_tense,point,MAX(date) FROM Point Where id_tense=10 ", null);
        // and point>=2
        if (cursor != null && cursor.getCount() > 0) {
            if (cursor.moveToFirst()) {
                Score ss = new Score();
                ss.setiD(cursor.getInt(0));
                ss.setScore(cursor.getInt(1));
                ss.setDateTime(cursor.getInt(2));
                cursor.close();
                database.close();
                return ss;
            }
        }
        return null;
    }

    public Score getScoreUnlockTest10() {
        database = openHelper.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT id_tense,MAX(point) FROM Point Where id_tense=10 ", null);
        if (cursor != null && cursor.getCount() > 0) {
            if (cursor.moveToFirst()) {
                Score ss = new Score();
                ss.setiD(cursor.getInt(0));
                ss.setScore(cursor.getInt(1));
                cursor.close();
                database.close();
                return ss;
            }
        }
        return null;
    }

    ////////////////////// Test Future Perfect  //////////////////////////////////

    public List<MixQuestAns> getTestFu3(){
        database = openHelper.getReadableDatabase();
        List<MixQuestAns> MIX = new ArrayList<>();
        Cursor cs = database.rawQuery("SELECT Question.question, answer.optA, answer.optB, answer.optC, answer.optD, answer.key " +
                " FROM Question\n" +
                "    INNER JOIN answer\n" +
                "    WHERE answer.id_answer=Question.id_question AND id_tense=11 \n" +
                "    ORDER BY RANDOM() LIMIT 10 ", null);
        if (cs != null && cs.getCount() > 0) {
            if (cs.moveToFirst()) {
                do {
                    MixQuestAns mix = new MixQuestAns();
                    mix.setMixQUESTION(cs.getString(0));
                    mix.setMixOPTA(cs.getString(1));
                    mix.setMixOPTB(cs.getString(2));
                    mix.setMixOPTC(cs.getString(3));
                    mix.setMixOPTD(cs.getString(4));
                    mix.setMixANSWER(cs.getString(5));
                    MIX.add(mix);
                } while (cs.moveToNext());
            }
        }
        cs.close();
        database.close();
        return MIX;
    }

    /*public List<Question> getTestFu3() {
        database = openHelper.getReadableDatabase();
        List<Question> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM Question WHERE id_tense=11 ", null);
        if (cursor != null && cursor.getCount() > 0) {
            if (cursor.moveToFirst()) {
                do {
                    Question quest = new Question();
                    quest.setID(cursor.getInt(0));
                    quest.setQUESTION(cursor.getString(1));
                    list.add(quest);
                } while (cursor.moveToNext());
            }
        }
        cursor.close();
        database.close();
        return list;

    }

    public List<Answer> getChoiceFu3() {
        database = openHelper.getReadableDatabase();
        List<Answer> ans = new ArrayList<>();
        Cursor cs = database.rawQuery("SELECT * FROM answer WHERE id_Question=11 ", null);
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
                } while (cs.moveToNext());
            }
        }
        cs.close();
        database.close();
        return ans;
    }*/

    public Score get_ScoreFu3() {
        database = openHelper.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT id_tense,point,MAX(date) FROM Point Where id_tense=11 ", null);
        // and point>=2
        if (cursor != null && cursor.getCount() > 0) {
            if (cursor.moveToFirst()) {
                Score ss = new Score();
                ss.setiD(cursor.getInt(0));
                ss.setScore(cursor.getInt(1));
                ss.setDateTime(cursor.getInt(2));
                cursor.close();
                database.close();
                return ss;
            }
        }
        return null;
    }

    public Score getScoreUnlockTest11() {
        database = openHelper.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT id_tense,MAX(point) FROM Point Where id_tense=11 ", null);
        if (cursor != null && cursor.getCount() > 0) {
            if (cursor.moveToFirst()) {
                Score ss = new Score();
                ss.setiD(cursor.getInt(0));
                ss.setScore(cursor.getInt(1));
                cursor.close();
                database.close();
                return ss;
            }
        }
        return null;
    }

    ////////////////////// Test Future Perfect Continuous  //////////////////////////////////

    public List<MixQuestAns> getTestFu4(){
        database = openHelper.getReadableDatabase();
        List<MixQuestAns> MIX = new ArrayList<>();
        Cursor cs = database.rawQuery("SELECT Question.question, answer.optA, answer.optB, answer.optC, answer.optD, answer.key " +
                " FROM Question\n" +
                "    INNER JOIN answer\n" +
                "    WHERE answer.id_answer=Question.id_question AND id_tense=12 \n" +
                "    ORDER BY RANDOM() LIMIT 10 ", null);
        if (cs != null && cs.getCount() > 0) {
            if (cs.moveToFirst()) {
                do {
                    MixQuestAns mix = new MixQuestAns();
                    mix.setMixQUESTION(cs.getString(0));
                    mix.setMixOPTA(cs.getString(1));
                    mix.setMixOPTB(cs.getString(2));
                    mix.setMixOPTC(cs.getString(3));
                    mix.setMixOPTD(cs.getString(4));
                    mix.setMixANSWER(cs.getString(5));
                    MIX.add(mix);
                } while (cs.moveToNext());
            }
        }
        cs.close();
        database.close();
        return MIX;
    }

    /*public List<Question> getTestFu4() {
        database = openHelper.getReadableDatabase();
        List<Question> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM Question WHERE id_tense=12 ", null);
        if (cursor != null && cursor.getCount() > 0) {
            if (cursor.moveToFirst()) {
                do {
                    Question quest = new Question();
                    quest.setID(cursor.getInt(0));
                    quest.setQUESTION(cursor.getString(1));
                    list.add(quest);
                } while (cursor.moveToNext());
            }
        }
        cursor.close();
        database.close();
        return list;

    }

    public List<Answer> getChoiceFu4() {
        database = openHelper.getReadableDatabase();
        List<Answer> ans = new ArrayList<>();
        Cursor cs = database.rawQuery("SELECT * FROM answer WHERE id_Question=12 ", null);
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
                } while (cs.moveToNext());
            }
        }
        cs.close();
        database.close();
        return ans;
    }*/

    public Score get_ScoreFu4() {
        database = openHelper.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT id_tense,point,MAX(date) FROM Point Where id_tense=12 ", null);
        // and point>=2
        if (cursor != null && cursor.getCount() > 0) {
            if (cursor.moveToFirst()) {
                Score ss = new Score();
                ss.setiD(cursor.getInt(0));
                ss.setScore(cursor.getInt(1));
                ss.setDateTime(cursor.getInt(2));
                cursor.close();
                database.close();
                return ss;
            }
        }
        return null;
    }

    public Score getScoreUnlockTest12() {
        database = openHelper.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT id_tense,MAX(point) FROM Point Where id_tense=12 ", null);
        if (cursor != null && cursor.getCount() > 0) {
            if (cursor.moveToFirst()) {
                Score ss = new Score();
                ss.setiD(cursor.getInt(0));
                ss.setScore(cursor.getInt(1));
                cursor.close();
                database.close();
                return ss;
            }
        }
        return null;
    }

    ////////////////////// Mix Test //////////////////////////////////
    public List<MixQuestAns> getMixQuestAns(){
        database = openHelper.getReadableDatabase();
        List<MixQuestAns> MIX = new ArrayList<>();
        Cursor cs = database.rawQuery("SELECT Question.question, answer.optA, answer.optB, answer.optC, answer.optD, answer.key " +
                " FROM Question\n" +
                "    INNER JOIN answer\n" +
                "    WHERE answer.id_answer=Question.id_question\n" +
                "    ORDER BY RANDOM() LIMIT 20 ", null);
        if (cs != null && cs.getCount() > 0) {
            if (cs.moveToFirst()) {
                do {
                    MixQuestAns mix = new MixQuestAns();
                    //mix.setMixID(cs.getInt(0));
                    mix.setMixQUESTION(cs.getString(0));
                    mix.setMixOPTA(cs.getString(1));
                    mix.setMixOPTB(cs.getString(2));
                    mix.setMixOPTC(cs.getString(3));
                    mix.setMixOPTD(cs.getString(4));
                    mix.setMixANSWER(cs.getString(5));
                    MIX.add(mix);
                } while (cs.moveToNext());
            }
        }
        cs.close();
        database.close();
        return MIX;
    }

    public Score get_ScoreMix() {
        database = openHelper.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT id_tense,point,MAX(date) FROM Point Where id_tense=14 ", null);
        // and point>=2
        if (cursor != null && cursor.getCount() > 0) {
            if (cursor.moveToFirst()) {
                Score ss = new Score();
                ss.setiD(cursor.getInt(0));
                ss.setScore(cursor.getInt(1));
                ss.setDateTime(cursor.getInt(2));
                cursor.close();
                database.close();
                return ss;
            }
        }
        return null;
    }


//+++++++++++++++++++++++++++++++++++++++++++++ Test Part (End) +++++++++++++++++++++++++++++++++++++++++++++++++++++++//

}
