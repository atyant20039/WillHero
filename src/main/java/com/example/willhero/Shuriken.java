package com.example.willhero;

import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

import java.util.HashMap;
import java.util.Map;

public class Shuriken extends Weapon{

    private int damage = 100, range = 300;
    private static int count = 0;
    private static Map<Double, Shuriken> instances = new HashMap<Double, Shuriken>();

    {
        count++;
    }

    private Shuriken(double x, double y){
        super(x, y);
        this.generateShuriken();
    }

    public static Shuriken getInstance(double x, Double y){
        if (!instances.containsKey(y)){
            instances.put(y, new Shuriken(x,y));
        }
        return instances.get(y);
    }

    private void generateShuriken(){
        StackPane shurikenPane = new StackPane();;
        shurikenPane.setPrefWidth(35.0);
        shurikenPane.setPrefHeight(35.0);
        shurikenPane.setLayoutX(this.get_X());
        shurikenPane.setLayoutY(this.get_Y());
        shurikenPane.getStylesheets().add(getClass().getResource("design.css").toExternalForm());
        shurikenPane.getStyleClass().add("shuriken");
        super.setId("shuriken" + count);
        shurikenPane.setId(super.getId());
        shurikenPane.setVisible(false);
        super.setPane(shurikenPane);
    }

    @Override
    public void upgrade() {

    }

    @Override
    public void use_weapon() {
        instances.remove(this);
        this.getPane().setVisible(true);
        TranslateTransition translate = new TranslateTransition();
        translate.setNode(this.getPane());
        translate.setDuration(Duration.millis(100));
        translate.setCycleCount(1);
        translate.setByX(this.range);
        translate.setInterpolator(Interpolator.LINEAR);
        translate.play();
        translate.setOnFinished(ActionEvent -> {
            this.getPane().setVisible(false);
            this.getPane().setTranslateX(0);
            instances.put(Hero.getHero().getPane().getLayoutY(),this);
        });
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }
}
