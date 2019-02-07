package com.matchit.User;

import com.matchit.DB_Connection.ConnectionConfig;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class Admin {

    String userName, password;

    //


    //Add new user to the system

    public void addNewUser(String name,String email,String password){
        try {


            String addUserQuery = "INSERT INTO [user](name, email, password) VALUES( ? , ?, ?)";

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



    public void logInAdmain(String enteredEmail , String eneteredPass) throws SQLException {

        String logInQueryAd = "SELECT * FROM [admain] WHERE email = ? AND password = ?" ;
        PreparedStatement logInStatement = ConnectionConfig.prepareStatement(logInQueryAd);

        logInStatement.setString(1 , enteredEmail);
        logInStatement.setString(2 , eneteredPass);

        ResultSet admainInfoSet = logInStatement.executeQuery();
        ResultSetMetaData admainInfoSetMD = admainInfoSet.getMetaData();



        if (admainInfoSet.next()){
            System.out.println("admain can log in");
        }

        else if (!admainInfoSet.isBeforeFirst()){
            System.out.println("admain can not log in");
        }
    }

    }





