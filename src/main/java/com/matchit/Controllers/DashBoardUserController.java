package com.matchit.Controllers;

import com.matchit.Commands.Command;
import com.matchit.LightSection.Light;
import com.matchit.Position.Position;
import com.matchit.User.User;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class DashBoardUserController implements Initializable {

    ObservableList<String> choicOfPositions = FXCollections.observableArrayList();
    ObservableList<MenuItem> profileMenuItems = FXCollections.observableArrayList();
    ObservableList<MenuItem> choicCommandMenuItems = FXCollections.observableArrayList();
    ObservableList<HBox> hBoxes = FXCollections.observableArrayList();
    ArrayList<Command> commands = new ArrayList<Command>();
    User user = new User();
    Position position = new Position();
    Light light = new Light();
    static String value;


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
    public Label emailUpdatedLabel;
    @FXML
    public Pane changeNameBodyPane;
    @FXML
    public TextField newNameText;
    @FXML
    public Button saveNameButton;
    @FXML
    public Pane changePassBodyPane;
    @FXML
    public Button savePassButton;
    @FXML
    public PasswordField newPassText;
    @FXML
    public Pane rightSideLightControlPane;
    @FXML
    public Pane ChoosePositionPane;
    @FXML
    public ChoiceBox choosePositionBox;
    @FXML
    public Pane StatuesPane;
    @FXML
    public Label lightStatuesLabel;
    @FXML
    public Pane ccommandPane;
    @FXML
    public MenuButton chooseCommandMenu;
    @FXML
    public Label updatedStatueLabel;
    @FXML
    public ScrollPane ScrollPaneLightList;
    @FXML
    public Pane PaneToScrollLight;
    @FXML
    public VBox insidePaneVBox;


    @FXML
    public Label statuShow;
    @FXML
    public Button showLights;
    @FXML
    public Label statuShowUpdate;
    @FXML
    public Label colorShow;
    @FXML
    public Label colorShowUpdate;



    @Override
    public void initialize(URL location, ResourceBundle resources) {

        setActionsMenuProfile(profileMenuB);
        rightSidePanProfile.setVisible(false);
        rightSidePanBoard.setVisible(false);
        rightSideLightControlPane.setVisible(false);

        try {
            setWelcomUser(LogInController.getInctance().userName());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            laodPositionChoiceData(choosePositionBox);
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        setActionsCommandMenuItems(chooseCommandMenu);


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
        rightSideLightControlPane.setVisible(false);
        rightSidePanBoard.setVisible(true);


    }

    public void showProfilePane(MouseEvent showProfileEvent) {
        rightSidePanBoard.setVisible(false);
        profileBodyPane.setVisible(false);
        rightSideLightControlPane.setVisible(false);
        rightSidePanProfile.setVisible(true);
    }

    public void setActionsCommandMenuItems(MenuButton menuButton) {
        menuButton.getItems().clear();
        choicCommandMenuItems.removeAll();
        MenuItem turnOn = new MenuItem("Turn On Light");
        MenuItem turnOf = new MenuItem("Turn Of Light");
        MenuItem autoModeLight = new MenuItem("Auto Mode");
        MenuItem increasStrength = new MenuItem("+");
        MenuItem discreasStrength = new MenuItem("-");
        choicCommandMenuItems.addAll(turnOn, turnOf, autoModeLight, increasStrength, discreasStrength);
        menuButton.getItems().addAll(choicCommandMenuItems);
        turnOn.setOnAction(event -> {
            System.out.println("mmm");


        });
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
        String email = LogInController.getInctance().email();
        String newName = newNameText.getText();
        user.updateName(newName, email);
    }

    public void updateUserPasswordAction(ActionEvent updatePassEvent) throws SQLException {
        String email = LogInController.getInctance().email();
        String newPass = newPassText.getText();
        user.updatePass(newPass, email);
    }


//    public void laodPositionChoiceData(MenuButton menuButton) throws SQLException {
//        choicOfPositions.removeAll();
//        ArrayList<Position> allPositions = position.bringPositionNames();
//        for (Position position: allPositions) {
//            String posName = position.getPositionName();
//            MenuItem myItem= new MenuItem(posName);
//            choicOfPositions.addAll(myItem);
//        }
//        menuButton.getItems().addAll(choicOfPositions);
//    }


    public void showLightControllerPane(ActionEvent showControllerPane) {
        rightSidePanProfile.setVisible(false);
        rightSideLightControlPane.setVisible(false);
        rightSidePanBoard.setVisible(false);
        rightSideLightControlPane.setVisible(true);
    }


    public void laodPositionChoiceData(ChoiceBox<String> choosePositionBox) throws SQLException {
        choicOfPositions.removeAll();
        ArrayList<Position> allPositions = position.bringPositionNames();
        for (Position position : allPositions) {
            String posName = position.getPositionName();
            choicOfPositions.addAll(posName);

        }
        choosePositionBox.getItems().addAll(choicOfPositions);
    }


    public String getChoicOfPositions(ChoiceBox<String> choiceBox) {
        String chosenPosition = choiceBox.getValue();
        return chosenPosition;
    }

    public void veiwAllLightsInScrollPane(String chosenPosition) throws SQLException {
        hBoxes.removeAll();
        hBoxes.clear();
        insidePaneVBox.getChildren().clear();

        ArrayList<Light> lights = light.bringAllLightsList(chosenPosition);


        for (Light light : lights) {

            HBox newHbox = new HBox(createLabel(chosenPosition + String.valueOf(light.getLightId()), 60, 20), createColorPicker(light.getLightId()), createSlider(light.getLightId()));
            newHbox.setPrefWidth(565);
            newHbox.setSpacing(40);
            hBoxes.addAll(newHbox);
            insidePaneVBox.getChildren().addAll(newHbox);

        }


    }


    public void showLights() throws SQLException {
        String chosenPos = getChoicOfPositions(choosePositionBox);

        veiwAllLightsInScrollPane(chosenPos);


    }


    private Label createLabel(String txt, double w, double h) {
        Label label = new Label(txt);
        label.setMinWidth(w);
        label.setMinHeight(h);
        return label;
    }

    private Button createButton(String bText, double w, double h) {
        Button button = new Button();
        button.setText(bText);
        button.setMaxWidth(w);
        button.setMaxHeight(h);
        return button;
    }

    private Slider createSlider(int lightId) {
        Slider slider = new Slider();

        // The minimum value.
        slider.setMin(0);

        // The maximum value.
        slider.setMax(1);

        // Current value
        slider.setValue(.5);

        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);

        slider.setBlockIncrement(0.1);

        slider.valueProperty().addListener(new ChangeListener<Number>() {

            @Override
            public void changed(ObservableValue<? extends Number> observable, //
                                Number oldValue, Number newValue) {

                try {
                    light.saveLightStatuInDB(newValue, lightId);
                    statuShowUpdate.setText("Light statu updated!");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                statuShow.setText(newValue.toString());



            }
        });
        return slider;
    }

    public ColorPicker createColorPicker(int lightId) {


        ColorPicker colorPicker = new ColorPicker();


        colorPicker.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                Color color = colorPicker.getValue();
                int colorInt = color.hashCode();

                String colorString = Integer.toHexString(colorInt);
                System.out.println(colorString);

                try {

                    light.saveLightColorInDb(colorString, lightId);
                    colorShow.setText(color.toString());
                    colorShowUpdate.setText("Color changed!");

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });


        return colorPicker;
    }


    public void setPositionOfHbox(int yPostitionOfPreviousHbox) {

    }

    public void setHBOxToPane() {

        hBoxes.clear();
        PaneToScrollLight.getChildren().addAll(hBoxes);
    }

}
