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
    public Command () {

    }

    public Command( String commandLabel, String commandType) {

        this. CommandLabel = commandLabel;
        this.CommandType = commandType;
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

    public ArrayList<Command> getAllCommands(String commandType) throws SQLException {

        ArrayList<Command> commands = new ArrayList<>();

        String commandLabelQuery = "select * from [LightCommand]";
        PreparedStatement positionNamesSt = ConnectionConfig.prepareStatement(commandLabelQuery);
        ResultSet CommandLabelRs = positionNamesSt.executeQuery();

        while (CommandLabelRs.next()) {
            String commandLabel = CommandLabelRs.getString("commandLabel");
            System.out.println(commandLabel);

            int commandID = CommandLabelRs.getInt("commandID");
            System.out.println(commandID);

            String CommandType = CommandLabelRs.getString("commandType");

            Command myCommand = new Command(commandLabel, CommandType);
            commands.add(myCommand);
        }


        return commands;

    }

    //--------------------    Add Command   ------------------

    public void addCommand(String commandLabel, String commandType){
        try {
            String addCommandQuery = "INSERT INTO [Command] VALUES (?, ?)";
            PreparedStatement ps = ConnectionConfig.prepareStatement(addCommandQuery);



            ps.setString(1, commandLabel);
            ps.setString(2, commandType);
            ps.executeUpdate();
            System.out.println("New command inserted.");

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    // ------------------ Delete Command By CommandLabel --------------

    public static void DeleteCommandByLabel(String commandLabel) {
        try {
            String CommandQuery = "Delete from [Command] where commandLabel =? ";

            PreparedStatement ps = ConnectionConfig.prepareStatement(CommandQuery);


            ps.setString(1, commandLabel);
            ps.executeUpdate();
            System.out.println("Command  deleted.");

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
