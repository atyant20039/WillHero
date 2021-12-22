package com.example.willhero;

import javafx.scene.layout.StackPane;

public class GameObjectFactory {

    public StackPane createObject(int objno, float x, float y){
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
        }
        return obj;
    }
}
