package com.example.willhero;

public abstract class Weapon extends GameObject{
    Weapon(double x, double y){
        super(x, y,null);
    }

    @Override
    public void collision(GameObject o1, GameObject o2){

    }

    public abstract void upgrade();
    public abstract void use_weapon();
}
