package com.matchit.LightSection;

import com.matchit.Controllers.DashBoardUserController;
import com.matchit.Position.Position;

import java.sql.SQLException;
import java.util.ArrayList;

public class test {


    public static void main(String[] args) throws SQLException {

        Light newlig = new Light();
//        newlig.bringLightColorByPositionName("Kitchen");
//        newlig.bringStatueLightByPositionName("Kitchen");
//        System.out.println(newlig)

//       double me= newlig.bringLightStatue(1);
//        System.out.println(me);


        DashBoardUserController ds = new DashBoardUserController();
        ArrayList<Light> lights = newlig.bringAllLightsList("Livingroom");
        for (Light light: lights ) {

            System.out.println("LightId = "+ light.getLightId());
            System.out.println("positionId = "+ light.getPositionId());
        }

    }
//
//        Position position = new Position();
//        System.out.println(position.getPositionIDByName("Livingroom"));

    }

