package com.example.willhero;

import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

import java.util.HashMap;
import java.util.Map;

public class Shuriken extends Weapon{
    private static int count = 0;

    {
        count++;
    }

    public Shuriken(double x, double y){
        super(x, y);
        this.generateShuriken();
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
        this.setDamage(this.getDamage() + 25);
    }

    @Override
    public void use_weapon(Hero hero) {
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
        });
    }
}
