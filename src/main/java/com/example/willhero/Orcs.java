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
        super(x, y,null);
        this.health = health;
        this.coin_reward = coin_reward;
        this.orcId = null;
        generateOrc();
    }

    private void generateOrc(){
        int rand_num = rand.nextInt(2);
        StackPane orcPane = new StackPane();;
        orcPane.setPrefWidth(50.0);
        orcPane.setPrefHeight(50.0);
        orcPane.setLayoutX(this.x_coordinate);
        orcPane.setLayoutY(this.y_coordinate);
        Rectangle orc_rec = new Rectangle(50,50);
        orcPane.getStylesheets().add(getClass().getResource("design.css").toExternalForm());
        orc_rec.setStyle("-fx-fill:transparent");
        this.orcId = "orc" + count;
        orcPane.setId(this.orcId);
        if (rand_num == 1){
            orcPane.getStyleClass().add("greenOrc");
        } else {
            orcPane.getStyleClass().add("redOrc");
        }
        orcPane.getChildren().add(orc_rec);
        super.setObjectPane(orcPane);
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
