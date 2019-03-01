package com.matchit.HeatingSection;

public class AC {

    //--
    protected int acID, positionID;
    protected int temp;




    // Constructor
    public AC() {

    }

    //Full Constructor
    public AC(int positionID, int temp) {
        this.positionID = positionID;
        this.temp = temp;

    }


    // Setter method
    public void setPositionID(int positionID) {
        this.positionID = positionID;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    public void setAcID(int acID) {
        this.acID = acID;
    }

    // Getter method

    public int getAcID() {
        return acID;
    }

    public int getPositionID() {
        return positionID;
    }

    public float getTemp() {
        return temp;
    }
}


