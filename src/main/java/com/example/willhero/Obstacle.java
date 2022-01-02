package com.example.willhero;

public abstract class Obstacle extends GameObject{
    Obstacle(double x, double y)
    {
        super(x, y);
    }

    public abstract double[] collision(GameObject o1, GameObject o2);
}
