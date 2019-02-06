package com.matchit.Position;

import com.matchit.DB_Connection.ConnectionConfig;

import java.sql.PreparedStatement;
import java.sql.SQLException;




public class PositionInHome {
    protected int positionID;
    protected String positionName;



    public PositionInHome(){

    }


    public PositionInHome(int positionID, String positionName) {
        super();
        this.positionID = positionID;
        this.positionName = positionName;
    }



    public String getPositionName() {
        return positionName;
    }



    public void setPositionName(String positionName) {
        positionName = positionName;
    }



    public int getPositionID() {
        return positionID;
    }


/*
          Add new Position to THe HOME
 */

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


    /*
      Delet a POSITION FROM HOME Using  positionID
     */

     public static void DeleteUsingPosirionID(int positionID) {
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

    /*
        Delet a POSITION FROM HOME USING positionName
     */


    public static void DeleteUsingPositionName(String positionName) {
        try {
            String sql = "Delete from [position] where positionName =? ";

            PreparedStatement ps = ConnectionConfig.prepareStatement(sql);
            // 3. Set the parameters

            ps.setString(1,positionName);
            ps.executeUpdate();
            System.out.println("Position deleted.");
            // display(r);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void checkPosition(){

    }

}




