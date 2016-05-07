package com.mysoulmyc.android.appenglish.DB;

/**
 * Created by Toshiba on 25/3/2559.
 */
public class Score {
    private int sCORE;
    private int dATE;
    private int iD;
    private int dateMix;

    public Score(){
        sCORE = 0;
        dATE = 0;
        iD = 0;
        dateMix = 0;
    }

    public Score(Integer score, Integer date, Integer id,Integer datemix) {
        sCORE = score;
        dATE = date;
        iD = id;
        dateMix = datemix;
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
        dATE = date;
    }

    public int getDateMix() {
        return dateMix;
    }

    public void setDateMix(int dateMix) {
        this.dateMix = dateMix;
    }

    public int getiD(){
        return  iD;
    }

    public void setiD(int id) {
        iD = id;
    }

}
