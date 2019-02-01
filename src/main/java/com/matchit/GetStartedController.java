package com.matchit;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;

public class GetStartedController implements Initializable {


    @FXML
    private Button get_started;


    @FXML
    private ImageView smart_bk;

    @FXML
    private ProgressBar progressBar;




    @Override
    public void initialize(URL url, ResourceBundle rb) {
        progressBar.setVisible(false);

    }

    @FXML
    public void getStartedAction(ActionEvent event){

        progressBar.setVisible(true
        );



    }

}
