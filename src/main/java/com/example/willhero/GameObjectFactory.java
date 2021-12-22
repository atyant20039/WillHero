package com.example.willhero;

import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class GameObjectFactory {

    public StackPane createObject(int objno, double x, double y){
        StackPane obj = null;
        switch (objno){
            case 1: //Orc
                obj = new Orcs(x,y,100,10).generateOrc();
                break;
            case 2: //Boss
                obj = new Boss(x,y,100,10).generateBoss();
                break;
            case 3: //WeaponChest
                obj = new WeaponChest(x,y).generateWchest();
                break;
            case 4: //CoinChest
                obj = new CoinChest(x,y,10).generateCchest();
                break;
            case 5: //Platform
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
                obj = new FloatingLand().generateFlaotLand();
                break;
            default:
                break;
        }
        return obj;
    }
}
