package com.example.willhero;

/*TODO:
    Move hero
    Kill instances
    Hero Orc collision overlapping
*/
import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class gameController implements Initializable {
    @FXML
    private Pane cloudPane, floatPane;

    @FXML
    private AnchorPane gamePane;

    @FXML
    private StackPane hero;

    @FXML
    private Button pause_button;

    @FXML
    private Button move_hero_button;

    private GameObjectFactory factory = new GameObjectFactory();
    private ArrayList<StackPane> GameObjList = new ArrayList<>();
    private ArrayList<ImageView> BkgdObjList = new ArrayList<>();

    @FXML
    protected void clicked_pause(ActionEvent event) throws IOException {
        System.out.println("pause clicked");
        pause_button.getScene().setRoot(FXMLLoader.load(getClass().getResource("pause_menu.fxml")));
    }

    private Hero h;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TranslateTransition translate2 = new TranslateTransition();
        translate2.setNode(floatPane);
        translate2.setDuration(Duration.millis(5000));
        translate2.setCycleCount(TranslateTransition.INDEFINITE);
        translate2.setAutoReverse(true);
        translate2.setByY(floatPane.getLayoutY() + 10);
        translate2.play();

        h = new Hero(hero.getLayoutX(), hero.getLayoutY());
        h.jump();
    }

    public void move_hero(ActionEvent event) {
        System.out.println("hero moved");
        for (StackPane s: GameObjList){
            s.setLayoutX(s.getLayoutX() - 50);
        }

        for (ImageView i: BkgdObjList){
            i.setLayoutX(i.getLayoutX() - 50);
            if (i.getParent().equals(cloudPane)){
                move_cloud(i);
            }
        }
//        cloudPane.setLayoutX(cloudPane.getLayoutX() - 50);
//        floatPane.setLayoutX(floatPane.getLayoutX() - 50);
//        gamePane.setLayoutX(gamePane.getLayoutX() - 50);
//        hero.setLayoutX(hero.getLayoutX() + 50);

//        generateObject(1);
//        generateGameObj(2);
//        for(int i = 0; i < 1000; i++){
            generateBkgdObj(1);
//        }
//        System.gc();
//        System.runFinalization();
//        System.out.println(this.BkgdObjList.size());
//        System.out.println(this.cloudPane.getChildren());
    }

    private void generateGameObj(int objno) {
        StackPane obj = factory.createObject(objno,400 + hero.getLayoutX(),314);
        GameObjList.add(obj);
        gamePane.getChildren().add(obj);
        System.out.println(obj.getId());
//        obj = null;   ERROR
    }

    private void generateBkgdObj(int objno){
        ImageView obj = factory.create_bkgd_obj(objno);
        BkgdObjList.add(obj);
        if (objno == 1){
            cloudPane.getChildren().add(obj);
            move_cloud(obj);
        }
        else floatPane.getChildren().add(obj);
//        obj = null;   ERROR
    }

    private void move_cloud(ImageView cloud) {
        TranslateTransition translate1 = new TranslateTransition();
        translate1.setNode(cloud);
        translate1.setDuration(Duration.millis(100000));
        translate1.setCycleCount(1);
        translate1.setInterpolator(Interpolator.LINEAR);
        translate1.setToX((1000 + cloud.getLayoutX()) * -1);
        translate1.play();
        translate1.setOnFinished(actionEvent -> {killBkgdObj(cloud);});
    }

    private void killGameObj(StackPane obj){
        // Deleting node of obj from scene
        gamePane.getChildren().remove(obj);
        // Removing from ArrayList
        GameObjList.remove(obj);
        // Setting Reference to null
        obj = null;
    }

    private void killBkgdObj(ImageView obj){
        // Deleting node of obj from scene
        floatPane.getChildren().remove(obj);
        cloudPane.getChildren().remove(obj);
        // Removing from ArrayList
        BkgdObjList.remove(obj);
        // Setting Reference to null
        obj = null;
    }
}