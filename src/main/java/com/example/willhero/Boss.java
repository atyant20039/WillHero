package com.example.willhero;

import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;

import java.util.Stack;

public class Boss extends Orcs{

    protected StackPane bossPane;

    Boss(/*Object fxid, */double x, double y, int health, int reward){
        super(/*fxid, */x, y, health, reward);
        this.bossPane = new StackPane();
        generateBoss();
    }

    public void attack(){

    }

    @Override
    public void collision(GameObject o1, GameObject o2) {
        super.collision(o1, o2);


    }

    public void generateBoss(){
        bossPane.setPrefWidth(100.0);
        bossPane.setPrefHeight(100.0);
        bossPane.setLayoutX(this.x_coordinate);
        bossPane.setLayoutY(this.y_coordinate);
        Rectangle Borc_rec = new Rectangle(100,100);
        bossPane.getStylesheets().add(getClass().getResource("design.css").toExternalForm());
        // Boss Orc Pic Needs to be Uploaded.
        Borc_rec.setStyle("-fx-fill:transparent");
        bossPane.setId((String)("Boss"));
        bossPane.getStyleClass().add("redOrc");
        bossPane.getChildren().add(Borc_rec);
    }

    public StackPane getBossPane(){
        return this.bossPane;
    }
}
