package com.matchit.Controllers;

import com.matchit.User.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
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
import java.util.ArrayList;
import java.util.ResourceBundle;

public class DashBoardUserController implements Initializable {

    ObservableList<MenuItem> profileMenuItems = FXCollections.observableArrayList();
    User user = new User();

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
    public Pane infoBoxPane;
    @FXML
    public Label profileNameInfoL;
    @FXML
    public Label profileMailInfoL;
    @FXML
    public Label yourIndformationLabel;
    @FXML
    public Pane topBanner;
    @FXML
    public MenuButton profileMenuB;
    @FXML
    public Label welcome;
    @FXML
    public Pane changeEmailBodyPane;
    @FXML
    public TextField newEmailText;
    @FXML
    public Button saveEmailButton;
    @FXML
    public Pane changeNameBodyPane;
    @FXML
    public TextField newNameText;
    @FXML
    public Button saveNameButton;
    @FXML
    public Pane changePassBodyPane;
    @FXML
    public TextField newPassText;
    @FXML
    public Button savePassButton;
    @FXML
    public Label emailUpdatedLabel;

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
        profileBodyPane.setVisible(false);
        rightSidePanProfile.setVisible(true);
    }


    public void setActionsMenuProfile(MenuButton menuButton) {


        menuButton.getItems().clear();
        profileMenuItems.removeAll();


        MenuItem showProfile = new MenuItem("My profile");
        MenuItem editName = new MenuItem("Change my name");
        MenuItem editEmail = new MenuItem("Change my email");
        MenuItem editPass = new MenuItem("Change my password");

        showProfile.setOnAction(event -> {
            changeEmailBodyPane.setVisible(false);
            changeNameBodyPane.setVisible(false);
            changePassBodyPane.setVisible(false);
            profileBodyPane.setVisible(true);
            try {
                this.showProfileInfoLabels();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        });
        editEmail.setOnAction(event -> {
            changeNameBodyPane.setVisible(false);
            changePassBodyPane.setVisible(false);
            profileBodyPane.setVisible(false);
            changeEmailBodyPane.setVisible(true);

        });

        editPass.setOnAction(event -> {
            changeNameBodyPane.setVisible(false);
            profileBodyPane.setVisible(false);
            changeEmailBodyPane.setVisible(false);
            changePassBodyPane.setVisible(true);

        });

        editName.setOnAction(event -> {
            profileBodyPane.setVisible(false);
            changeEmailBodyPane.setVisible(false);
            changePassBodyPane.setVisible(false);
            changeNameBodyPane.setVisible(true);

        });

        profileMenuItems.addAll(showProfile, editEmail, editName, editPass);
        menuButton.getItems().addAll(profileMenuItems);
    }


    public void showProfileInfoLabels() throws SQLException {

        infoBoxPane.setVisible(true);
        profileMailInfoL.setVisible(true);
        profileNameInfoL.setVisible(true);
        profileNameInfoL.setText("Name:   " + LogInController.getInctance().userName());
        profileMailInfoL.setText("E-mail: " + LogInController.getInctance().email());

    }

    public void updateUserEmailAction(ActionEvent updateEmailEvent) throws SQLException {
        String oldEmail = LogInController.getInctance().email();
        String newEmail = newEmailText.getText();
        user.updateEmail(newEmail, oldEmail);
        emailUpdatedLabel.setText("Your E-mail has been updated!");

    }

    public void updateUserNameAction(ActionEvent updateNameEvent) throws SQLException {
        String email  = LogInController.getInctance().email();
        String newName = newNameText.getText();
        user.updateName(newName, email);
    }

    public void updateUserPasswordAction(ActionEvent updatePassEvent) throws SQLException {
        String email  = LogInController.getInctance().email();
        String newPass = newPassText.getText();
        user.updatePass(newPass, email);
    }
}
