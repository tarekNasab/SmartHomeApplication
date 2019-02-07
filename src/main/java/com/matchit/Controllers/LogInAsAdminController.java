package com.matchit.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class LogInAsAdminController implements Initializable {

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




}
