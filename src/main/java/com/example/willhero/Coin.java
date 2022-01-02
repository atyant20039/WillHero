package com.example.willhero;

import javafx.scene.layout.StackPane;

public class Coin extends GameObject{
    private static int count = 0;
    {
        count++;
    }
    Coin(double x, double y)
    {
        super(x, y);
        generateCoin();
    }

    private void generateCoin(){
        StackPane coinPane = new StackPane();;
        coinPane.setPrefWidth(20.0);
        coinPane.setPrefHeight(20.0);
        coinPane.setLayoutX(this.get_X());
        coinPane.setLayoutY(this.get_Y());
        coinPane.getStylesheets().add(getClass().getResource("design.css").toExternalForm());
        coinPane.getStyleClass().add("coin");
        this.setId("coin" + count);
        coinPane.setId(this.getId());
        super.setPane(coinPane);
    }

    @Override
    public double[] collision(GameObject o1, GameObject o2) {

        return new double[0];
    }
}
