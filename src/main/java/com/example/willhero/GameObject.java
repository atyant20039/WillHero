package com.example.willhero;

public abstract class GameObject {
    protected double x_coordinate, y_coordinate;

    GameObject(double x, double y){
        this.x_coordinate = x;
        this.y_coordinate = y;
    }

    public void set_coord(double x, double y){
        this.x_coordinate = x;
        this.y_coordinate = y;
    }

    public double[] get_coord(){
//        double[] coord = {this.x_coordinate , this.y_coordinate};
        return new double[]{this.x_coordinate, this.y_coordinate};
    }

    public boolean if_collision(GameObject o1, GameObject o2){
        //TODO : Check collision code
        
        return true;
    }

    public abstract void collision(GameObject o1, GameObject o2);
}
