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
        generatePlatform();
    }

    public void generatePlatform(){
        int rand_num = rand.nextInt(4);
        StackPane platformPane = new StackPane();
        platformPane.getStylesheets().add(getClass().getResource("design.css").toExternalForm());
        switch (rand_num){
            case 0:
                platformPane.getStyleClass().add("platform1");
                break;
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

        platformPane.setPrefHeight(200);
        platformPane.setPrefWidth(300);
        platformPane.setLayoutX(this.get_X());
        platformPane.setLayoutY(this.get_Y());
        this.setId("plat" + count);
        platformPane.setId(this.getId());
        super.setPane(platformPane);
    }

    @Override
    public double[] collision(GameObject o1, GameObject o2) {
        return new double[0];
    }
}
