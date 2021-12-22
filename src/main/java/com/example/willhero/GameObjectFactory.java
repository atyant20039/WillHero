package com.example.willhero;

import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class GameObjectFactory {

    public GameObject createObject(int objno, double x, double y){
        GameObject obj = null;
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
            case 1: // Cloud
                obj = new Cloud().generateCloud();
                break;
            case 2: // Floating Land
                obj = new FloatingLand().generateFloatLand();
                break;
            default:
                break;
        }
        return obj;
    }
}
