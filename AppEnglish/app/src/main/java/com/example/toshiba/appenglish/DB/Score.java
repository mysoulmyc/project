package com.example.toshiba.appenglish.DB;

/**
 * Created by Toshiba on 25/3/2559.
 */
public class Score {
    private int sCORE;
    private int dATE;
    private int iD;

    public Score(){
        sCORE = 0;
        dATE = 0;
        iD = 0;
    }

    public Score(Integer score, Integer date, Integer id) {
        sCORE = score;
        dATE = date;
        iD = id;
    }


    public int getScore() {
        return sCORE;
    }

    public void setScore(int score) {
        sCORE = score;
    }

    public int getDate(){
        return dATE;
    }

    public void setDateTime(int date) {
        /*SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        Date date = new Date();
        return dateFormat.format(date);*/
        dATE = date;
    }

    public int getiD(){
        return  iD;
    }

    public void setiD(int id) {
        iD = id;
    }

}
