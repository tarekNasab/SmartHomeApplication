package com.matchit.Controllers;

import com.matchit.User.Admin;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class LogInAsAdminController implements Initializable {
    Admin admin=new Admin();

    public static LogInAsAdminController inctance;

    public LogInAsAdminController() {
        inctance = this;
    }

    public static LogInAsAdminController getInctance(){
        return inctance;
    }

    @FXML
    public TextField adminUserName;
    @FXML
    public PasswordField adminPassword;
    @FXML
    public Button logInAdminButton;
    @FXML
    public Label goBackLabel;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


    @FXML
    public void logInAdmainAction(ActionEvent logInEvent) throws SQLException, IOException {
        String email=adminUserName.getText().toString();
        String password=adminPassword.getText().toString();

            admin.logInAdmain(email, password);



              Parent homePage = FXMLLoader.load(getClass().getResource("/fxml/AdminBoard.fxml"));
              Scene homePageScene = new Scene(homePage);
              Stage appStage = (Stage) ((Node) logInEvent.getSource()).getScene().getWindow();
              appStage.setScene(homePageScene);
              appStage.show();


          }


    }



