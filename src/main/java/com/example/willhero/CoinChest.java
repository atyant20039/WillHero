package com.example.willhero;

public class CoinChest extends Chest{
    private int num_coins;
    CoinChest(Object fxid, double x, double y)
    {
        super(fxid,x, y);
    }

    @Override
    public void give_hero(Hero h) {

    }
}
