package com.example.willhero;

public class ThrowingKnives extends Weapon{
    private int damage, range;
    ThrowingKnives(Object fxid, double x, double y){
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

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }
}
