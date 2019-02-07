package com.matchit.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DashBoardUserController implements Initializable {



    @FXML
    private Label welcome;
    @FXML
    private Button securityButton;

    @FXML
    private Label cosumizeLabel;

    @FXML
    private GridPane imageGridView;

    @FXML
    private Button kitchenButton;

    @FXML
    private ImageView profile;

    @FXML
    private Pane rightSidePan;

    @FXML
    private AnchorPane dbBK;

    @FXML
    private ToggleButton autoModeOn;

    @FXML
    private Button heatingButton;

    @FXML
    private Button lightButton;

    @FXML
    private ToggleButton autoModeOff;
    @FXML
    private Label goBackLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            setWelcomUser(LogInController.getInctance().userName());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void goBackToLogIn(MouseEvent goBackEvent) throws IOException {
        Parent homePage = FXMLLoader.load(getClass().getResource("/fxml/logInForum.fxml"));
        Scene homePageScene = new Scene(homePage);
        Stage appStage = (Stage) ((Node) goBackEvent.getSource()).getScene().getWindow();
        appStage.setScene(homePageScene);
        appStage.show();

    }

    public void setWelcomUser( String user){
         this.welcome.setText("Welcome," + " "+ user);
    }


}
