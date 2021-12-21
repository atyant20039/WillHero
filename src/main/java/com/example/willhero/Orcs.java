package com.example.willhero;

import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;

import java.util.Random;

public class Orcs extends GameObject{
    protected int health, coin_reward;
    private static int count = 0;
    {
        count++;
    }

    Orcs(/*Object fxid, */double x, double y, int health, int coin_reward){
        super(/*fxid, */x, y);
        this.health = health;
        this.coin_reward = coin_reward;
    }

    public StackPane generateOrc(){
        Random rand = new Random();
        int no = rand.nextInt(2);
        StackPane orc = new StackPane();
        orc.setPrefWidth(50.0);
        orc.setPrefHeight(50.0);
        orc.setLayoutX(this.x_coordinate);
        orc.setLayoutY(this.y_coordinate);
        Rectangle hid = new Rectangle(50,50);
        orc.getStylesheets().add(getClass().getResource("design.css").toExternalForm());
        hid.setStyle("-fx-fill:transparent");
        orc.setId((String)("orc" + count));
        if (no == 1){
            orc.getStyleClass().add("greenOrc");
//            orc.setStyle("-fx-background-image:url('greenOrc.jpg')");
        } else {
            orc.getStyleClass().add("redOrc");
        }
        orc.getChildren().add(hid);
        return orc;
    }

    @Override
    public void collision(GameObject o1, GameObject o2) {

    }

    public void jump(){

    }

    public void die(){

    }

}
