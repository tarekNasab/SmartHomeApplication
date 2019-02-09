package com.matchit.Controllers;

import com.matchit.LightSection.Light;
import com.matchit.Position.Position;
import com.matchit.User.Admin;
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
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AdminBoardController implements Initializable {
    Admin admin = new Admin();  //  Instance of Admin
    Position position = new Position();
    Light light = new Light();
    ObservableList<String> choicOfPositions = FXCollections.observableArrayList();


    @FXML
    public Pane rootPanAdmin;
    @FXML
    public VBox leftPane;
    @FXML
    public Button addUserButton;
    @FXML
    public Button homePlanButton;
    @FXML
    public Button addPositionButton;
    @FXML
    public ImageView adminLogo;
    @FXML
    public Pane seperator;
    @FXML
    public Pane rightPaneSetupHome;
    @FXML
    public Button lightsButtonAdmin;
    @FXML
    public Pane rightPaneAddPosition;
    @FXML
    public Label positionNameLabel;
    @FXML
    public TextField newPositionName;
    @FXML
    public Pane rightPaneAddUser;
    @FXML
    public TextField newUserNameAdmin;
    @FXML
    public TextField newUserEmailadmin;
    @FXML
    public PasswordField newUserPassAdmin;
    @FXML
    public Button addNewUserAdminB;
    @FXML
    public Label goBack;
    @FXML
    public Pane rightPanLightBoard;
    @FXML
    public Button addLightB;
    @FXML
    public Button removeLightB;
    @FXML
    public Button customizeLightByPositionB;
    @FXML
    public Button customizeLightByIdB;
    @FXML
    public Button viewAllLightsB;
    @FXML
    public Label noPositionLabel;
    @FXML
    public Pane rightPaneAddLightPane;
    @FXML
    public ChoiceBox<String> choosePositionBox;
    @FXML
    public Button addLightAfterChoose;
    @FXML
    public Label printSuccessMsg;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        rightPaneAddUser.setVisible(false);
        rightPaneSetupHome.setVisible(false);
        rightPaneAddPosition.setVisible(false);
        noPositionLabel.setVisible(false);
        rightPanLightBoard.setVisible(false);
        rightPaneAddLightPane.setVisible(false);
        try {
            laodPositionChoiceData();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    @FXML
    public void setUpHomeActionView(ActionEvent setupAction) {
        rightPanLightBoard.setVisible(false);
        rightPaneAddUser.setVisible(false);
        rightPaneAddPosition.setVisible(false);
        rightPaneSetupHome.setVisible(true);

    }

    @FXML
    public void addUserActionVeiw(ActionEvent addUserAction) {
        rightPanLightBoard.setVisible(false);
        rightPaneAddPosition.setVisible(false);
        rightPaneSetupHome.setVisible(false);
        rightPaneAddUser.setVisible(true);
    }

    @FXML
    public void addPositionVeiw(ActionEvent addPositionAction) {
        rightPanLightBoard.setVisible(false);
        rightPaneSetupHome.setVisible(false);
        rightPaneAddUser.setVisible(false);
        rightPaneAddPosition.setVisible(true);
    }

    @FXML
    public void addPositionAction(ActionEvent addPositionAction) {

        String positionName;
        positionName = newPositionName.getText();
        position.addPosition(positionName);


    }


    @FXML
    public void GoBackLabelAction(MouseEvent adminEvent) throws IOException {
        Parent homePage = FXMLLoader.load(getClass().getResource("/fxml/LogInAsAdminForum.fxml"));
        Scene homePageScene = new Scene(homePage);
        Stage appStage = (Stage) ((Node) adminEvent.getSource()).getScene().getWindow();
        appStage.setScene(homePageScene);

        appStage.show();


    }

    @FXML
    public void addUserAction(ActionEvent newUser) {

        String name, email, password;

        name = newUserNameAdmin.getText();
        email = newUserEmailadmin.getText();
        password = newUserPassAdmin.getText();


        if (!name.equalsIgnoreCase("") & !email.equalsIgnoreCase("") & !password.equalsIgnoreCase("")) {
            admin.addNewUser(name, email, password);
        } else if (email.equalsIgnoreCase("") || password.equalsIgnoreCase("") || name.equalsIgnoreCase("")) {

            System.out.println("Incomplete info!");   //Todo Set a label next to the text field with incomplete info red msg on v2
        }
    }


    public void addLightAction(ActionEvent addLightEvent) throws SQLException {

        rightPanLightBoard.setVisible(false);
        choosePositionBox.setVisible(false);
        addLightAfterChoose.setVisible(false);
        rightPaneAddLightPane.setVisible(true);

        boolean isNoPosition = position.checkIfIsNoPosition();
        if (!isNoPosition) {
            noPositionLabel.setVisible(true);
            noPositionLabel.setText("No positions found in Database!");
        }
        if (isNoPosition) {
            noPositionLabel.setVisible(false);
            choosePositionBox.setVisible(true);
            addLightAfterChoose.setVisible(true);





        }

    }

    public void addLightAfterChooseAction(ActionEvent addEvent) throws SQLException {
        String positionNameToAddLight = getChoicOfPositions(choosePositionBox).toString();
//        printSuccessMsg.setText(positionNameToAddLight);
            System.out.println(positionNameToAddLight);
            light.addLightToPosition(positionNameToAddLight);
            printSuccessMsg.setText("Light has been added to " + positionNameToAddLight);

    }
    public void onLightsAction(ActionEvent clickOnLightsEvent) {

        rightPaneAddUser.setVisible(false);
        rightPaneSetupHome.setVisible(false);
        rightPaneAddPosition.setVisible(false);
        noPositionLabel.setVisible(false);
        rightPanLightBoard.setVisible(true);


    }


    public void laodPositionChoiceData() throws SQLException {
        choicOfPositions.removeAll();
        ArrayList<Position> allPositions = position.bringPositionNames();
        for (Position position: allPositions) {
            String posName = position.getPositionName();
            choicOfPositions.addAll(posName);

        }
        choosePositionBox.getItems().addAll(choicOfPositions);
    }



    public String getChoicOfPositions(ChoiceBox<String> choiceBox){
        String chosenPosition = choiceBox.getValue();
        return chosenPosition;
    }

}

