package com.example.toshiba.appenglish.DB;

/**
 * Created by Toshiba on 12/4/2559.
 */
public class MixQuestAns {
    private int ID;
    private String QUESTION;
    private String OPTA;
    private String OPTB;
    private String OPTC;
    private String OPTD;
    private String ANSWER;

    public MixQuestAns() {
        ID = 0;
        QUESTION = "";
        OPTA = "";
        OPTB = "";
        OPTC = "";
        OPTD = "";
        ANSWER = "";
    }

    public MixQuestAns(Integer id, String qUESTION,String oPTA, String oPTB, String oPTC, String oPTD, String aNSWER) {

        ID = id;
        QUESTION = qUESTION;
        OPTA = oPTA;
        OPTB = oPTB;
        OPTC = oPTC;
        OPTD = oPTD;
        ANSWER = aNSWER;
    }

    public int getMixID() {
        return ID;
    }

    public String getMixQUESTION() {
        return QUESTION;
    }

   public String getMixOPTA() {
        return OPTA;
    }

    public String getMixOPTB() {
        return OPTB;
    }

    public String getMixOPTC() {
        return OPTC;
    }

    public String getMixOPTD() {
        return OPTD;
    }

    public String getMixANSWER() {
        return ANSWER;
    }

    public void setMixID(int id) {
        ID = id;
    }

    public void setMixQUESTION(String qUESTION) {
        QUESTION = qUESTION;
    }

   public void setMixOPTA(String oPTA) {
        OPTA = oPTA;
    }

    public void setMixOPTB(String oPTB) {
        OPTB = oPTB;
    }

    public void setMixOPTC(String oPTC) {
        OPTC = oPTC;
    }

    public void setMixOPTD(String oPTD) {
        OPTD = oPTD;
    }

    public void setMixANSWER(String aNSWER) {
        ANSWER = aNSWER;
    }

}
