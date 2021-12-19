package com.example.willhero;

public class Orcs extends GameObject{
    protected int health, coin_reward;

    Orcs(Object fxid, double x, double y, int health, int coin_reward){
        super(fxid, x, y);
        this.health = health;
        this.coin_reward = coin_reward;
    }

    @Override
    public void collision(GameObject o1, GameObject o2) {

    }

    public void jump(){

    }

    public void die(){

    }
}
