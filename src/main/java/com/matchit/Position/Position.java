package com.matchit.Position;

import com.matchit.DB_Connection.ConnectionConfig;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class Position {
    protected int positionID;
    protected String positionName;


    public Position() {

    }


    public Position(String positionName , int positionID) {
        super();
        this.positionID = positionID;
        this.positionName = positionName;
    }


    public String getPositionName() {
        return positionName;
    }


    public void setPositionName(String positionname) {
        positionName = positionname;
    }










    //Action Methods

    //     Add new Position to THe HOME
    public void addPosition(String positionName) {
        try {
            String addPositionQuery = "INSERT INTO [position] VALUES (?)";
            PreparedStatement ps = ConnectionConfig.prepareStatement(addPositionQuery);


            // 3. Set the parameters

            ps.setString(1, positionName);
            ps.executeUpdate();
            System.out.println("NewPosition inserted.");
            // display(r);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    //      Delet a POSITION FROM HOME Using  positionID
    public static void DeletePosirionByID(int positionID) {
        try {
            String sql = "Delete from [position] where positionID =? ";

            PreparedStatement ps = ConnectionConfig.prepareStatement(sql);
            // 3. Set the parameters

            ps.setInt(1, positionID);
            ps.executeUpdate();
            System.out.println("Position deleted.");
            // display(r);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


//        Delet a POSITION FROM HOME USING positionName

    public static void DeletePositionByName(String positionName) {
        try {
            String sql = "Delete from [position] where positionName =? ";

            PreparedStatement ps = ConnectionConfig.prepareStatement(sql);
            // 3. Set the parameters

            ps.setString(1, positionName);
            ps.executeUpdate();
            System.out.println("Position deleted.");
            // display(r);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void checkPosition() {

    }

    public boolean checkIfIsNoPosition() throws SQLException {
        String isNoPositionQuery = " SELECT * FROM [Position]";
        PreparedStatement isNoPositionStatement = ConnectionConfig.prepareStatement(isNoPositionQuery);
        ResultSet resultSetPosition = isNoPositionStatement.executeQuery();
        while(resultSetPosition.next()){
            return true;
        }
        if (!resultSetPosition.isBeforeFirst()){
            return false;
        }
      return false;
    }

    public int getPositionIDByName(String pName) throws SQLException {
        int positionId = 0 ;
        String positionIdQuery = "SELECT * FROM [Position] WHERE positionName = ?";
        PreparedStatement positionIdSt = ConnectionConfig.prepareStatement(positionIdQuery);
        positionIdSt.setString(1,pName);
        ResultSet posIdRs = positionIdSt.executeQuery();

        if (!posIdRs.isBeforeFirst()){
            System.out.println("Not able to find " + pName + "'s ID!");
        }
        while (posIdRs.next()){
            positionId = posIdRs.getInt("positionID");
            System.out.println(positionId);
        }

        return positionId;
    }




    public ArrayList<Position> bringPositionNames() throws SQLException {

        ArrayList<Position> positions = new ArrayList<>();

        String positionNamesQuery = "SELECT * FROM [Position]";
        PreparedStatement positionNamesSt = ConnectionConfig.prepareStatement(positionNamesQuery);
        ResultSet positionNameRs = positionNamesSt.executeQuery();


        if (!positionNameRs.isBeforeFirst()){
            System.out.println("No positions found! test");
        }
        while (positionNameRs.next()) {
            String posName = positionNameRs.getString("positionName");
            System.out.println(posName);
            int posId = positionNameRs.getInt("positionID");
            System.out.println(posId);
            Position myPosition = new Position(posName, posId);
            positions.add(myPosition);
        }


        return positions;


    }






}




