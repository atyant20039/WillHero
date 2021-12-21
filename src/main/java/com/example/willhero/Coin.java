package com.example.willhero;

public class Coin extends GameObject{
    Coin(Object fxid, double x, double y)
    {
        super(/*fxid, */x, y);
    }

    @Override
    public void collision(GameObject o1, GameObject o2) {

    }
}
