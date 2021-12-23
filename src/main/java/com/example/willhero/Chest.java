package com.example.willhero;

public abstract class Chest extends GameObject{
    Chest(/*Object fxid, */double x, double y)
    {
        super(/*fxid, */x, y,null);
    }

    @Override
    public void collision(GameObject o1, GameObject o2) {

    }

    public abstract void give_hero(Hero h);
}
