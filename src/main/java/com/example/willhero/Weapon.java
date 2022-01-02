package com.example.willhero;

public abstract class Weapon extends GameObject{
    private int damage = 100, range = 200;
    Weapon(double x, double y){
        super(x, y);
    }

    @Override
    public double[] collision(GameObject o1, GameObject o2){

        return new double[0];
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

    public abstract void upgrade();
    public abstract void use_weapon(Hero hero);
}
