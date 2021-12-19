package com.example.willhero;

public class FallingPlatform extends Obstacle{
    private int num_tiles;
    FallingPlatform(Object fxid, double x, double y, int tiles)
    {
        super(fxid, x, y);
        this.num_tiles = tiles;
    }

    @Override
    public void collision(GameObject o1, GameObject o2) {

    }

    private void fall(){

    }

    private void fall_tile(){

    }
}
