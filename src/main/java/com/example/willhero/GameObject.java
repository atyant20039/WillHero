package com.example.willhero;

import javafx.scene.layout.StackPane;
import javafx.scene.shape.Shape;

public abstract class GameObject {
    private double x_coordinate, y_coordinate;
    private StackPane myPane = null;
    private Shape detector = null;
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
        //TODO : Check collision code
        
        return true;
    }

    public abstract void collision(GameObject o1, GameObject o2);

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

//    public Shape getDetector() {
//        return detector;
//    }

    public void setDetector(Shape detector) {
        this.detector = detector;
    }
}
