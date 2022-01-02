package com.example.willhero;

public abstract class Weapon extends GameObject{
    Weapon(double x, double y){
        super(x, y);
    }

    @Override
    public double[] collision(GameObject o1, GameObject o2){

        return new double[0];
    }

    public abstract void upgrade();
    public abstract void use_weapon();
}
