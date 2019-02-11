package com.matchit.DB_Connection;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionConfig {

    private static java.sql.Connection myConnection = null;
    private static PreparedStatement myStatement = null;
    private static ResultSet myResult = null;

    static {
        try {


            String url = "jdbc:sqlserver://localhost:1433;databaseName=SmartHomeDB;user=sa;password=massa1991";


            myConnection = DriverManager.getConnection(url);
            System.out.println("Connected to SmartHomeDB!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void setAutoCommit(boolean state) throws SQLException {
        myConnection.setAutoCommit(state);

    }

    public static void commit() throws SQLException {
        myConnection.commit();
    }

    public static void rollback() throws SQLException {
        myConnection.rollback();
    }

    public static PreparedStatement prepareStatement(String statement) throws SQLException {
        myStatement = myConnection.prepareStatement(statement);
        return myStatement;
    }

    public static ResultSet executeQuery() throws SQLException {
        return myStatement.executeQuery();
    }

    public static void executeUpdate() throws SQLException {
        myStatement.executeUpdate();
    }


}
