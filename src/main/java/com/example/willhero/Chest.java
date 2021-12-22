package com.example.willhero;

public abstract class Chest extends GameObject{
    Chest(double x, double y)
    {
        super(x, y);
    }

    @Override
    public void collision(GameObject o1, GameObject o2) {

    }

    public abstract void give_hero(Hero h);
}
