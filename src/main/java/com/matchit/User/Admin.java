package com.matchit.User;

import com.matchit.DB_Connection.ConnectionConfig;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Admin {

    String userName, password;

    //


    //Add new user to the system

    public void addNewUser(String name,String email,String password){
        try {


            String addUserQuery = "INSERT INTO [user](Name, email, password) VALUES( ? , ?, ?)";

            PreparedStatement ps = ConnectionConfig.prepareStatement(addUserQuery);


            // 3. Set the parameters

            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, password);
            ps.executeUpdate();
            System.out.println("NewUser inserted.");
            // display(r);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    }





