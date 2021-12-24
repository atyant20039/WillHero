package com.example.willhero;

import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class GameObjectFactory {

    public GameObject createObject(int objno, double x, double y){
        switch (objno){
//            case 0:
//                return (new Hero(x,y));
            case 1: //Orc
                return (new Orcs(x,y,100,10));
            case 2: //Boss
                return (new Boss(x,y,100,10));
            case 3: //WeaponChest
                return (new WeaponChest(x,y));
            case 4: //CoinChest
                return (new CoinChest(x,y,10));
            case 5: //Platform
                return (new Platform(x,y));
            default: // Attention required: returning null in case of default!
                return null;
        }
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
