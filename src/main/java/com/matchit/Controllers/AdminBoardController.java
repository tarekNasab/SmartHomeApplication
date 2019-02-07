package com.matchit.Controllers;

import com.matchit.Position.Position;
import com.matchit.User.Admin;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminBoardController implements Initializable {
    Admin admin =new Admin();  //  Instance of Admin
    Position position=new Position();


    @FXML
    public Pane rootPanAdmin;
    @FXML
    public VBox leftPane;
    @FXML
    public Button addUserButton;
    @FXML
    public Button homePlanButton;
    @FXML
    public Button addPositionButton;
    @FXML
    public ImageView adminLogo;
    @FXML
    public Pane seperator;
    @FXML
    public Pane rightPaneSetupHome;
    @FXML
    public Pane rightPaneAddPosition;
    @FXML
    public Label positionNameLabel;
    @FXML
    public Pane rightPaneAddUser;
    @FXML
    public TextField newUserNameAdmin;
    @FXML
    public TextField newUserEmailadmin;
    @FXML
    public PasswordField newUserPassAdmin;
    @FXML
    public Button addNewUserAdminB;
    @FXML
    public TextField newPositionName;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        rightPaneAddUser.setVisible(false);
        rightPaneSetupHome.setVisible(false);
        rightPaneAddPosition.setVisible(false);

    }



    @FXML
    public void setUpHomeActionView(ActionEvent setupAction){
        rightPaneAddUser.setVisible(false);
        rightPaneAddPosition.setVisible(false);
        rightPaneSetupHome.setVisible(true);

    }

    @FXML
    public void addUserActionVeiw(ActionEvent addUserAction){
        rightPaneAddPosition.setVisible(false);
        rightPaneSetupHome.setVisible(false);
        rightPaneAddUser.setVisible(true);    }

    @FXML
    public void addPositionVeiw(ActionEvent addPositionAction){
        rightPaneSetupHome.setVisible(false);
        rightPaneAddUser.setVisible(false);
        rightPaneAddPosition.setVisible(true);
    }

    @FXML
    public void addPositionAction(ActionEvent addPositionAction){

        String positionName;
        positionName=newPositionName.getText().toString();
        position.addPosition(positionName);




    }


    @FXML
    public void addUserAction(ActionEvent newUser) {

            String name, email, password;

            name = newUserNameAdmin.getText();
            email = newUserEmailadmin.getText();
            password = newUserPassAdmin.getText();


            if (!name.equalsIgnoreCase("") & !email.equalsIgnoreCase("") & !password.equalsIgnoreCase("")){
                admin.addNewUser(name,email,password);
            }

            else if (email.equalsIgnoreCase("") || password.equalsIgnoreCase("") || name.equalsIgnoreCase("")){

                System.out.println("Incomplete info!");   //Todo Set a label next to the text field with incomplete info red msg on v2
            }
    }

    }

