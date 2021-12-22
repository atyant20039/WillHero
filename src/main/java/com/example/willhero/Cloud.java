package com.example.willhero;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.Random;

public class Cloud {
    Random rand = new Random();

    public ImageView generateCloud(){
        int no = rand.nextInt(2);
        ImageView cloud = new ImageView();
        Image img = null;
        switch (no){
            case 0:
                img = new Image(String.valueOf(getClass().getResource("cloud1.png")));
                break;
            case 1:
                img = new Image(String.valueOf(getClass().getResource("cloud2.png")));
                break;
            default:
                img = new Image(String.valueOf(getClass().getResource("cloud1.png")));
        }
        cloud.setImage(img);
        cloud.setFitWidth(150);
        cloud.setFitHeight(55);
        cloud.setLayoutY((rand.nextInt(2, 10)) * 10);
        cloud.setLayoutX(2800);
        return cloud;
    }
}
