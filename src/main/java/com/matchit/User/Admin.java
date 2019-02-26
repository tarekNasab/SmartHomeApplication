package com.matchit.User;

import com.matchit.DB_Connection.ConnectionConfig;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class Admin {

    String email, password;

    public Admin() {
    }

    public Admin(String email) {
        this.email = email;
        this.password= password;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

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



    public boolean logInAdmain(String enteredEmail , String eneteredPass) throws SQLException {

        String logInQueryAd = "SELECT * FROM [admin] WHERE email = ? AND password = ?" ;
        PreparedStatement logInStatement = ConnectionConfig.prepareStatement(logInQueryAd);

        logInStatement.setString(1 , enteredEmail);
        logInStatement.setString(2 , eneteredPass);

        ResultSet admainInfoSet = logInStatement.executeQuery();
        ResultSetMetaData admainInfoSetMD = admainInfoSet.getMetaData();



        if (admainInfoSet.next()){
            System.out.println("user can log in");

            return true;
        }

        else if (!admainInfoSet.isBeforeFirst()){
            System.out.println("admain can not log in");
            return false;
        }

        return false;
    }


}





