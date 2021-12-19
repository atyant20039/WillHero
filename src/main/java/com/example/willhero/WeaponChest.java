package com.example.willhero;

public class WeaponChest extends Chest{
    private Weapon give_weapon;

    WeaponChest(Object fxid, double x, double y)
    {
        super(fxid, x, y);
    }

    @Override
    public void give_hero(Hero h) {

    }
}
