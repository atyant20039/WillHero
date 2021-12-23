package com.example.willhero;

import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;

public class CoinChest extends Chest{
    private int num_coins;
    protected StackPane C_chestPane;

    private static int count = 0;
    {
        count++;
    }

    CoinChest(/*Object fxid, */double x, double y, int num_coins) {
        super(/*fxid,*/x, y);
        this.num_coins = num_coins;
        this.C_chestPane = new StackPane();
        generateC_chest();
    }

    @Override
    public void give_hero(Hero h) {

    }

    public StackPane getC_chestPane(){
        return this.C_chestPane;
    }

    public int getNum_coins(){
        return this.num_coins;
    }

    public void generateC_chest(){
        C_chestPane.setPrefWidth(100.0);
        C_chestPane.setPrefHeight(100.0);
        C_chestPane.setLayoutX(this.x_coordinate);
        C_chestPane.setLayoutY(this.y_coordinate);
        Rectangle C_chestRec = new Rectangle(100,100);
        C_chestPane.getStylesheets().add(getClass().getResource("design.css").toExternalForm());
        C_chestRec.setStyle("-fx-fill:transparent");
        C_chestPane.setId((String)("orc" + count));
        C_chestPane.getStyleClass().add("C_chest");
        C_chestPane.getChildren().add(C_chestRec);
    }
}
