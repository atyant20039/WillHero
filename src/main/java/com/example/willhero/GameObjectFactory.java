package com.example.willhero;

import javafx.scene.layout.StackPane;

public class GameObjectFactory {

    public StackPane createObject(int objno, float x, float y){
        StackPane obj = null;
        switch (objno){
            case 1:
                obj = new Orcs(x,y,100,10).generateOrc();
                break;
        }

        return obj;
    }
}
