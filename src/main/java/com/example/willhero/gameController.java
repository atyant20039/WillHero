package com.example.willhero;

/*TODO:
    Move hero
    Kill instances
    Hero Orc collision overlapping
*/
import javafx.animation.AnimationTimer;
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
import java.lang.reflect.Array;
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

    @FXML
    private StackPane platform4;

    private GameObjectFactory factory = new GameObjectFactory();

    private ArrayList<GameObject> GameObjList = new ArrayList<GameObject>();
    private ArrayList<Orcs> orcList = new ArrayList<Orcs>();
    private ArrayList<Platform> platformList = new ArrayList<Platform>();
    private ArrayList<Chest> chestList = new ArrayList<Chest>();
    private ArrayList<ImageView> BkgdObjList = new ArrayList<>();

    @FXML
    protected void clicked_pause(ActionEvent event) throws IOException {
        System.out.println("pause clicked");
        pause_button.getScene().setRoot(FXMLLoader.load(getClass().getResource("pause_menu.fxml")));
    }

    private Hero h;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //TODO: Cloud pane rotation is a problem. Needed to fix it later
//        TranslateTransition translate1 = new TranslateTransition();
//        translate1.setNode(cloudPane);
//        translate1.setDuration(Duration.millis(100000));
//        translate1.setCycleCount(TranslateTransition.INDEFINITE);
//        translate1.setByX((cloudPane.getLayoutX() + cloudPane.getPrefWidth()) * -1);
//        translate1.play();
//
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
//        for (StackPane s: GameObjList){
//
//        }
//
//        for (ImageView i: BkgdObjList){
//
//        }
//        cloudPane.setLayoutX(cloudPane.getLayoutX() - 50);
        floatPane.setLayoutX(floatPane.getLayoutX() - 50);
        gamePane.setLayoutX(gamePane.getLayoutX() - 50);
        hero.setLayoutX(hero.getLayoutX() + 50);

//        generateObject(1);

        GameObject obj2 = factory.createObject(5, platform4.getLayoutX(),325);
        GameObjList.add(obj2);
        checkCategory(obj2);
        gamePane.getChildren().add(obj2.getObjectPane());
        generateGameObj(1);

//        generateBkgdObj(1);
    }

    private void generateGameObj(int objno) {
        GameObject obj = factory.createObject(objno,100 + hero.getLayoutX(),200);


        GameObjList.add(obj);
        checkCategory(obj);

        applyGravity(obj);
        gamePane.getChildren().add(obj.getObjectPane());

        System.out.println(obj.getObjectPane().getId());
    }

    private void generateBkgdObj(int objno){
        ImageView obj = factory.create_bkgd_obj(objno);
        BkgdObjList.add(obj);
        if (objno == 1){
            cloudPane.getChildren().add(obj);
            move_cloud(obj);
        }
        else floatPane.getChildren().add(obj);
    }

    private void move_cloud(ImageView cloud) {
        TranslateTransition translate1 = new TranslateTransition();
        translate1.setNode(cloud);
        translate1.setDuration(Duration.millis(1000));
        translate1.setCycleCount(1);
        translate1.setToX(-1 * cloud.getLayoutX());
        translate1.play();
    }

    private void applyGravity(GameObject object){
        AnimationTimer timer = new AnimationTimer() {
            double time = 0;
            double velocityY = 0;
            double gravity = 15.8;
            double prevVelocityY = 0;
            @Override
            public void handle(long l) {
                double currY = object.getObjectPane().getLayoutY();
                velocityY += gravity*(0.5)*Math.pow(time,2);
                double deltaY = velocityY;
                double newY = currY + deltaY;
                double[] tempArray = checkCollision(object,velocityY,time);
                if(tempArray[0] == 1){
                    velocityY = tempArray[1];
                    time = tempArray[2];
                }
                object.getObjectPane().setLayoutY(newY);
                object.set_coord();
//                if(condition2){
//                    this.stop();
//                }
                prevVelocityY = velocityY;
                time += 0.001;
            }
        };
        timer.start();
    }

    private double[] checkCollision(GameObject object, double velocityY, double time){
        double collision = 0;
        if (object instanceof Orcs){
            Orcs orc = (Orcs) object;
            for(int i = 0; i < platformList.size(); i++){
                if (orc.getObjectPane().getBoundsInParent().intersects(platformList.get(i).getObjectPane().getBoundsInParent())){
                    velocityY = -3.5;
                    time = 0.13;
                    collision = 1;
                    return new double[]{collision,velocityY,time};
                }
            }

        }
        else if (object instanceof Boss){

        }
        else if (object instanceof WeaponChest){
            WeaponChest wChest =  (WeaponChest) object;
            chestList.add(wChest);
        }
        else if (object instanceof CoinChest){
            CoinChest cChest = (CoinChest) object;
            chestList.add(cChest);
        }
        else if (object instanceof Platform){
            Platform platform = (Platform) object;
            platformList.add(platform);
        }
        return new double[]{0,velocityY,time};
    }

    private void checkCategory(GameObject object){
        if (object instanceof Orcs){
            Orcs orc = (Orcs) object;
            orcList.add(orc);
        }
        else if (object instanceof Boss){

        }
        else if (object instanceof WeaponChest){
            WeaponChest wChest =  (WeaponChest) object;
            chestList.add(wChest);
        }
        else if (object instanceof CoinChest){
            CoinChest cChest = (CoinChest) object;
            chestList.add(cChest);
        }
        else if (object instanceof Platform){
            Platform platform = (Platform) object;
            platformList.add(platform);
        }

    }
}