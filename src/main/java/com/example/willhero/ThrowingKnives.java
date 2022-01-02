package com.example.willhero;
import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;
import java.util.HashMap;
import java.util.Map;

public class ThrowingKnives extends Weapon{
    private static int count = 0;
    private static Map<Double, ThrowingKnives> instances = new HashMap<Double, ThrowingKnives>();

    {
        count++;
    }

    private ThrowingKnives(double x, double y){
        super(x, y);
        this.generateKnife();
    }

    public static ThrowingKnives getInstance(double x, Double y){
        if (!instances.containsKey(y)){
            instances.put(y, new ThrowingKnives(x,y));
        }
        return instances.get(y);
    }

    private void generateKnife(){
        StackPane knifePane = new StackPane();;
        knifePane.setPrefWidth(45.0);
        knifePane.setPrefHeight(10.0);
        knifePane.setLayoutX(this.get_X());
        knifePane.setLayoutY(this.get_Y());
        knifePane.getStylesheets().add(getClass().getResource("design.css").toExternalForm());
        knifePane.getStyleClass().add("knife");
        this.setId("knife" + count);
        knifePane.setId(this.getId());
        knifePane.setVisible(false);
        super.setPane(knifePane);
    }

    @Override
    public void upgrade() {
        this.setRange(this.getRange() + 25);
    }

    @Override
    public void use_weapon() {
        instances.remove(this);
        this.getPane().setVisible(true);
        TranslateTransition translate = new TranslateTransition();
        translate.setNode(this.getPane());
        translate.setDuration(Duration.millis(100));
        translate.setCycleCount(1);
        translate.setByX(this.getRange());
        translate.setInterpolator(Interpolator.LINEAR);
        translate.play();
        translate.setOnFinished(ActionEvent -> {
            this.getPane().setVisible(false);
            this.getPane().setTranslateX(0);
            instances.put(Hero.getHero().getPane().getLayoutY(),this);
        });
    }
}
