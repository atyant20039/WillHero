package com.example.willhero;

import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class gameController implements Initializable {
    @FXML
    private Pane cloudPane;

    @FXML
    private Pane floatPane;

    @FXML
    private StackPane hero;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TranslateTransition translate1 = new TranslateTransition();
        translate1.setNode(cloudPane);
        translate1.setDuration(Duration.millis(100000));
        translate1.setCycleCount(TranslateTransition.INDEFINITE);
        translate1.setByX((cloudPane.getLayoutX() + cloudPane.getPrefWidth()) * -1);
        translate1.play();

        TranslateTransition translate2 = new TranslateTransition();
        translate2.setNode(floatPane);
        translate2.setDuration(Duration.millis(5000));
        translate2.setCycleCount(TranslateTransition.INDEFINITE);
        translate2.setAutoReverse(true);
        translate2.setByY(floatPane.getLayoutY() + 10);
        translate2.play();

        TranslateTransition translate3 = new TranslateTransition();
        translate3.setNode(hero);
        translate3.setDuration(Duration.millis(500));
        translate3.setCycleCount(TranslateTransition.INDEFINITE);
        translate3.setAutoReverse(true);
        translate3.setByY(-75);
        translate3.play();

    }
}