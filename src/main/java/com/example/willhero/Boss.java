package com.example.willhero;

import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;

public class Boss extends Orcs{
    Boss(double x, double y, int health, int reward){
        super(x, y, health, reward);
        generateBoss();
    }

    public void attack(){

    }

    @Override
    public void collision(GameObject o1, GameObject o2) {
        super.collision(o1, o2);

    }

    public void generateBoss(){
        StackPane bossPane = new StackPane();
        bossPane.setPrefWidth(100.0);
        bossPane.setPrefHeight(100.0);
        bossPane.setLayoutX(this.get_X());
        bossPane.setLayoutY(this.get_Y());
        Rectangle Borc_rec = new Rectangle(100,100);
        bossPane.getStylesheets().add(getClass().getResource("design.css").toExternalForm());
        // Boss Orc Pic Needs to be Uploaded.
        Borc_rec.setStyle("-fx-fill:transparent");
        bossPane.setId((String)("Boss"));
        bossPane.getStyleClass().add("redOrc");
        bossPane.getChildren().add(Borc_rec);
        super.setPane(bossPane);
    }

}
