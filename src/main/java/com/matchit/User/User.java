package com.matchit.User;

import com.matchit.DB_Connection.ConnectionConfig;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class User {
    String userF_Name;
    String user_email;
    String user_password;


    //Constructors

    public User() {};
    public User(String userF_Name, String user_email, String user_password) {
        this.userF_Name = userF_Name;
        this.user_email = user_email;
        this.user_password = user_password;
    }



    //Getters and Setters

    public String getUserF_Name() {
        return userF_Name;
    }

    public String getUser_email() {
        return user_email;
    }

    public String getUser_password() {
        return user_password;
    }



    //

    public void setUserF_Name(String userF_Name) {
        this.userF_Name = userF_Name;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }









    //ToString

    @Override
    public String toString() {
        return "User{" +
                "userF_Name='" + userF_Name + '\'' +
                ", user_email='" + user_email + '\'' +
                ", user_password='" + user_password + '\'' +
                '}';
    }





    //Action methods

    public boolean logInUser(String enteredEmail , String eneteredPass) throws SQLException {

        String logInQuery = "SELECT * FROM [user] WHERE email = ? AND password = ?" ;
        PreparedStatement logInStatement = ConnectionConfig.prepareStatement(logInQuery);

        logInStatement.setString(1 , enteredEmail);
        logInStatement.setString(2 , eneteredPass);

        ResultSet userInfoSet = logInStatement.executeQuery();
        ResultSetMetaData userInfoSetMD = userInfoSet.getMetaData();



        if (userInfoSet.next()){
            return true;
        }

        else if (!userInfoSet.isBeforeFirst()){
            System.out.println("User can not log in");
            return false;
        }
        return false;
    }

    public String getUserNameByEmail(String userLogInEmail) throws SQLException {

        String userName= "";
        String bringUserName = "SELECT * FROM [user] WHERE email = ?";

        PreparedStatement bringUserNameSt = ConnectionConfig.prepareStatement(bringUserName);
        bringUserNameSt.setString(1, userLogInEmail );
        ResultSet userNameResult = bringUserNameSt.executeQuery();
        if (!userNameResult.isBeforeFirst()){
            System.out.println("no user found");
        }
        while (userNameResult.next()){
            userName = userNameResult.getString("name");
        }

        System.out.println(userName);
        return userName;
    }
}
