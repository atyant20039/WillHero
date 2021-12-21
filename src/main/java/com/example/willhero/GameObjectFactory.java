package com.example.willhero;

import javafx.scene.layout.StackPane;

public class GameObjectFactory {

    public StackPane createObject(int objno, double x, double y){
        StackPane obj = null;
        switch (objno){
            case 1:
                obj = new Orcs(x,y,100,10).generateOrc();
                break;
            case 2:
                obj = new Platform(x,y).generatePlatform();
                break;
        }

        return obj;
    }
}
