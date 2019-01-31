package com.matchit;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class GetStartedController implements Initializable {


    @FXML
    private Button get_started;


    @FXML
    private ImageView smart_bk;





    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    public void getStartedAction(ActionEvent event){
        System.out.println("Hello World!");
    }

}
