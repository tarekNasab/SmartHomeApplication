package com.matchit.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DashBoardUserController implements Initializable {

    ObservableList<MenuItem> profileMenuItems = FXCollections.observableArrayList();

    @FXML
    public AnchorPane dbBK;
    @FXML
    public Label cosumizeLabel;
    @FXML
    public ToggleButton autoModeOn;
    @FXML
    public ImageView dashboardLogo;
    @FXML
    public Pane rightSidePanBoard;
    @FXML
    public GridPane imageGridView;
    @FXML
    public Button heatingButton;
    @FXML
    public Button securityButton;
    @FXML
    public Button lightButton;
    @FXML
    public Button kitchenButton;
    @FXML
    public Label dashboard;
    @FXML
    public Button profileAvatar;
    @FXML
    public Label goBackLabel;
    @FXML
    public Pane rightSidePanProfile;
    @FXML
    public Pane profileBodyPane;
    @FXML
    public Pane topBanner;
    @FXML
    public MenuButton profileMenuB;
    @FXML
    public Label welcome;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        setActionsMenuProfile(profileMenuB);
        rightSidePanProfile.setVisible(false);
        rightSidePanBoard.setVisible(false);

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

    public void setWelcomUser(String user) {
        this.welcome.setText("Welcome," + " " + user);
    }

    public void onDashBoardShowRightPane(MouseEvent showBoardPaneEvent) {
        rightSidePanProfile.setVisible(false);
        rightSidePanBoard.setVisible(true);

    }

    public void showProfilePane(MouseEvent showProfileEvent) {
        rightSidePanBoard.setVisible(false);
        rightSidePanProfile.setVisible(true);
    }


    public void setActionsMenuProfile(MenuButton menuButton) {


        menuButton.getItems().clear();
        profileMenuItems.removeAll();


        MenuItem showProfile = new MenuItem("My profile");
        MenuItem editName = new MenuItem("Change my name");
        MenuItem editEmail = new MenuItem("Change my email");

        profileMenuItems.addAll(showProfile, editEmail, editName);
        menuButton.getItems().addAll(profileMenuItems);
    }
}
