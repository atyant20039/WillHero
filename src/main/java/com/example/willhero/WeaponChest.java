package com.example.willhero;

import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;

import java.util.Stack;
import java.util.Random;

public class WeaponChest extends Chest{
    private String weapon;
    Random rand = new Random();

    private static int count = 0;
    {
        count++;
    }

    WeaponChest(double x, double y)
    {
        super(x, y);
        generateWchest();
    }

    public String getWeapon(){
        return this.weapon;
    }

    @Override
    public void give_hero(Hero h) {
        super.setDisableCollision(true);
        super.getPane().getStyleClass().add("O_chest");
    }

    private void generateWchest(){
        int rand_num = rand.nextInt(2);
        StackPane Wchest = new StackPane();
        Wchest.setPrefWidth(80.0);
        Wchest.setPrefHeight(70.0);
        Wchest.setLayoutX(this.get_X());
        Wchest.setLayoutY(this.get_Y());
        if(rand_num==0){
            this.weapon = "ThrowingKnife";
        }
        else{
            this.weapon = "Shuriken";
        }
        Wchest.getStylesheets().add(getClass().getResource("design.css").toExternalForm());
        super.setId("wChest" + count);
        Wchest.setId(this.getId());
        Wchest.getStyleClass().add("W_chest");
        super.setPane(Wchest);
    }
}
