package com.matchit.LightSection;

import com.matchit.DB_Connection.ConnectionConfig;
import com.matchit.Position.Position;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Light {

    //Fields
    protected int lightId, positionId;
    protected double status;
    protected String lightColor;
//    protected Position position;


    Position positionObj = new Position();


    public Light(int lightId, int positionId, double status, String lightColor, Position position) {
        this.lightId = lightId;
        this.positionId = positionId;
        this.status = status;
        this.lightColor = lightColor;
//        this.position = position;

    }

    public Light() {

    }

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

    public double getStatus() {
        return status;
    }

    public void setStatus(double status) {
        this.status = status;
    }

    public String getLightColor() {
        return lightColor;
    }

    public void setLightColor(String lightColor) {
        this.lightColor = lightColor;
    }

    //    public Position getPosition() {
//        return position;
//    }
//
//    public void setPosition(Position position) {
//        this.position = position;
//    }


    //Methods/Actions


    public void addLightToPosition(String postionName) throws SQLException {
        int myPositionId = positionObj.getPositionIDByName(postionName);
        String addLightByPositionId = "INSERT INTO [Light](positionID) VALUES( ? )";
        PreparedStatement addLightSt = ConnectionConfig.prepareStatement(addLightByPositionId);

        addLightSt.setInt(1, myPositionId);

        addLightSt.executeUpdate();


    }


    public int selectLightIDByPositionID(int positionId) throws SQLException {
        int lightId = 0;
        String selectLightQuery = "SELECT * FROM [Light] WHERE positionID= ?";
        PreparedStatement selectLightPs = ConnectionConfig.prepareStatement(selectLightQuery);
        selectLightPs.setInt(1, positionId);
        ResultSet R = selectLightPs.executeQuery();
        if (!R.isBeforeFirst()) {
            System.out.println("Not able to find " + positionId + "'s lightId!");
        }
        while (R.next()) {
            lightId = R.getInt("lightId");
            System.out.println(lightId);
        }

        return lightId;
    }

    public double bringStatueLightByPositionName(String positionName) throws SQLException {
        int myPositionId = positionObj.getPositionIDByName(positionName);
        int myligtId = this.selectLightIDByPositionID(myPositionId);
        double lightStatue = this.bringLightStatueByLightId(myligtId);
        return lightStatue;

    }

    public String bringLightColorByPositionName(String positionName) throws SQLException {
        int mypositionId = positionObj.getPositionIDByName(positionName);
        int myligtId = this.selectLightIDByPositionID(mypositionId);
        String lightColor = this.bringLightColorByLightId(myligtId);
        return lightColor;

    }


    public ArrayList<Light> bringAllLightsList(String positionName) throws SQLException {
        ArrayList<Light> lights = new ArrayList<>();
        int positionId = positionObj.getPositionIDByName(positionName);
        String bringLightsQuery = "SELECT * FROM [Light] WHERE positionID= ? ";
        PreparedStatement lightsPs = ConnectionConfig.prepareStatement(bringLightsQuery);
        lightsPs.setInt(1, positionId);
        ResultSet lightsRs = lightsPs.executeQuery();

        if (!lightsRs.isBeforeFirst()) {
            System.out.println("There are no lights in " + positionName);

        }

        while (lightsRs.next()) {

            int lightId = lightsRs.getInt("lightID");
            String color = lightsRs.getString("color");
            double status = lightsRs.getDouble("status");

            Light light = new Light();
            light.setLightId(lightId);
            light.setLightColor(color);
            light.setStatus(status);

            lights.add(light);

        }

        return lights;
    }

    public double bringLightStatueByLightId(int lightId) {
        double lightStatue;

        String bringlightStatueQuery = " SELECT status FROM [Light] WHERE lightId = ?";

        try {
            PreparedStatement bringLightStatuePS = ConnectionConfig.prepareStatement(bringlightStatueQuery);
            bringLightStatuePS.setDouble(1, lightId);
            ResultSet bringLightStatueRs = bringLightStatuePS.executeQuery();
            while (bringLightStatueRs.next()) {
                lightStatue = bringLightStatueRs.getDouble("status");
                System.out.println(lightStatue);
                return lightStatue;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return Double.parseDouble(null);
    }


    public String bringLightColorByLightId(int lightId) {
        String lightColor;
        String lightColorQuery = " SELECT lightColor FROM [Light] WHERE lightId = ?";
        try {
            PreparedStatement bringlightColorST = ConnectionConfig.prepareStatement(lightColorQuery);
            bringlightColorST.setInt(1, lightId);
            ResultSet bringLightColorRs = bringlightColorST.executeQuery();
            while (bringLightColorRs.next()) {
                lightColor = bringLightColorRs.getString("lightColor");
                System.out.println(lightColor);
                return lightColor;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }


    public void saveLightColorInDb(String colorString, int  lightId) throws SQLException {

        String saveColorQ = "Update [Light] SET color=? WHERE lightID = ?";
        PreparedStatement saveColorPs = ConnectionConfig.prepareStatement(saveColorQ);
        saveColorPs.setString(1, colorString);
        saveColorPs.setInt(2, lightId);

        saveColorPs.executeUpdate();
        System.out.println("colorUpdated");
    }

    public void saveLightStatuInDB(Number newValue, int lightId) throws SQLException {

        double statu= newValue.doubleValue();
        String saveStatuQ = "UPDATE [Light] SET status = ? WHERE lightID = ?";
        PreparedStatement saveStatuPs = ConnectionConfig.prepareStatement(saveStatuQ);
        saveStatuPs.setDouble(1, statu);
        saveStatuPs.setInt(2, lightId);
        saveStatuPs.executeUpdate();




    }
}