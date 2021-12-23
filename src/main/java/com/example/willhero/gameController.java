package com.example.willhero;

/*TODO:
    Move hero
    Kill instances
    Hero Orc collision overlapping
*/
import javafx.animation.AnimationTimer;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
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
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.*;

public class gameController implements Initializable {
    @FXML
    private Pane cloudPane, floatPane;

    @FXML
    private AnchorPane gamePane;

    @FXML
    private StackPane hero, temp_plat1, temp_plat2, temp_plat3, temp_plat4;

    @FXML
    private Button pause_button;

    @FXML
    private Button move_hero_button;

    @FXML
    private Text score_text;

    private GameObjectFactory factory = new GameObjectFactory();

    private ArrayList<GameObject> GameObjList = new ArrayList<GameObject>();
    private ArrayList<Orcs> orcList = new ArrayList<Orcs>();
    private ArrayList<Platform> platformList = new ArrayList<Platform>();
    private ArrayList<Chest> chestList = new ArrayList<Chest>();
    private ArrayList<ImageView> BkgdObjList = new ArrayList<>();
    Timeline cloudTimer, floatLandTimer, platTimer, orcTimer;
    private Hero h;
    private int userScore = 0;
    private Random rand = new Random();

    @FXML
    protected void clicked_pause(ActionEvent event) throws IOException {
        //TODO: cloudTimer is paused here. It needed to be resumed when the game is resumed/deserialized
        System.out.println("pause clicked");
        cloudTimer.pause();
        pause_button.getScene().setRoot(FXMLLoader.load(getClass().getResource("pause_menu.fxml")));
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TranslateTransition translate2 = new TranslateTransition();
        translate2.setNode(floatPane);
        translate2.setDuration(Duration.millis(5000));
        translate2.setCycleCount(TranslateTransition.INDEFINITE);
        translate2.setAutoReverse(true);
        translate2.setByY(floatPane.getLayoutY() + 10);
        translate2.play();

        cloudTimer = new Timeline(new KeyFrame(Duration.millis(1000), e -> {
            boolean genCloud = true;
            for (ImageView i : this.BkgdObjList){
                if (cloudPane.equals(i.getParent()) && i.getLayoutX() + i.getTranslateX() > 2400){
                    genCloud = false;
                    break;
                }
            }
            if (genCloud) this.generateBkgdObj(1);
        }));
        cloudTimer.setCycleCount(TranslateTransition.INDEFINITE);
        cloudTimer.play();

        floatLandTimer = new Timeline(new KeyFrame(Duration.millis(3000), e -> {
            boolean genFloatPlat = true;
            for (ImageView i : BkgdObjList){   //BUG
                if (floatPane.equals(i.getParent()) && i.getLayoutX() > 2200){
                    genFloatPlat = false;
                    break;
                }
            }
            if (genFloatPlat) this.generateBkgdObj(2);

            for (int i = 0; i < BkgdObjList.size(); i++){
                if (BkgdObjList.get(i).getLayoutX() < -500){
                    this.killBkgdObj(BkgdObjList.get(i));
                }
            }

//            System.out.println("------------------------------------------------------------");
//            System.out.println("Game Object List : " + GameObjList.size());
////            System.out.println(GameObjList);
//            System.out.println("Bkgd List : " + BkgdObjList.size());
////            System.out.println(BkgdObjList);
//            System.out.println("Cloud Pane " + cloudPane.getChildren().size());
////            System.out.println(cloudPane.getChildren());
//            System.out.println("Float Pane " + floatPane.getChildren().size());
////            System.out.println(floatPane.getChildren());
//            System.out.println("Game Pane " + gamePane.getChildren().size());
////            System.out.println(gamePane.getChildren());
        }));
        floatLandTimer.setCycleCount(TranslateTransition.INDEFINITE);
        floatLandTimer.play();

        platTimer = new Timeline(new KeyFrame(Duration.millis(1000), e -> {
            boolean genPlat = true;
            for (GameObject o : GameObjList){
                if (o.getClass().equals(Platform.class) && o.getPane().getLayoutX() > rand.nextInt(2150, 2200)){
                    genPlat = false;
                    break;
                }
            }
            if (genPlat) this.generateGameObj(5,400);

            for (int o = 0; o < GameObjList.size(); o++){
                if (GameObjList.get(o).getPane().getLayoutX() < -500){   //Possible BUG
                    this.killGameObj(GameObjList.get(o));
                }
            }
        }));
        platTimer.setCycleCount(TranslateTransition.INDEFINITE);
        platTimer.play();

        orcTimer = new Timeline(new KeyFrame(Duration.millis(1000), e -> {
            boolean genOrc = true;
            for (GameObject o : GameObjList){
                if (o.getClass().equals(Orcs.class) && o.getPane().getLayoutX() > rand.nextInt(2200, 2300)){
                    genOrc = false;
                    break;
                }
            }
            if (genOrc) this.generateGameObj(1,300);

            for (int o = 0; o < GameObjList.size(); o++){
                if (GameObjList.get(o).getPane().getLayoutX() < -500){   //Possible BUG
                    this.killGameObj(GameObjList.get(o));
                }
            }
        }));
        orcTimer.setCycleCount(TranslateTransition.INDEFINITE);
        orcTimer.play();

        generateBkgdObj(1);
        generateBkgdObj(2);
        generateGameObj(5, 400);
        generateGameObj(1,300);
        h = new Hero(hero.getLayoutX(), hero.getLayoutY());
        h.setPane(hero);
    }

