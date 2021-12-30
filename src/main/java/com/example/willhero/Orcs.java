package com.example.willhero;

import javafx.geometry.Pos;
import javafx.scene.layout.Border;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;

import java.util.Random;

public class Orcs extends GameObject{
    protected int health, coin_reward;
    private static int count = 0;
    private boolean disableCollision = false;
    Random rand = new Random();

    {
        count++;
    }

    Orcs(double x, double y, int health, int coin_reward){
        super(x, y);
        this.health = health;
        this.coin_reward = coin_reward;
        generateOrc();
    }

    private void generateOrc(){
        int rand_num = rand.nextInt(2);
        StackPane orcPane = new StackPane();;
        orcPane.setPrefWidth(50.0);
        orcPane.setPrefHeight(50.0);
        orcPane.setLayoutX(this.get_X());
        orcPane.setLayoutY(this.get_Y());
        Rectangle orc_rec = new Rectangle(orcPane.getPrefWidth(),orcPane.getPrefHeight());
        orcPane.getStylesheets().add(getClass().getResource("design.css").toExternalForm());
        orc_rec.setStyle("-fx-fill:transparent");
//        orcPane.setBorder(Border.EMPTY);
        this.setId("orc" + count);
        orcPane.setId(this.getId());
        if (rand_num == 1){
            orcPane.getStyleClass().add("greenOrc");
        } else {
            orcPane.getStyleClass().add("redOrc");
        }
        this.setDetector(orc_rec);
//        orcPane.setAlignment(Pos.CENTER_RIGHT);
        orcPane.getChildren().add(orc_rec);
        super.setPane(orcPane);
    }

    @Override
    public void collision(GameObject o1, GameObject o2) {

    }

    public void jump(){

    }

    public boolean isDisableCollision() {
        return disableCollision;
    }

    public void die(){
        disableCollision = true;
        this.getPane().getStyleClass().add("deadOrc");
    }

}
