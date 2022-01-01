package com.example.willhero;

public abstract class Chest extends GameObject{

    private boolean disableCollision = false;

    Chest(/*Object fxid, */double x, double y)
    {
        super(/*fxid, */x, y);
    }

    @Override
    public void collision(GameObject o1, GameObject o2) {

    }

    public boolean isDisableCollision() {
        return disableCollision;
    }

    public void setDisableCollision(boolean disableStatus){
        this.disableCollision = disableStatus;
    }

    public abstract void give_hero(Hero h);
}
