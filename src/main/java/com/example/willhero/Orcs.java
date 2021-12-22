package com.example.willhero;

import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;

import java.util.Random;

public class Orcs extends GameObject{
    protected int health, coin_reward;
    private static int count = 0;
    Random rand = new Random();

    {
        count++;
    }

    Orcs(double x, double y, int health, int coin_reward){
        super(x, y);
        this.health = health;
        this.coin_reward = coin_reward;
    }

    public GameObject generateOrc(){
        int no = rand.nextInt(2);
        StackPane myOrc = new StackPane();
        myOrc.setPrefWidth(50.0);
        myOrc.setPrefHeight(50.0);
        myOrc.setLayoutX(this.get_X());
        myOrc.setLayoutY(this.get_Y());
        Rectangle detector = new Rectangle(50,50);
        myOrc.getStylesheets().add(getClass().getResource("design.css").toExternalForm());
        detector.setStyle("-fx-fill:transparent");
        this.setId("orc" + count);
        myOrc.setId(this.getId());
        if (no == 1){
            myOrc.getStyleClass().add("greenOrc");
//            myOrc.setStyle("-fx-background-image:url('greenOrc.jpg')");
        } else {
            myOrc.getStyleClass().add("redOrc");
        }
        myOrc.getChildren().add(detector);

        this.setPane(myOrc);
        return this;
    }

    @Override
    public void collision(GameObject o1, GameObject o2) {

    }

    public void jump(){

    }

    public void die(){

    }
}
