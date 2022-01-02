package com.example.willhero;

import javafx.scene.layout.StackPane;
import javafx.scene.shape.Shape;

import java.io.Serializable;

public abstract class GameObject implements Serializable {
    private double x_coordinate, y_coordinate;
    private StackPane myPane = null;
    private String myId = null;

    GameObject(double x, double y){
        this.x_coordinate = x;
        this.y_coordinate = y;
    }

    public void set_coord(double x, double y){
        this.x_coordinate = x;
        this.y_coordinate = y;
    }

    public double[] get_coord(){
        return new double[]{this.x_coordinate, this.y_coordinate};
    }

    public double get_X(){
        return this.x_coordinate;
    }

    public double get_Y(){
        return this.y_coordinate;
    }

    public boolean check_collision(GameObject o1, GameObject o2){
        if (o1.getPane().getBoundsInParent().intersects(o2.getPane().getBoundsInParent())){
            return true;
        } else {
            return false;
        }
    }

    public abstract double[] collision(GameObject o1, GameObject o2);

    public StackPane getPane(){
        return this.myPane;
    }

    public void setPane(StackPane pane){
        this.myPane = pane;
    }

    public String getId(){
        return this.myId;
    }

    public void setId(String id){
        this.myId = id;
    }
}
