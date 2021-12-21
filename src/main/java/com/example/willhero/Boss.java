package com.example.willhero;

public class Boss extends Orcs{
    Boss(double x, double y, int health, int reward){
        super(/*fxid, */x, y, health, reward);
    }

    public void attack(){

    }

    @Override
    public void collision(GameObject o1, GameObject o2) {
        super.collision(o1, o2);

    }
}
