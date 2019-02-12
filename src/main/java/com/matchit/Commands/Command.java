package com.matchit.Commands;

import com.matchit.DB_Connection.ConnectionConfig;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Command {

    private int CommandID;
    private String CommandLabel;
    private String CommandType;


    // Constructors
    public Command() {

    }

    public Command(String commandLabel, int commandID, String commandType) {

        this.CommandLabel = commandLabel;
        this.CommandType = commandType;
        this.CommandID = commandID;
    }

    // Set method
    public void setCommand_Label(String commandLabel) {
        CommandLabel = commandLabel;
    }


    // Get method
    public String getCommand_Label() {
        return CommandLabel;
    }


    // -----------------   Get All Commands  ------------------

    public ArrayList<String> getAllCommands(String commandType) throws SQLException {

        ArrayList<String> commands = new ArrayList<>();

        String commandLabelQuery = "SELECT * FROM [Command] WHERE commandType = ? ";
        PreparedStatement bringCommandsST = ConnectionConfig.prepareStatement(commandLabelQuery);

        ResultSet CommandLabelRs = bringCommandsST.executeQuery();
        bringCommandsST.setString(1,commandType);
        while (CommandLabelRs.next()) {

            String myCommand = CommandLabelRs.getString("commandLabel");
            commands.add(myCommand);

        }


        return commands;

    }



}
