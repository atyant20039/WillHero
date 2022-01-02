package com.example.willhero;

import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;

public class Boss extends Orcs{
    Boss(double x, double y, int health, int reward){
        super(x, y, health, reward);
        generateBoss();
    }



    @Override
    public void collision(GameObject o1, GameObject o2) {

    }

    public void generateBoss(){
        StackPane bossPane = new StackPane();
        bossPane.setPrefWidth(150.0);
        bossPane.setPrefHeight(150.0);
        bossPane.setLayoutX(this.get_X());
        bossPane.setLayoutY(this.get_Y());
        bossPane.getStylesheets().add(getClass().getResource("design.css").toExternalForm());
        // Boss Orc Pic Needs to be Uploaded.
        bossPane.setId((String)("Boss"));
        bossPane.getStyleClass().add("bossOrc");
        super.setPane(bossPane);
    }

    public int getHealth(){
        return this.health;
    }

    public void reduceHealth(int power){
        this.health -= power;
    }

}
