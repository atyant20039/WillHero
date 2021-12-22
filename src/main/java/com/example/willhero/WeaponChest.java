package com.example.willhero;

import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;

import java.util.Stack;

public class WeaponChest extends Chest{
    private Weapon weapon;

    private static int count = 0;
    {
        count++;
    }

    WeaponChest(double x, double y)
    {
        super(x, y);
    }

    @Override
    public void give_hero(Hero h) {

    }

    public StackPane generateWchest(){
        StackPane Wchest = new StackPane();
        Wchest.setPrefWidth(100.0);
        Wchest.setPrefHeight(100.0);
        Wchest.setLayoutX(this.x_coordinate);
        Wchest.setLayoutY(this.y_coordinate);
        Rectangle W_rec = new Rectangle(100,100);
        Wchest.getStylesheets().add(getClass().getResource("design.css").toExternalForm());
        W_rec.setStyle("-fx-fill:transparent");
        Wchest.setId((String)("orc" + count));
        Wchest.getStyleClass().add("Wchest");
        Wchest.getChildren().add(W_rec);
        return Wchest;
    }
}
