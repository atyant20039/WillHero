package com.example.willhero;

import javafx.scene.layout.StackPane;

public abstract class GameObject {
    protected double x_coordinate, y_coordinate;
    protected StackPane objectPane;

    GameObject(double x, double y, StackPane objectPane){
        this.x_coordinate = x;
        this.y_coordinate = y;
        this.objectPane = objectPane;
    }


    public StackPane getObjectPane() {
        return objectPane;
    }

    public void setObjectPane(StackPane objectPane) {
        this.objectPane = objectPane;
    }



    public void set_coord(){
        this.x_coordinate = this.objectPane.getLayoutX();
        this.y_coordinate = this.objectPane.getLayoutY();
    }

    public double[] get_coord(){
        return new double[]{this.x_coordinate, this.y_coordinate};
    }

    public boolean if_collision(GameObject o1, GameObject o2){
        //TODO : Check collision code
        
        return true;
    }

    public abstract void collision(GameObject o1, GameObject o2);
}
