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
import java.net.URL;
import java.util.ResourceBundle;


public class AdminBoardController implements Initializable {

    Admin admin = new Admin();


    @FXML
    public Pane rootPanAdmin;
    @FXML
    public AnchorPane addNewUserB;
    @FXML
    public PasswordField userPassEdit;
    @FXML
    public TextField userEmailEdit;
    @FXML
    public TextField userFnameEdit;
    @FXML
    public Button addUserB;




    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    public void addUserAction(ActionEvent addUser){

        Button button = new Button();
        String name, email, password;
        name = userFnameEdit.getText().toString();
        email = userEmailEdit.getText().toString();
        password = userPassEdit.getText().toString();
        admin.addNewUser(name,email,password);

    }






}
