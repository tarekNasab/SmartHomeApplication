package com.matchit.Position;

import com.matchit.DB_Connection.ConnectionConfig;

import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Position {
    protected String positionName;


    public Position() {

    }


    public Position(String positionName) {
        super();
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
    public static void AddtPosition(String positionName) {
        try {
            String sql = "insert into [position] (positionName) ";
            sql += " values (?)";
            PreparedStatement ps = ConnectionConfig.prepareStatement(sql);


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

    public static void checkPosition() {

    }

}




