package com.example.willhero;

import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;

import java.util.Random;
import java.util.Stack;

public class Platform extends GameObject{


    private String platformId;
    private static int count = 0;
    Random rand = new Random();

    {
        count++;
    }
    Platform(double x, double y){
        super(x, y, null);
        this.platformId = null;
        generatePlatform();
    }

    public void generatePlatform(){
        int rand_num = rand.nextInt(4);
        StackPane platformPane = new StackPane();
        platformPane.getStylesheets().add(getClass().getResource("design.css").toExternalForm());
        switch (rand_num){
//            case 0:
//                platformPane.getStyleClass().add("platform1");
//                break;
            case 1:
                platformPane.getStyleClass().add("platform2");
                break;
            case 2:
                platformPane.getStyleClass().add("platform3");
                break;
            case 3:
                platformPane.getStyleClass().add("platform4");
                break;
            default:
                platformPane.getStyleClass().add("platform1");
        }

        platformPane.setPrefHeight(150);
        platformPane.setPrefWidth(200);
        platformPane.setLayoutX(this.x_coordinate);
        platformPane.setLayoutY(this.y_coordinate);
        Rectangle platform_rec = new Rectangle(200,150);
        platform_rec.setStyle("-fx-fill:transparent");
        this.platformId = "plat" + count;
        platformPane.setId(this.platformId);
        platformPane.getChildren().add(platform_rec);
        super.setObjectPane(platformPane);
    }

    @Override
    public void collision(GameObject o1, GameObject o2) {

    }

    public String getPlatformId(){
        return this.platformId;
    }



}
