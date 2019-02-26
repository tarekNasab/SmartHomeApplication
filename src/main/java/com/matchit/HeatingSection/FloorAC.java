package com.matchit.HeatingSection;

public class FloorAC {

    //--
    protected int FloorAcID, positionID;
    protected float temp;


    //--------- NO-arg-Constructor-------------
    public FloorAC(){

    }


    //---------- Full-Constructor--------
    public FloorAC(int positionID, float temp){
        this.positionID = positionID;
        this.temp = temp;
    }


    //---------- getter method ------------
    public int getFloorAcID() {
        return FloorAcID;
    }

    public int getPositionID() {
        return positionID;
    }

    public float getTemp() {
        return temp;
    }


    // ---------- setter method ----------
    public void setPositionID(int positionID) {
        this.positionID = positionID;
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }


}
