package com.example.toshiba.appenglish.DB;

/**
 * Created by Toshiba on 25/3/2559.
 */
public class Score {
    private int sCORE;

    public Score(){
        sCORE = 0;
    }

    public Score(Integer score) {

        sCORE = score;
    }

    public int getScore() {
        return sCORE;
    }

    public void setScore(int score) {
        sCORE = score;
    }
}
