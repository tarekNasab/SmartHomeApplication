package com.matchit.CurtainSection;

import com.matchit.DB_Connection.ConnectionConfig;
import com.matchit.Position.Position;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Curtain {

    protected int curtainId;
    protected int positionId;
    protected int curtainStatus;
    protected String curtainSide;


    Position positionObj = new Position();

    public Curtain() {

    }

    public Curtain(int curtainId, int positionId, int curtainStatus, String curtainSide) {
        this.curtainId = curtainId;
        this.positionId = positionId;
        this.curtainStatus = curtainStatus;
        this.curtainSide = curtainSide;
    }

    public int getCurtainId() {
        return curtainId;
    }



    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

    public int getCurtainStatus() {
        return curtainStatus;
    }

    public void setCurtainStatus(int curtainStatus) {
        this.curtainStatus = curtainStatus;
    }

    public String getCurtainSide() {
        return curtainSide;
    }

    public void setCurtainSide(String curtainSide) {
        this.curtainSide = curtainSide;
    }

    public void addCurtain(String positionName) throws SQLException {
        int positionId=positionObj.getPositionIDByName(positionName);
        String addCurtainQuery="INSERT INTO [curtain](positionID) VALUES( ? )";
        PreparedStatement addCurtainSt= ConnectionConfig.prepareStatement(addCurtainQuery);
        addCurtainSt.setInt(1,positionId);
        addCurtainSt.executeUpdate();
        System.out.println("New Curtain Added");
    }


    public  void RemoveCurtain(String positionName,String curtainSide) {
        try {
            String deletCurtainQuery = "Delete from [curtain] where positionId =? and curtainSide= ?";
             int positionId=positionObj.getPositionIDByName(positionName);
            PreparedStatement deletCurtainSt = ConnectionConfig.prepareStatement(deletCurtainQuery);
            // 3. Set the parameters

            deletCurtainSt.setInt(1,positionId);
            deletCurtainSt.setString(2,curtainSide);
            deletCurtainSt.executeUpdate();
            System.out.println("Curtain deleted.");
            // display(r);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    // TO BRING ALL CURTAINS IN THIS POSITION BY POSITION ID


    public ArrayList<Integer> bringCurtainIdbyPositionId(int positionId) throws SQLException {
        ArrayList<Integer>curtainList=new ArrayList<Integer>();
        int curtainId = 0;
        String bringCurtainQuery = "SELECT * FROM [curtain] WHERE positionId= ?";
        PreparedStatement bringCurtainPs = ConnectionConfig.prepareStatement(bringCurtainQuery);
        bringCurtainPs.setInt(1, positionId);
        ResultSet bringCurtainRs = bringCurtainPs.executeQuery();
        if (!bringCurtainRs.isBeforeFirst()) {
            System.out.println("Not able to find " + positionId + "'s Curtain Id!");
        }
        while (bringCurtainRs.next()) {
            curtainId = bringCurtainRs.getInt("curtainId");
            curtainList.add(curtainId);

        }

        return curtainList;
    }


    //TO BRING THE SIDE FOR EVERY CURTAIN BY CURTAIN ID


    public String bringCurtainSideByCurtainId(int curtainId) {
        String curtainSide;
        String curtainSideQuery = " SELECT curtainSide FROM [curtain] WHERE curtainId = ?";
        try {
            PreparedStatement bringCurtainSideST = ConnectionConfig.prepareStatement(curtainSideQuery);
            bringCurtainSideST.setInt(1, curtainId);
            ResultSet bringCurtainSideRs = bringCurtainSideST.executeQuery();
            while (bringCurtainSideRs.next()) {
                curtainSide = bringCurtainSideRs.getString("curtainSide");
                System.out.println(curtainSide);
                return curtainSide;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // TO BRING ALL SIDES OF THE CURTAINS IN THIS POSITION NAME


    public ArrayList<String> bringCurtainSideByPositionName(String positionName) throws SQLException {
        ArrayList<String>curtainList=new ArrayList<String>();
        int mypositionId = positionObj.getPositionIDByName(positionName);
        ArrayList<Integer> myCurtainId = this.bringCurtainIdbyPositionId(mypositionId);
        for (Integer curtainId:myCurtainId) {
            String CurtainSide = this.bringCurtainSideByCurtainId(curtainId);
            curtainList.add(CurtainSide);

        }

        return curtainList;

    }




    //TO BRING CURTAIN ID BY SIDE AND POSITION NAME...................I DID NOT USED YET   ??????
    public int bringCurtainIdBySideAndPositionName(String positionName,String curtainSide) throws SQLException {
        int curtainId;
        int positionId=positionObj.getPositionIDByName(positionName);
        String bringCurtainBySideAndPositionNameQuery="SELECT * FROM [curtain]WHERE positionId=? AND curtainSide=? ";
        PreparedStatement bringCurtainBySideAndPositionNameSt=ConnectionConfig.prepareStatement(bringCurtainBySideAndPositionNameQuery);
        bringCurtainBySideAndPositionNameSt.setInt(1,positionId);
        bringCurtainBySideAndPositionNameSt.setString(2,curtainSide);
        ResultSet Rs=bringCurtainBySideAndPositionNameSt.executeQuery();
        while (Rs.next()){
            curtainId=Rs.getInt("curtainId");

            return curtainId;


        }
        return 0;
    }


}
