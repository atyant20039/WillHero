package com.example.willhero;

import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;

import java.util.Stack;

public class Boss extends Orcs{
    Boss(double x, double y, int health, int reward){
        super(/*fxid, */x, y, health, reward);
    }

    public void attack(){

    }

    @Override
    public void collision(GameObject o1, GameObject o2) {
        super.collision(o1, o2);

    }

    public StackPane generateBoss(){
        StackPane Borc = new StackPane();
        Borc.setPrefWidth(100.0);
        Borc.setPrefHeight(100.0);
        Borc.setLayoutX(this.x_coordinate);
        Borc.setLayoutY(this.y_coordinate);
        Rectangle Borc_rec = new Rectangle(100,100);
        Borc.getStylesheets().add(getClass().getResource("design.css").toExternalForm());
        // Boss Orc Pic Needs to be Uploaded.
        Borc_rec.setStyle("-fx-fill:transparent");
        Borc.setId((String)("Boss"));
        Borc.getStyleClass().add("redOrc");
        Borc.getChildren().add(Borc_rec);
        return Borc;
    }
}
