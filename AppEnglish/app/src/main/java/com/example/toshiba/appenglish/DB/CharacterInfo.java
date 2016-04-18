package com.example.toshiba.appenglish.DB;

/**
 * Created by Toshiba on 12/4/2559.
 */
public class CharacterInfo {
    private int ID;
    private String NAME;
    private int SEX;
    private int DATE;
    private int LEVEL;
    private int DATEUSE;

    public CharacterInfo(){
        ID = 0;
        NAME = "";
        SEX = 0;
        DATE = 0;
        LEVEL = 0;
        DATEUSE = 0;
    }

    public CharacterInfo(Integer id, String name,Integer sex,Integer date,Integer level,Integer dateuse){
        ID = id;
        NAME = name;
        SEX = sex;
        DATE = date;
        LEVEL = level;
        DATEUSE = dateuse;
    }

    public int getID(){
        return ID;
    }

    public void setID(int id){
        ID = id;
    }

    public String getName(){
        return NAME;
    }

    public void setNAME(String name){
        NAME = name;
    }

    public int getSEX(){
        return SEX;
    }

    public void setSEX(int sex){
        SEX = sex;
    }

    public int getDATE(){
        return DATE;
    }

    public void setDATE(int date){
        DATE = date;
    }

    public int getLEVEL(){
        return LEVEL;
    }

    public void setLEVEL(int level){
        LEVEL = level;
    }

    public int getDATEUSE(){
        return DATEUSE;
    }

    public void setDATEUSE(int dateuse){
        DATEUSE = dateuse;
    }
}
