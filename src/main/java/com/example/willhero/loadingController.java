package com.example.willhero;

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
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class loadingController implements Initializable {
    @FXML
    private ImageView loadingClock;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        RotateTransition rotate = new RotateTransition();
        rotate.setNode(loadingClock);
        rotate.setDuration(Duration.millis(1000));
        rotate.setCycleCount(5);
        rotate.setByAngle(360);
        rotate.play();
    }
}