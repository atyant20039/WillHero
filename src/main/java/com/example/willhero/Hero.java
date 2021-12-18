package com.example.willhero;

import javafx.animation.TranslateTransition;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

import java.util.ArrayList;

public class Hero extends GameObject{
    private ArrayList<Weapon> myWeapons = new ArrayList<>();
    private Weapon myWeapon;
    private User myUser;
    private String myHelmet;
    private int myCoins = 0, lives = 1;
    private StackPane fxid;
    private double x,y;

    Hero(StackPane fxid, double x, double y){
        this.fxid = fxid;
        this.x = x;
        this.y = y;
    }

    public User getUser() {
        return myUser;
    }

    public void jump(){
        TranslateTransition translate3 = new TranslateTransition();
        translate3.setNode(fxid);
        translate3.setDuration(Duration.millis(500));
        translate3.setCycleCount(TranslateTransition.INDEFINITE);
        translate3.setAutoReverse(true);
        translate3.setByY(-75);
        translate3.play();
    }

    public void forward(){

    }

    public void attack(){

    }

    public void die(){

    }

    public void changeWeapon(){

    }

    public boolean revive(){
        return true;
    }

    public int getCoins() {
        return myCoins;
    }

    public void setCoins(int myCoins) {
        this.myCoins = myCoins;
    }
}
