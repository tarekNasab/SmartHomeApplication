package com.matchit.LightSection;

import com.matchit.DB_Connection.ConnectionConfig;
import com.matchit.Position.Position;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Light {

    //Fields
    protected int lightId, positionId;
    protected Status status;
    protected LightColor lightColor;
    protected Position position;


    Position positionObj = new Position();


    //Constructors


    public int getLightId() {
        return lightId;
    }

    public void setLightId(int lightId) {
        this.lightId = lightId;
    }

    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LightColor getLightColor() {
        return lightColor;
    }

    public void setLightColor(LightColor lightColor) {
        this.lightColor = lightColor;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }




    //Methods/Actions


    public void addLightToPosition(String postionName) throws SQLException {
        int myPositionId = positionObj.getPositionIDByName(postionName);
        String addLightByPositionId = "INSERT INTO [Light](positionID) VALUES( ? )";
        PreparedStatement addLightSt = ConnectionConfig.prepareStatement(addLightByPositionId);

        addLightSt.setInt(1, myPositionId);

        addLightSt.executeUpdate();



    }
}
