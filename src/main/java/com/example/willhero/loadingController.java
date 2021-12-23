package com.example.willhero;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static java.lang.Thread.sleep;

public class loadingController implements Initializable {
    @FXML
    private ImageView loadingClock;

    @FXML
    private Button loadingButton;

    @FXML
    private VBox loadingVbox;

    @FXML
    private Text start_text;

    @FXML
    private void click_to_start(ActionEvent event) throws IOException{
        loadingButton.getScene().setRoot(FXMLLoader.load(getClass().getResource("main_menu.fxml")));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        RotateTransition rotate = new RotateTransition();
        rotate.setNode(loadingClock);
        rotate.setDuration(Duration.millis(1000));
        rotate.setCycleCount(5);
        rotate.setByAngle(360);
        rotate.play();
        rotate.setOnFinished(actionEvent -> {
            loadingVbox.setVisible(false);
            loadingButton.setDisable(false);
            loadingButton.setVisible(true);
            start_text.setVisible(true);
        });
    }


}