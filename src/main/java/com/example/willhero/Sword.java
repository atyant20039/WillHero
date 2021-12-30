package com.example.willhero;

public class Sword extends Weapon{
    private int damage;
    private static Sword sword = null;

    private Sword(double x, double y){
        super(x, y);
    }

    public static Sword getSword(){
        if (sword == null){
            sword = new Sword(Hero.getHero().getPane().getLayoutX(),Hero.getHero().getPane().getLayoutY());    //TODO : Change coordinates of sword later
        }
        return sword;
    }
    @Override
    public void upgrade() {

    }

    @Override
    public void use_weapon() {

    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}
