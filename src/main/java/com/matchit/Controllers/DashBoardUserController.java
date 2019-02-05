package com.matchit.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class DashBoardUserController implements Initializable {



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

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


}
