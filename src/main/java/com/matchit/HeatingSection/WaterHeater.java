package com.matchit.HeatingSection;

public class WaterHeater {

    //--
    protected int waterHeaterID,positionID;
    protected float temp;

    // -------- No-arg-Constructor--------
    public WaterHeater(){

    }

    //---------Full-constructor--------
    public WaterHeater(int positionID, float temp){
        this.positionID = positionID;
        this.temp = temp;
    }





    //---------getter method---------
    public int getWaterHeaterID() {
        return waterHeaterID;
    }

    public int getPositionID() {
        return positionID;
    }

    public float getTemp() {
        return temp;
    }



    //-------- setter method----------

    public void setPositionID(int positionID) {
        this.positionID = positionID;
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }




}
