package com.matchit.Controllers;

import com.matchit.User.Admin;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminBoardController implements Initializable {
    Admin admin =new Admin();  //  Instance of Admin


    @FXML
    public Pane rootPanAdmin;
    @FXML
    public VBox leftPane;
    @FXML
    public Button addUserButton;
    @FXML
    public Button homePlanButton;
    @FXML
    public Pane seperator;
    @FXML
    public Pane rightPaneAddUser;
    @FXML
    public Pane rightPaneSetupHome;
    @FXML
    public Button planHomeB;



    @Override
    public void initialize(URL location, ResourceBundle resources) {

        rightPaneAddUser.setVisible(false);
        rightPaneSetupHome.setVisible(false);

    }



    @FXML
    public void setUpHomeAction(ActionEvent setupAction){

        rightPaneSetupHome.setVisible(true);
    }

    @FXML
    public void addUserAction(ActionEvent addUserAction){
        rightPaneSetupHome.setVisible(false);

        rightPaneAddUser.setVisible(true);
    }



//
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

