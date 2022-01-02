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

    WeaponChest(double x, double y)
    {
        super(x, y);
        generateWchest();
    }

    public Weapon getGiveWeapon(){
        return this.giveWeapon;
    }

    @Override
    public void give_hero(Hero h) {
        super.setDisableCollision(true);
        super.getPane().getStyleClass().add("O_chest");
        Hero.getHero().addWeapon(this.giveWeapon);
        Hero.getHero().changeWeapon(this.giveWeapon);
    }

    private void generateWchest(){
        int rand_num = rand.nextInt(2);
        StackPane Wchest = new StackPane();
        Wchest.setPrefWidth(80.0);
        Wchest.setPrefHeight(70.0);
        Wchest.setLayoutX(this.get_X());
        Wchest.setLayoutY(this.get_Y());
        if(rand_num==0){
            this.giveWeapon = ThrowingKnives.getInstance(Hero.getHero().getPane().getLayoutX() + (Hero.getHero().getPane().getWidth() / 2), Hero.getHero().getPane().getLayoutY() + (Hero.getHero().getPane().getHeight()/2));
        }
        else{
            this.giveWeapon = Shuriken.getInstance(Hero.getHero().getPane().getLayoutX() + (Hero.getHero().getPane().getWidth() / 2), Hero.getHero().getPane().getLayoutY() + (Hero.getHero().getPane().getHeight()/2));
        }
        Wchest.getStylesheets().add(getClass().getResource("design.css").toExternalForm());
        super.setId("wChest" + count);
        Wchest.setId(this.getId());
        Wchest.getStyleClass().add("W_chest");
        super.setPane(Wchest);
    }
}
