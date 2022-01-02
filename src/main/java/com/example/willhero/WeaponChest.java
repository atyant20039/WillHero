package com.example.willhero;

import javafx.scene.layout.StackPane;

import java.util.Random;

public class WeaponChest extends Chest{
    private Weapon giveWeapon;
    Random rand = new Random();

    private static int count = 0;
    {
        count++;
    }

    WeaponChest(double x, double y, Hero hero)
    {
        super(x, y);
        generateWchest(hero);
    }

    public Weapon getGiveWeapon(){
        return this.giveWeapon;
    }

    @Override
    public void give_hero(Hero hero) {
        super.setDisableCollision(true);
        super.getPane().getStyleClass().add("O_chest");
        hero.addWeapon(this.giveWeapon);
        hero.changeWeapon(this.giveWeapon);
    }

    private void generateWchest(Hero hero){
        int rand_num = rand.nextInt(2);
        StackPane Wchest = new StackPane();
        Wchest.setPrefWidth(80.0);
        Wchest.setPrefHeight(70.0);
        Wchest.setLayoutX(this.get_X());
        Wchest.setLayoutY(this.get_Y());
        if(rand_num==0){
            this.giveWeapon = new ThrowingKnives(hero.getPane().getLayoutX() + (hero.getPane().getWidth() / 2), hero.getPane().getLayoutY() + (hero.getPane().getHeight()/2));
        }
        else{
            this.giveWeapon = new Shuriken(hero.getPane().getLayoutX() + (hero.getPane().getWidth() / 2), hero.getPane().getLayoutY() + (hero.getPane().getHeight()/2));
        }
        Wchest.getStylesheets().add(getClass().getResource("design.css").toExternalForm());
        super.setId("wChest" + count);
        Wchest.setId(this.getId());
        Wchest.getStyleClass().add("W_chest");
        super.setPane(Wchest);
    }
}
