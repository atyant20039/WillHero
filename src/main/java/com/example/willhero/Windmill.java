package com.example.willhero;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class Windmill extends Obstacle{
    private ImageView tower = null;
    private static int count = 0;
    {
        count++;
    }
    Windmill(double x, double y)
    {
        super(x, y);
        createMill();
    }

    @Override
    public double[] collision(GameObject o1, GameObject o2) {

        return new double[0];
    }

    private void createMill(){
        tower = new ImageView(String.valueOf(getClass().getResource("windmill_tower.png")));
        tower.setFitWidth(100);
        tower.setFitHeight(300);
        tower.setLayoutX(this.get_X());
        tower.setLayoutY(this.get_Y());

        StackPane blades = new StackPane();
        blades.getStylesheets().add(String.valueOf(getClass().getResource("design.css")));
        blades.getStyleClass().add("windmill_blade");
        blades.setPrefHeight(250);
        blades.setPrefWidth(250);
        blades.setLayoutX(this.get_X() - (blades.getPrefWidth()/4));
        blades.setLayoutY(this.get_Y() - (blades.getPrefHeight()/4));
        System.out.println(blades.getPrefWidth());
        System.out.println(blades.getPrefHeight());
        this.setId("windmill" + count);
        blades.setId(this.getId());
        this.setPane(blades);
    }

    public ImageView getTower(){
        return this.tower;
    }
}
