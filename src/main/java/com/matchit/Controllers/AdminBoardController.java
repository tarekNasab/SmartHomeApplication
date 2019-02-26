package com.matchit.Controllers;

import com.matchit.HeatingSection.HeatingHandling;
import com.matchit.LightSection.Light;
import com.matchit.LightSection.Status;
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
    HeatingHandling heatingHandling = new HeatingHandling();
    ObservableList<String> choicOfPositions = FXCollections.observableArrayList();
    ObservableList<String> choicOfPositionsForAddAc = FXCollections.observableArrayList();
    ObservableList<String> choicOfPositionsForRemoveAc = FXCollections.observableArrayList();
    ObservableList<String> choicOfPositionsForAddFloorAc = FXCollections.observableArrayList();
    ObservableList<String> choicOfPositionsForRemoveFloorAc = FXCollections.observableArrayList();
    ObservableList<String> choicOfPositionsForAddWaterHeater = FXCollections.observableArrayList();



    Status status= new Status();

    public void setStatus(){
        status.strenght = 1.22f;
    }

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
    public Button HeatingButtonAdmin;
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
    public Pane rightPaneAddLightPane;
    @FXML
    public Label noPositionLabel;
    @FXML
    public ChoiceBox<String> choosePositionBox;
    @FXML
    public Button addLightAfterChoose;
    @FXML
    public Label printSuccessMsg;
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
    public Pane rightPanHeatingBoard;
    @FXML
    public VBox HeatingVBox;
    @FXML
    public Button AddAcB;
    @FXML
    public Button AddFloorAcB;
    @FXML
    public Button AddWaterHeaterB;
    @FXML
    public Button CustomizeB;
    @FXML
    public Pane AddAcPane;
    @FXML
    public ChoiceBox<String> AcChoiceBoxToAdd;
    @FXML
    public ChoiceBox<String> AcChoiceBoxToRemove;
    @FXML
    public Button addAcButton;
    @FXML
    public Button RemoveAcButton;
    @FXML
    public Label printAcAddedMsg;
    @FXML
    public Pane FloorAcPane;
    @FXML
    public ChoiceBox<String> ChoiceBoxForAddF;
    @FXML
    public ChoiceBox<String> ChoiceBoxForRemoveF;
    @FXML
    public Label FloorAcAddMsg;
    @FXML
    public Pane WaterHeaterPane;
    @FXML
    public ChoiceBox<String> AddHeaterChoiceBox;
    @FXML
    public Label AddHeaterMsg;






    @Override
    public void initialize(URL location, ResourceBundle resources) {

        rightPaneAddUser.setVisible(false);
        rightPaneSetupHome.setVisible(false);
        rightPaneAddPosition.setVisible(false);
        noPositionLabel.setVisible(false);
        rightPanLightBoard.setVisible(false);
        rightPaneAddLightPane.setVisible(false);
        try {
            lodPositionChoiceForAddWaterHeater();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            laodPositionChoiceForAddFloorAc();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            laodPositionChoiceForRemoveAc();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            laodPositionChoiceForAddAc();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            laodPositionChoiceData();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    @FXML
    public void setUpHomeActionView(ActionEvent setupAction) {
        rightPaneAddLightPane.setVisible(false);
        rightPanLightBoard.setVisible(false);
        rightPaneAddUser.setVisible(false);
        rightPaneAddPosition.setVisible(false);
        rightPaneSetupHome.setVisible(true);
        rightPanHeatingBoard.setVisible(false);
        AddAcPane.setVisible(false);
        FloorAcPane.setVisible(false);
        WaterHeaterPane.setVisible(false);




    }

    @FXML
    public void addUserActionVeiw(ActionEvent addUserAction) {
        rightPaneAddLightPane.setVisible(false);
        rightPanLightBoard.setVisible(false);
        rightPaneAddPosition.setVisible(false);
        rightPaneSetupHome.setVisible(false);
        rightPaneAddUser.setVisible(true);
    }

    @FXML
    public void addPositionVeiw(ActionEvent addPositionAction) {
        rightPaneAddLightPane.setVisible(false);
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
        String positionNameToAddLight = getChoicOfPositions(choosePositionBox);
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

    //----------- Get positions for add ac ----------
    public void laodPositionChoiceForAddAc() throws SQLException {
        choicOfPositionsForAddAc.removeAll();
        ArrayList<Position> allPositions = position.bringPositionNames();
        for (Position position: allPositions) {
            String posName = position.getPositionName();
            choicOfPositionsForAddAc.addAll(posName);

        }
        AcChoiceBoxToAdd.getItems().addAll(choicOfPositionsForAddAc);
    }

    // --------------- Get positions for add floorAc---------
    public void laodPositionChoiceForAddFloorAc() throws SQLException {
        choicOfPositionsForAddFloorAc.removeAll();
        ArrayList<Position> allPositions = position.bringPositionNames();
        for (Position position: allPositions) {
            String posName = position.getPositionName();
            choicOfPositionsForAddFloorAc.addAll(posName);

        }
        ChoiceBoxForAddF.getItems().addAll(choicOfPositionsForAddFloorAc);
    }




    //---------- get position for remove ac---------
    public void laodPositionChoiceForRemoveAc() throws SQLException {
        choicOfPositionsForRemoveAc.removeAll();
        ArrayList<Position> allPositions = position.bringPositionNames();
        for (Position position: allPositions) {
            String posName = position.getPositionName();
            choicOfPositionsForRemoveAc.addAll(posName);
            //TODO we need to know how we will do that.

        }
        AcChoiceBoxToRemove.getItems().addAll(choicOfPositionsForRemoveAc);
    }

    //-------- Get position for add waterHeater----------
    public void lodPositionChoiceForAddWaterHeater() throws SQLException {
        choicOfPositionsForAddWaterHeater.removeAll();
        ArrayList<Position> allPositions = position.bringPositionNames();
        for(Position position: allPositions) {
            String posName = position.getPositionName();
            choicOfPositionsForAddWaterHeater.addAll(posName);
        }
        AddHeaterChoiceBox.getItems().addAll(choicOfPositionsForAddWaterHeater);
    }

    //---------- Add ac after choice position----------
    public void AddAcButtonAction(ActionEvent addEvent) throws SQLException {
        String positionNameToAddAc = getChoicOfPositions(AcChoiceBoxToAdd);

        System.out.println(positionNameToAddAc + " Alaa tested");
        heatingHandling.addAcToPosition(positionNameToAddAc);
        printAcAddedMsg.setText("AC has been added to " + positionNameToAddAc);
        //TODO just one FloorAc in the room.

    }

    // ------------Add floorAc after choice position---------

    public void AddFloorAcButtonAction(ActionEvent addFloorAcEvent) throws SQLException {

        String positionNameToAddFloorAc = getChoicOfPositions(ChoiceBoxForAddF);

        heatingHandling.addFloorAcToPosition(positionNameToAddFloorAc);
        FloorAcAddMsg.setText("FloorAc has been added to " + positionNameToAddFloorAc);
    }


    // --------- addWaterHeater after choice position-----------
    public void addWaterHeaterButtonAction(ActionEvent addWaterHeater) throws SQLException {
        String positionNameToAddWaterHeater = getChoicOfPositions(AddHeaterChoiceBox);

        heatingHandling.addWaterHeatingToPosition(positionNameToAddWaterHeater);

        AddHeaterMsg.setText("WaterHeater has been added to " + positionNameToAddWaterHeater);
    }





    public String getChoicOfPositions(ChoiceBox<String> choiceBox){
        String chosenPosition = choiceBox.getValue();
        return chosenPosition;


    }

    public void onHeatingAction(ActionEvent clickOnHeatingEvent){

        rightPaneAddUser.setVisible(false);
        rightPaneSetupHome.setVisible(false);
        rightPaneAddPosition.setVisible(false);
        noPositionLabel.setVisible(false);
        rightPanLightBoard.setVisible(false);
        rightPanHeatingBoard.setVisible(true);

    }

    public void onAddWaterHeaterAction(ActionEvent WaterHeaterEvent){
        WaterHeaterPane.setVisible(true);
        rightPanHeatingBoard.setVisible(false);
    }


    public void onAddAcButtonAction(){
        AddAcPane.setVisible(true);
        rightPanHeatingBoard.setVisible(false);
    }

    public void onAddFloorAcButtonAction(){

        FloorAcPane.setVisible(true);
        rightPanHeatingBoard.setVisible(false);


    }

}

