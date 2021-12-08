package com.example.willhero;

import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class gameController implements Initializable {
    @FXML
    private Pane cloudPane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TranslateTransition translate = new TranslateTransition();
        translate.setNode(cloudPane);
        translate.setDuration(Duration.millis(100000));
        translate.setCycleCount(TranslateTransition.INDEFINITE);
        translate.setByX((cloudPane.getLayoutX() + cloudPane.getPrefWidth()) * -1);
        translate.play();
    }
}