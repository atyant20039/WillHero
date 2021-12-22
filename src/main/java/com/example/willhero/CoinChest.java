package com.example.willhero;

import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;

public class CoinChest extends Chest{
    private int num_coins;
    private static int count = 0;

    {
        count++;
    }

    CoinChest(double x, double y, int num_coins) {
        super(x, y);
        this.num_coins = num_coins;
    }

    @Override
    public void give_hero(Hero h) {

    }

    public StackPane generateCchest(){
        StackPane Cchest = new StackPane();
        Cchest.setPrefWidth(100.0);
        Cchest.setPrefHeight(100.0);
        Cchest.setLayoutX(this.x_coordinate);
        Cchest.setLayoutY(this.y_coordinate);
        Rectangle C_rec = new Rectangle(100,100);
        Cchest.getStylesheets().add(getClass().getResource("design.css").toExternalForm());
        C_rec.setStyle("-fx-fill:transparent");
        Cchest.setId((String)("cchest" + count));
        Cchest.getStyleClass().add("Cchest");
        Cchest.getChildren().add(C_rec);
        return Cchest;
    }
}
