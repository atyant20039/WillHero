package com.example.willhero;

import javafx.scene.image.ImageView;
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
            default:
                break;
        }
        return obj;
    }

    public ImageView create_bkgd_obj(int objno){
        ImageView obj = null;
        switch (objno){
            case 1:
                obj = new Cloud().generateCloud();
                break;
            case 2:

                break;
            default:
                break;
        }
        return obj;
    }
}
