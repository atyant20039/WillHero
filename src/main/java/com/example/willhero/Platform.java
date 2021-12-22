package com.example.willhero;

import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;

import java.util.Random;

public class Platform extends GameObject{
    private static int count = 0;
    Random rand = new Random();

    {
        count++;
    }
    Platform(double x, double y){
        super(x, y);
    }

    public GameObject generatePlatform(){
        int no = rand.nextInt(4);
        StackPane myplatform = new StackPane();
        myplatform.getStylesheets().add(getClass().getResource("design.css").toExternalForm());
        switch (no){
            case 0:
                myplatform.getStyleClass().add("platform1");
                break;
            case 1:
                myplatform.getStyleClass().add("platform2");
                break;
            case 2:
                myplatform.getStyleClass().add("platform3");
                break;
            case 3:
                myplatform.getStyleClass().add("platform4");
                break;
            default:
                myplatform.getStyleClass().add("platform1");
        }

        myplatform.setPrefHeight(150);
        myplatform.setPrefWidth(200);
        myplatform.setLayoutX(this.get_X());
        myplatform.setLayoutY(this.get_Y());
        Rectangle detector = new Rectangle(200,150);
        detector.setStyle("-fx-fill:transparent");
        this.setId("plat" + count);
        myplatform.setId(this.getId());
        myplatform.getChildren().add(detector);

        this.setPane(myplatform);
        return this;
    }

    @Override
    public void collision(GameObject o1, GameObject o2) {

    }
}
