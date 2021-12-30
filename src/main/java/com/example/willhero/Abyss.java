package com.example.willhero;

import javafx.scene.layout.StackPane;

public class Abyss extends GameObject{
    Abyss(StackPane pane, double x, double y)
    {
        super(x, y);
        this.setPane(pane);
    }

    @Override
    public void collision(GameObject o1, GameObject o2) {

    }
}
