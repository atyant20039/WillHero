package com.example.willhero;

import javafx.scene.image.ImageView;

public class GameObjectFactory {

    public GameObject createObject(int objno, double x, double y, Hero hero){
        switch (objno){
            case 1: //Orc
                return (new Orcs(x,y,100,10));
            case 2: //Boss
                return (new Boss(x,y,1000,100));
            case 3: //WeaponChest
                return (new WeaponChest(x,y,hero));
            case 4: //CoinChest
                return (new CoinChest(x,y,10));
            case 5: //Platform
                return (new Platform(x,y));
            case 6: //Throwing Knives
                return (new ThrowingKnives(x,y));
            case 7: //Coin
                return (new Coin(x,y));
            case 8: // Abyss
                return (new Abyss(x,y));
            case 9: // Shuriken
                return (new Shuriken(x,y));
            case 10: //Falling Platform
                return (new FallingPlatform(x,y));
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
