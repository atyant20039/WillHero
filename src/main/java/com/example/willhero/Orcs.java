package com.example.willhero;

import javafx.scene.layout.StackPane;

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
        orcPane.getStylesheets().add(getClass().getResource("design.css").toExternalForm());
        this.setId("orc" + count);
        orcPane.setId(this.getId());
        if (rand_num == 1){
            orcPane.getStyleClass().add("greenOrc");
        } else {
            orcPane.getStyleClass().add("redOrc");
        }
        super.setPane(orcPane);
    }

    @Override
    public double[] collision(GameObject o1, GameObject o2) {
        return new double[0];
    }

    public double[] jump(){
        double velocityY = -5.5, time = 0.13, collision = 1;
        return new double[]{collision,velocityY,time};
    }

    public boolean isDisableCollision() {
        return disableCollision;
    }

    public void reduceHealth(int power, Hero hero){
        this.health -= power;
        if (health <=  0){
            this.die(hero);
        }
    }

    private void die(Hero hero){
        disableCollision = true;
        this.getPane().getStyleClass().add("deadOrc");
        hero.getUser().setCoin(hero.getUser().getCoin() + 1);
    }


}
