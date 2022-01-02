package com.example.willhero;

import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class Abyss extends GameObject{
    Abyss(double x, double y) {
        super(x, y);
        generateAbyss();
    }

    @Override
    public double[] collision(GameObject o1, GameObject o2) {

        return new double[0];
    }

    private void generateAbyss(){
        StackPane abyssPane = new StackPane();
        abyssPane.setPrefWidth(1000.0);
        abyssPane.setPrefHeight(0);
        abyssPane.setLayoutX(this.get_X());
        abyssPane.setLayoutY(this.get_Y());
        this.setId("abyss" + 1);
        abyssPane.setId(this.getId());
        super.setPane(abyssPane);
    }
}
