package com.matchit.EntryPoint;

import com.matchit.LightSection.Light;
import com.matchit.Position.Position;

import java.sql.SQLException;

public class MainToTest {
    public static void main(String[] args) throws SQLException {


        Position pos = new Position();
        pos.getPositionIDByName("Kitchen");
//        Light light = new Light();
//
//        try {
//            light.addLightToPosition("Kitchen");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        int s = pos.getPositionIDByName("Balcone");
        System.out.println(s + "here");
    }
}
