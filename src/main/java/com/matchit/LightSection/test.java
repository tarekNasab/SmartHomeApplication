package com.matchit.LightSection;

import com.matchit.Position.Position;

import java.sql.SQLException;

public class test {



    public static void main(String[] args) throws SQLException {

        Light newlig=new Light();
        newlig.bringLightColorByPositionName("Kitchen");
        newlig.bringStatueLightByPositionName("Kitchen");

//       double me= newlig.bringLightStatue(1);
//        System.out.println(me);


    }
}
