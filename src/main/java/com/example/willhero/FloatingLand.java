package com.example.willhero;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Random;

public class FloatingLand {
    Random rand = new Random();

    public ImageView generateFloatLand(){
        int no = rand.nextInt(4);
        ImageView land = new ImageView();
        Image img = null;
        switch (no)
        {
            case 0:
                img = new Image(String.valueOf(getClass().getResource("p5_float.png")));
                break;
            case 1:
                img = new Image(String.valueOf(getClass().getResource("p6_float.png")));
                break;
            case 2:
                img = new Image(String.valueOf(getClass().getResource("p7_float.png")));
                break;
            case 3:
                img = new Image(String.valueOf(getClass().getResource("p8_float.png")));
                break;
            default:
                img = new Image(String.valueOf(getClass().getResource("p5_float.png")));

        }
        land.setImage(img);
        land.setFitWidth(55);
        land.setFitHeight(55);
        land.setLayoutX(2900);
        land.setLayoutY((rand.nextInt(10, 25)) * 10);
        return land;
    }
}
