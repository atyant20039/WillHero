package com.example.willhero;

public class Sword extends Weapon{
    private int damage;
    Sword(Object fxid, double x, double y){
        super(fxid, x, y);
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
