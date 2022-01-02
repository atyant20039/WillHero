package com.example.willhero;

public abstract class Chest extends GameObject{
    private boolean disableCollision = false;
    Chest(double x, double y)
    {
        super(x, y);
    }

    @Override
    public double[] collision(GameObject o1, GameObject o2) {
        double velocityY = -0.1, time = 0.1, collision = 1;
        return new double[]{collision,velocityY,time};
    }

    public boolean isDisableCollision() {
        return disableCollision;
    }

    public void setDisableCollision(boolean disableStatus){
        this.disableCollision = disableStatus;
    }

    public abstract void give_hero(Hero h);
}
