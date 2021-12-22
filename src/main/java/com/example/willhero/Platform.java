package com.example.willhero;

import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;

import java.util.Random;

public class Platform extends GameObject{
    private String platformId;
    private static int count = 0;
    Random rand = new Random();

    {
        count++;
    }
    Platform(double x, double y){
        super(x, y);
        this.platformId = null;
    }

    public StackPane generatePlatform(){
        int no = rand.nextInt(4);
        StackPane platform = new StackPane();
        platform.getStylesheets().add(getClass().getResource("design.css").toExternalForm());
        switch (no){
            case 0:
                platform.getStyleClass().add("platform1");
                break;
            case 1:
                platform.getStyleClass().add("platform2");
                break;
            case 2:
                platform.getStyleClass().add("platform3");
                break;
            case 3:
                platform.getStyleClass().add("platform4");
                break;
            default:
                platform.getStyleClass().add("platform1");
        }

        platform.setPrefHeight(150);
        platform.setPrefWidth(200);
        platform.setLayoutX(this.x_coordinate);
        platform.setLayoutY(this.y_coordinate);
        Rectangle detector = new Rectangle(200,150);
        detector.setStyle("-fx-fill:transparent");
        this.platformId = "plat" + count;
        platform.setId(this.platformId);
        platform.getChildren().add(detector);
        return platform;
    }

    @Override
    public void collision(GameObject o1, GameObject o2) {

    }

    public String getPlatformId(){
        return this.platformId;
    }

}
