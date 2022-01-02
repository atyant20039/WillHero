package com.example.willhero;

import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class FallingPlatform extends Obstacle{

    private static int count = 0;

    {
        count++;
    }

    FallingPlatform(double x, double y)
    {
        super(x, y);
        generate_FallingPlatform();
    }

    @Override
    public void collision(GameObject o1, GameObject o2) {

    }

    public void generate_FallingPlatform() {
        StackPane fPlatformPane = new StackPane();
        fPlatformPane.getStylesheets().add(getClass().getResource("design.css").toExternalForm());
        fPlatformPane.setPrefWidth(50.0);
        fPlatformPane.setPrefHeight(10.0);
        fPlatformPane.setLayoutX(this.get_X());
        fPlatformPane.setLayoutY(this.get_Y());
        super.setId("fp" + count);
        fPlatformPane.getStyleClass().add("fallingPlat");
        fPlatformPane.setId(super.getId());
        super.setPane(fPlatformPane);
    }

    private void fall(){

    }

    private void fall_tile(){

    }
}
