package com.example.willhero;

import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
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

//    @FXML
////    private Rectangle r1, r11, r12, r13, r14, r15;
//
//    @FXML
//    private ImageView pl1;

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

//        Image p1 = new Image("C:\\Users\\Atyant Sony\\IdeaProjects\\WillHero\\src\\main\\java\\com\\example\\willhero\\p1.png");
//        Image p2 = new Image("C:\\Users\\Atyant Sony\\IdeaProjects\\WillHero\\src\\main\\java\\com\\example\\willhero\\p2.png");
//        Image p3 = new Image("C:\\Users\\Atyant Sony\\IdeaProjects\\WillHero\\src\\main\\java\\com\\example\\willhero\\p3.png");
//        Image p4 = new Image("C:\\Users\\Atyant Sony\\IdeaProjects\\WillHero\\src\\main\\java\\com\\example\\willhero\\p4.png");
//
//        Image[] platform_arr = {p1,p2,p3,p4};
//        Rectangle[] rect_arr = {r1,r11,r12,r13,r14,r15};
//        int i = 0;
//        for (Rectangle r : rect_arr){
//            r.setFill(new ImagePattern(platform_arr[i%4]));
//            i++;
//        }

    }
}