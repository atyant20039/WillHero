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
    private ArrayList<Weapon> myWeapons = new ArrayList<>();
    private Weapon myWeapon = null;
    private User myUser;
    private String myHelmet;
    private int myCoins = 0, lives = 1;
    private Timeline gravity;
//    private Object fxid;
//    private double x,y;

    Hero(double x, double y){
        super(x,y);
        generateHero();
//        this.myUser = user;
    }

    @Override
    public void collision(GameObject o1, GameObject o2) {

    }

    public User getUser() {
        return myUser;
    }

    private void generateHero(){
        StackPane heroPane = new StackPane();
        heroPane.setPrefWidth(43.0);
        heroPane.setPrefHeight(55.0);
//        heroPane.setMaxWidth(43.0);
//        heroPane.setMaxHeight(55.0);
        heroPane.setLayoutX(this.get_X());
        heroPane.setLayoutY(this.get_Y());
//        Rectangle hero_rec = new Rectangle(40,34);
//        hero_rec.setStyle("-fx-fill:transparent");
        this.setId("hero");
        heroPane.setId(this.getId());
        Image heroImg = new Image(String.valueOf(getClass().getResource("hero.png")));
        ImageView hero_image = new ImageView(heroImg);
        hero_image.setFitWidth(43.0);
        hero_image.setFitHeight(55.0);

        Image knifeImg = new Image(String.valueOf(getClass().getResource("ThrowingKnife.png")));
        ImageView knife_image = new ImageView(knifeImg);
        knife_image.setFitWidth(45);
        knife_image.setFitHeight(10);
        knife_image.setVisible(false);
//        heroPane.getStylesheets().add(getClass().getResource("design.css").toExternalForm());
//        heroPane.getStyleClass().add("hero");
//        this.setDetector(hero_rec);
//        heroPane.setStyle("-fx-background:#000000");
        heroPane.setAlignment(Pos.BOTTOM_RIGHT);
        heroPane.getChildren().add(hero_image);
        heroPane.getChildren().add(knife_image);
        super.setPane(heroPane);
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
