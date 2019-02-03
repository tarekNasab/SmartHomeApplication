package com.matchit;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.sun.xml.internal.ws.resources.SenderMessages;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class GetStartedController implements Initializable {


    @FXML
    private Button get_started;


    @FXML
    private ImageView smart_bk;

    @FXML
    private ProgressBar progressBar;




    @Override
    public void initialize(URL url, ResourceBundle rb) {


    }

    @FXML
    public void getStartedAction(ActionEvent userEvent) throws IOException {


        // transaction to Dashboard page when you click the button.
        Parent homePage = FXMLLoader.load(getClass().getResource("/fxml/logInForum.fxml"));
        Scene homePageScene = new Scene(homePage);
        Stage appStage = (Stage) ((Node) userEvent.getSource()).getScene().getWindow();
        appStage.setScene(homePageScene);
        appStage.show();
        //--------------------------------



    }

}
