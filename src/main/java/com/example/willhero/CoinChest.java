package com.example.willhero;

import javafx.scene.layout.StackPane;

public class CoinChest extends Chest{
    private int num_coins;
    private static int count = 0;
    {
        count++;
    }
    CoinChest(double x, double y, int num_coins) {
        super(x, y);
        this.num_coins = num_coins;
        generateCchest();
    }

    @Override
    public void give_hero(Hero hero) {
        super.setDisableCollision(true);
        super.getPane().getStyleClass().add("O_chest");
        hero.getUser().setCoin(hero.getUser().getCoin() + 10);
    }

    private void generateCchest(){
        StackPane Cchest = new StackPane();
        Cchest.setPrefWidth(80.0);
        Cchest.setPrefHeight(70.0);
        Cchest.setLayoutX(this.get_X());
        Cchest.setLayoutY(this.get_Y());
        Cchest.getStylesheets().add(getClass().getResource("design.css").toExternalForm());
        super.setId("cChest" + count);
        Cchest.setId(this.getId());
        Cchest.getStyleClass().add("C_chest");
        super.setPane(Cchest);
    }

    public int getNum_coins(){
        return this.num_coins;
    }




}
