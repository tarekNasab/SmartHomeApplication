package com.matchit.Controllers;

import com.matchit.User.User;
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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class LogInController implements Initializable {

    User user = new User();

    public static LogInController inctance;

    public LogInController() {
        inctance = this;
    }

    public static LogInController getInctance(){
        return inctance;
    }





    @FXML
    private ImageView passPng;

    @FXML
    private ImageView userPng;

    @FXML
    private AnchorPane loginBK;


    @FXML
    private Label liginAdmin;

    @FXML
    private Button loginB;


    @FXML
    private TextField emailEdit;


    @FXML
    private PasswordField passwordEdit;


    @FXML
    public void logInAction(ActionEvent logInEvent) throws IOException, SQLException {

        String email = emailEdit.getText();
        String password = passwordEdit.getText();

        user.logInUser(email, password);


        Parent homePage = FXMLLoader.load(getClass().getResource("/fxml/DashboardUser.fxml"));
        Scene homePageScene = new Scene(homePage);
        Stage appStage = (Stage) ((Node) logInEvent.getSource()).getScene().getWindow();
        appStage.setScene(homePageScene);
        appStage.show();
    }


    @FXML
    public void logInAdminAction(MouseEvent adminEvent) throws IOException {
        Parent homePage = FXMLLoader.load(getClass().getResource("/fxml/LogInAsAdminForum.fxml"));
        Scene homePageScene = new Scene(homePage);
        Stage appStage = (Stage) ((Node) adminEvent.getSource()).getScene().getWindow();
        appStage.setScene(homePageScene);
        appStage.show();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }



    public  String userName() throws SQLException {
        String userName = user.getUserNameByEmail(emailEdit.getText());
        return userName ;
    }
}
