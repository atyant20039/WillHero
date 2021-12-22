package com.example.willhero;

import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;

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

    public GameObject generateWchest(){
        StackPane Wchest = new StackPane();
        Wchest.setPrefWidth(100.0);
        Wchest.setPrefHeight(100.0);
        Wchest.setLayoutX(this.get_X());
        Wchest.setLayoutY(this.get_Y());
        Rectangle W_rec = new Rectangle(100,100);
        Wchest.getStylesheets().add(getClass().getResource("design.css").toExternalForm());
        W_rec.setStyle("-fx-fill:transparent");
        this.setId("wchest" + count);
        Wchest.setId(this.getId());
        Wchest.getStyleClass().add("Wchest");
        Wchest.getChildren().add(W_rec);

        this.setPane(Wchest);
        return this;
    }
}
