package com.matchit.HeatingSection;

import com.matchit.DB_Connection.ConnectionConfig;
import com.matchit.Position.Position;


import java.rmi.activation.ActivationID;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
        ArrayList<AC> AllAc = new ArrayList<>();
        String ACIdQuery = "SELECT * FROM [AC] WHERE PositionID = ?";
        PreparedStatement getAcSt = ConnectionConfig.prepareStatement(ACIdQuery);
        getAcSt.setInt(1, positionObj.getPositionIDByName(positionName));


        ResultSet posIdRs = getAcSt.executeQuery();

        while(posIdRs.next()){

            AcID = posIdRs.getInt("AcID");
            System.out.println("AcID = " + AcID);


        }
        return AcID;
    }

    // ---------- Update temp for ac ---------
    public void saveAcTemp(int Temp, int AcId) throws SQLException {

        String UpdateQuery = "UPDATE [AC] SET Temp = ? WHERE AcID = ?";
        PreparedStatement AcSt = ConnectionConfig.prepareStatement(UpdateQuery);
        AcSt.setInt(1, AcId);
        AcSt.setInt(2, Temp);
        AcSt.executeUpdate();
        System.out.println("Ac Temp updated !");
    }

    //---------- update temp for floorAc ----------
    public void saveFloorAcTemp(int Temp, int AcId) throws SQLException {
        String updateQuery = "UPDATE [FloorAC] SET Temp = ? WHERE AcID = ?";
        PreparedStatement FloorAcSt = ConnectionConfig.prepareStatement(updateQuery);
        FloorAcSt.setInt(1,Temp );
        FloorAcSt.setInt(2, AcId);
        FloorAcSt.executeUpdate();
        System.out.println("FloorAc Temp updated !");
    }

    //--------- update temp for waterHeater ----------
    public void saveWaterHeaterTemp(int Temp, int AcId) throws SQLException {
        String updateQuery = "UPDATE [WaterHeater] SET Temp = ? WHERE WaterHeaterID = ?";
        PreparedStatement WaterHeaterSt = ConnectionConfig.prepareStatement(updateQuery);
        WaterHeaterSt.setInt(1, Temp);
        WaterHeaterSt.setInt(2, AcId);
        WaterHeaterSt.executeUpdate();
        System.out.println("WaterHeater temp updated !");
    }



}
