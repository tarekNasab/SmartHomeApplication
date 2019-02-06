package com.matchit.Controllers;

import com.matchit.User.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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
import java.sql.SQLException;

public class LogInController {


    User user = new User();


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

        String email = emailEdit.getText().toString();
        String password = passwordEdit.getText().toString();

        user.logInUser(email, password);


//        Parent homePage = FXMLLoader.load(getClass().getResource("/fxml/DashboardUser.fxml"));
//        Scene homePageScene = new Scene(homePage);
//        Stage appStage = (Stage) ((Node) logInEvent.getSource()).getScene().getWindow();
//        appStage.setScene(homePageScene);
//        appStage.show();
    }

    @FXML
    public void logInAdminAction(MouseEvent adminEvent) throws IOException {
        Parent homePage = FXMLLoader.load(getClass().getResource("/fxml/AdminBoard.fxml"));
        Scene homePageScene = new Scene(homePage);
        Stage appStage = (Stage) ((Node) adminEvent.getSource()).getScene().getWindow();
        appStage.setScene(homePageScene);
        appStage.show();

    }
}
