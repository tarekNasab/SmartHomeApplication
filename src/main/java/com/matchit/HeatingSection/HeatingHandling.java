package com.matchit.HeatingSection;

import com.matchit.DB_Connection.ConnectionConfig;
import com.matchit.Position.Position;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class HeatingHandling {

    Position positionObj = new Position();




    //----------- To Add AC To Position------

    public void addAcToPosition(String postionName) throws SQLException {
        String addAcQuery = "INSERT INTO [AC] (PositionID, Temp) VALUES (?, ?)";
        PreparedStatement AddAcSt = ConnectionConfig.prepareStatement(addAcQuery);
        AddAcSt.setInt(1, positionObj.getPositionIDByName(postionName));
        AddAcSt.setInt(2, 0);
        AddAcSt.executeUpdate();
        System.out.println("Inserted!");



    }

    //------------ Insert FloorAc To Position ---------

    public void addFloorAcToPosition(String positionName) throws SQLException {
        String addFloorAcQuery = "INSERT INTO [FloorAc] (PositionID, Temp) VALUES (?, ?)";
        PreparedStatement AddFloorAcSt = ConnectionConfig.prepareStatement(addFloorAcQuery);
        AddFloorAcSt.setInt(1, positionObj.getPositionIDByName(positionName));
        AddFloorAcSt.setInt(2,0);
        AddFloorAcSt.executeUpdate();
        System.out.println("FloorAc Inserted!");
    }


    //------------ Insert WaterHeater To Position----------

    public void addWaterHeatingToPosition(String positionName) throws SQLException {
        String addWaterHeatergQuery = "INSERT INTO [WaterHeater] (PositionID, Temp) VALUES (?, ?)";
        PreparedStatement AddWaterHeaterSt = ConnectionConfig.prepareStatement(addWaterHeatergQuery);
        AddWaterHeaterSt.setInt(1, positionObj.getPositionIDByName(positionName));
        AddWaterHeaterSt.setInt(2, 0);
        AddWaterHeaterSt.executeUpdate();
        System.out.println("WaterHeater Inserted!");

    }

    //----------- get AcID using positionName -------
    public int bringAcIDByPositionName(String positionName) throws SQLException {
        int AcID = 0;
        String ACIdQuery = "SELECT (AcID) FROM [AC] WHERE PositionID = ?";
        PreparedStatement getAcIdSt = ConnectionConfig.prepareStatement(ACIdQuery);
        getAcIdSt.setInt(1, positionObj.getPositionIDByName(positionName));
        ResultSet posIdRs = getAcIdSt.executeQuery();

        while(posIdRs.next()){

            AcID = posIdRs.getInt("AcID");

        }
        return AcID;
    }

    // ----------





}
