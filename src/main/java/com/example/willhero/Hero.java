package com.example.willhero;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

import java.util.ArrayList;

public class Hero extends GameObject{
    private ArrayList<Weapon> myWeapons = new ArrayList<>();
    private Weapon myWeapon;
    private User myUser;
    private String myHelmet;
    private int myCoins = 0, lives = 1;
    private Timeline gravity;
//    private Object fxid;
//    private double x,y;

    Hero(double x, double y){
        super(x,y,null);

    }

    @Override
    public void collision(GameObject o1, GameObject o2) {

    }

    public User getUser() {
        return myUser;
    }

    public void jump(){
//        TranslateTransition translate3 = new TranslateTransition();
//        translate3.setNode((Node) fxid);
//        translate3.setDuration(Duration.millis(500));
//        translate3.setCycleCount(TranslateTransition.INDEFINITE);
//        translate3.setAutoReverse(true);
//        translate3.setByY(-75);
//        translate3.play();
    }

    public void runGravity(){
//        if (gravity == null){
//            gravity = new Timeline();
//            gravity.setCycleCount(Animation.INDEFINITE);
//            KeyFrame g = new KeyFrame
//        } else gravity.play();
    }

    public void forward(){

    }

    public void attack(){

    }

    public void die(){

    }

    public void changeWeapon(int index){

    }

    public boolean revive(){
        // TODO : code to check if reviving is possible or not
        return true;
    }

    public int getCoins() {
        return myCoins;
    }

    public void setCoins(int myCoins) {
        this.myCoins = myCoins;
    }
}
