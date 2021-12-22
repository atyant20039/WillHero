package com.example.willhero;

import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;

import java.util.Random;

public class Orcs extends GameObject{
    protected int health, coin_reward;
    protected String orcId;
    private static int count = 0;
    Random rand = new Random();

    {
        count++;
    }

    Orcs(double x, double y, int health, int coin_reward){
        super(x, y);
        this.health = health;
        this.coin_reward = coin_reward;
        this.orcId = null;
    }

    public StackPane generateOrc(){
        int no = rand.nextInt(2);
        StackPane orc = new StackPane();
        orc.setPrefWidth(50.0);
        orc.setPrefHeight(50.0);
        orc.setLayoutX(this.x_coordinate);
        orc.setLayoutY(this.y_coordinate);
        Rectangle detector = new Rectangle(50,50);
        orc.getStylesheets().add(getClass().getResource("design.css").toExternalForm());
        detector.setStyle("-fx-fill:transparent");
        this.orcId = "orc" + count;
        orc.setId(this.orcId);
        if (no == 1){
            orc.getStyleClass().add("greenOrc");
//            orc.setStyle("-fx-background-image:url('greenOrc.jpg')");
        } else {
            orc.getStyleClass().add("redOrc");
        }
        orc.getChildren().add(detector);
        return orc;
    }

    @Override
    public void collision(GameObject o1, GameObject o2) {

    }

    public void jump(){

    }

    public void die(){

    }

    public String getOrcId(){
        return this.orcId;
    }

}
