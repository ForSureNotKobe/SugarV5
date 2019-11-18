package com.example.sugarv5.Profile;

public class ProfileData {

    private int mUpperSugarLvl;
    private int mLowerSugarLvl;

    public ProfileData(int UpperSugarLvl, int LowerSugarLvl){
        mUpperSugarLvl = UpperSugarLvl;
        mLowerSugarLvl = LowerSugarLvl;
    }

    public int getUpperSugarLvl(){
        return mUpperSugarLvl;
    }

    public int getLowerSugarLvl(){
        return mLowerSugarLvl;
    }

    public void setUpperSugarLvl(int newUpper) {this.mUpperSugarLvl = newUpper;}

    public void setLowerSugarLvl(int newLower) {this.mLowerSugarLvl = newLower;}
}
