package com.example.willhero;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.util.ArrayList;

public class Hero extends GameObject{
    private static Hero hero = null;
    private ArrayList<Weapon> myWeapons = new ArrayList<>();
    private Weapon myWeapon = null;
    private User myUser;
    private String myHelmet;
    private int lives = 1;
    private boolean disableCollision = false;
    private Timeline gravity;
//    private Object fxid;
//    private double x,y;

    public Hero(double x, double y, User user){
        super(x,y);
        generateHero();
        this.myUser = user;
    }

    @Override
    public double[] collision(GameObject o1, GameObject o2) {

        return new double[0];
    }

    public User getUser() {
        return myUser;
    }

    private void generateHero(){
        StackPane heroPane = new StackPane();
        heroPane.setPrefWidth(43.0);
        heroPane.setPrefHeight(55.0);
        heroPane.setLayoutX(this.get_X());
        heroPane.setLayoutY(this.get_Y());
        this.setId("hero");
        heroPane.setId(this.getId());
        heroPane.getStylesheets().add(getClass().getResource("design.css").toExternalForm());
        heroPane.getStyleClass().add("hero");
        super.setPane(heroPane);
    }

    public double[] jump(){
        double velocityY = -5.5, time = 0.13, collision = 1;
        return new double[]{collision, velocityY, time};
    }

    public void forward(){

    }

    public void attack(){

    }

    public void changeWeapon(Weapon weapon){
        this.myWeapon = weapon;
    }

    public boolean revive(){
        // TODO : code to check if reviving is possible or not
        disableCollision = false;
        this.getPane().getStyleClass().add("hero");

        return true;
    }

    public boolean isDisableCollision() {
        return disableCollision;
    }

    public void die(){
        disableCollision = true;
        this.getPane().getStyleClass().add("deadOrc");
        //todo
    }

    public void addWeapon(GameObject weapon){
        if (weapon instanceof Weapon){
            this.myWeapons.add((Weapon) weapon);
        }
    }
}
