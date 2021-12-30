package com.example.willhero;

import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;

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
//        coinPane.setBorder(Border.EMPTY);
        this.setId("coin" + count);
        coinPane.setId(this.getId());
//        coinPane.setAlignment(Pos.CENTER_RIGHT);
        super.setPane(coinPane);
    }

    @Override
    public void collision(GameObject o1, GameObject o2) {

    }
}
