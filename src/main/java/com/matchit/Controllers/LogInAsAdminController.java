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

    @FXML
    private Label notVaildInfo;
    @FXML
    private Label notVaildInfo2;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        notVaildInfo.setVisible(false);
        notVaildInfo2.setVisible(false);

    }


    @FXML
    public void goBackToLogin(MouseEvent goBackEvent) throws IOException {
        Parent homePage = FXMLLoader.load(getClass().getResource("/fxml/logInForum.fxml"));
        Scene homePageScene = new Scene(homePage);
        Stage appStage = (Stage) ((Node) goBackEvent.getSource()).getScene().getWindow();
        appStage.setScene(homePageScene);
        appStage.show();

    }

    @FXML
    public void logInAdmainAction(ActionEvent logInEvent) throws SQLException, IOException {
        String email=adminUserName.getText();
        String password=adminPassword.getText();


        boolean loggedIn = admin.logInAdmain(email, password);



        if (loggedIn){
              Parent homePage = FXMLLoader.load(getClass().getResource("/fxml/AdminBoard.fxml"));
              Scene homePageScene = new Scene(homePage);
              Stage appStage = (Stage) ((Node) logInEvent.getSource()).getScene().getWindow();
              appStage.setScene(homePageScene);
              appStage.show();}
        else if (!loggedIn){

            notVaildInfo.setVisible(true);
            notVaildInfo2.setVisible(true);



        }


          }


    }



