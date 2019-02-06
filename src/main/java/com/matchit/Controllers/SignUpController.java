package com.matchit.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

import static javafx.application.Application.launch;

public class SignUpController implements Initializable {
    @FXML
    private AnchorPane BK;

    @FXML
    private AnchorPane singUpBK;

    @FXML
    private TextField nameSignUp;

    @FXML
    private TextField emailSignUp;

    @FXML
    private TextField passSignUp;

    @FXML
    private Button signUpB;




    public void SignUpButton() {


        signUpB.setOnAction(event -> {
            String name, email, password;

            name = nameSignUp.getText().toString();
            email=emailSignUp.getText().toString();
            password=passSignUp.getText().toString();
            System.out.println(name+email+password);
        });


    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


}