    public void move_hero(ActionEvent event) {
        System.out.println("hero moved");
//        applyGravity(h);

//        h.getUser().setScore(h.getUser().getScore() + 1);
        this.userScore++;
        score_text.setText("" + this.userScore);
        for (GameObject s: GameObjList){
            s.getPane().setLayoutX(s.getPane().getLayoutX() - 50);
        }

        for (ImageView i: BkgdObjList){
            i.setLayoutX(i.getLayoutX() - 50);
            if (i.getParent().equals(cloudPane)){
                move_cloud(i);
            }
        }

        //        System.gc();
        //        System.runFinalization();
    }

    private void generateGameObj(int objno, float y) {
        GameObject obj = factory.createObject(objno,2700,y);
        GameObjList.add(obj);
        checkCategory(obj);
        gamePane.getChildren().add(obj.getPane());
        System.out.println(obj.getPane().getId());
    }

    private void generateBkgdObj(int objno){
        ImageView obj = factory.create_bkgd_obj(objno);
        BkgdObjList.add(obj);
        if (objno == 1){
            System.out.println("cloud created");
            cloudPane.getChildren().add(obj);
            move_cloud(obj);
        }
        else floatPane.getChildren().add(obj);
//        obj = null;   ERROR
    }

    private void move_cloud(ImageView cloud) {
        TranslateTransition translate1 = new TranslateTransition();
        translate1.setNode(cloud);
        translate1.setDuration(Duration.millis(Math.abs((1000 + cloud.getLayoutX())/0.03)));
        translate1.setCycleCount(1);
        translate1.setInterpolator(Interpolator.LINEAR);
        translate1.setToX((1000 + cloud.getLayoutX()) * -1);
        translate1.play();
        translate1.setOnFinished(actionEvent -> {killBkgdObj(cloud);});
    }

    private void killGameObj(GameObject obj){ //Possible BUG
        // Deleting node of obj from scene
        gamePane.getChildren().remove(obj.getPane());
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

    private void applyGravity(GameObject gameItem){
        AnimationTimer timer = new AnimationTimer() {
            double time = 0;
            double velocityY = 0;
            double gravity = 15.8;
            double prevVelocityY = 0;
            @Override
            public void handle(long l) {
                double currY = gameItem.getPane().getLayoutY();
                velocityY += gravity*(0.5)*Math.pow(time,2);
                double deltaY = velocityY;
                double newY = currY + deltaY;
                double[] tempArray = checkCollision(gameItem,velocityY,time);
                if(tempArray[0] == 1){
                    velocityY = tempArray[1];
                    time = tempArray[2];
                }
                gameItem.getPane().setLayoutY(newY);
                gameItem.set_coord(gameItem.getPane().getLayoutX(),gameItem.getPane().getLayoutY());
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
                if (orc.getPane().getBoundsInParent().intersects(platformList.get(i).getPane().getBoundsInParent())){
                    velocityY = -5.5;
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
            gamePane.setBottomAnchor(platform.getPane(), 0.0);
        }
        return new double[]{0,velocityY,time};
    }

    private void checkCategory(GameObject object){
        if (object instanceof Orcs){
            Orcs orc = (Orcs) object;
            orcList.add(orc);
            applyGravity(orc);
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