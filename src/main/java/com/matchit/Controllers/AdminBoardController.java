package com.matchit.Controllers;

import com.matchit.Position.Position;
import com.matchit.User.Admin;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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
    private Pane rightPaneAddPosition;

    @FXML
    private ImageView adminLogo;

    @FXML
    private VBox leftPane;

    @FXML
    private Pane rootPanAdmin;

    @FXML
    private Button addUserButton;

    @FXML
    private Button homePlanButton;

    @FXML
    private Button addPositionButton;

    @FXML
    private Pane rightPaneSetupHome;

    @FXML
    private Pane seperator;

    @FXML
    private Pane rightPaneAddUser;

    @FXML
    private Button addButton;
    @FXML
    private Button addNewPositionB;
    @FXML
    private TextField newPositionName;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        rightPaneAddUser.setVisible(false);
        rightPaneSetupHome.setVisible(false);
        rightPaneAddPosition.setVisible(false);

    }



    @FXML
    public void setUpHomeAction(ActionEvent setupAction){

        rightPaneAddUser.setVisible(false);
        rightPaneAddPosition.setVisible(false);
        rightPaneSetupHome.setVisible(true);
    }

    @FXML
    public void addUserAction(ActionEvent addUserAction){
        rightPaneAddPosition.setVisible(false);
        rightPaneSetupHome.setVisible(false);
        rightPaneAddUser.setVisible(true);
    }

    @FXML
    public void addPositionVeiw(ActionEvent addPositionAction){
        rightPaneSetupHome.setVisible(false);
        rightPaneAddUser.setVisible(false);
        rightPaneAddPosition.setVisible(true);
    }


    @FXML
    public void addPositionAction(ActionEvent addPositionEvent){
        String positionName = newPositionName.getText();
        position.addPosition(positionName);
    }

//    @FXML
//    public void addUserAction(ActionEvent newUser) {
//
//            String name, email, password;
//
//            name = userFnameEdit.getText().toString();
//            email = userEmailEdit.getText().toString();
//            password = userPassEdit.getText().toString();
//
//
//            if (!name.equalsIgnoreCase("") & !email.equalsIgnoreCase("") & !password.equalsIgnoreCase("")){
//                admin.addNewUser(name,email,password);
//            }
//
//            else if (email.equalsIgnoreCase("") || password.equalsIgnoreCase("") || email.equalsIgnoreCase("")){
//
//                System.out.println("Incomplete info!");
//            }
//    }

    }

