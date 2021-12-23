package com.example.willhero;

import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;

import java.util.Stack;

public class WeaponChest extends Chest{

    private Weapon weapon;
    protected StackPane W_chestPane;

    private static int count = 0;
    {
        count++;
    }

    WeaponChest(/*Object fxid, */double x, double y /*Weapon weapon*/) {
        super(/*fxid, */x, y);
//        this.weapon = weapon;
        this.W_chestPane = new StackPane();
        generateW_chest();
    }

    @Override
    public void give_hero(Hero h) {

    }

    public void generateW_chest(){
        W_chestPane.setPrefWidth(100.0);
        W_chestPane.setPrefHeight(100.0);
        W_chestPane.setLayoutX(this.x_coordinate);
        W_chestPane.setLayoutY(this.y_coordinate);
        Rectangle W_rec = new Rectangle(100,100);
        W_chestPane.getStylesheets().add(getClass().getResource("design.css").toExternalForm());
        W_rec.setStyle("-fx-fill:transparent");
        W_chestPane.setId((String)("orc" + count));
        W_chestPane.getStyleClass().add("W_chest");
        W_chestPane.getChildren().add(W_rec);
    }
}
