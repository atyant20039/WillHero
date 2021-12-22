package com.example.willhero;

import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;

public class Boss extends Orcs{
    Boss(double x, double y, int health, int reward){
        super(x, y, health, reward);
    }

    public void attack(){

    }

    @Override
    public void collision(GameObject o1, GameObject o2) {
        super.collision(o1, o2);

    }

    public GameObject generateBoss(){
        StackPane Borc = new StackPane();
        Borc.setPrefWidth(100.0);
        Borc.setPrefHeight(100.0);
        Borc.setLayoutX(this.get_X());
        Borc.setLayoutY(this.get_Y());
        Rectangle Borc_rec = new Rectangle(100,100);
        Borc.getStylesheets().add(getClass().getResource("design.css").toExternalForm());
        Borc_rec.setStyle("-fx-fill:transparent");
        this.setId("Boss");
        Borc.setId(this.getId());
        // TODO: Boss Orc Pic Needs to be Uploaded.
        Borc.getStyleClass().add("redOrc");
        Borc.getChildren().add(Borc_rec);

        this.setPane(Borc);
        return this;
    }
}
