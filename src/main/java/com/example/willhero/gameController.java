package com.example.willhero;

/*TODO:
    Hero Orc collision overlapping
    Increase gap between platforms (~ more than size of 2 orcs)
    Add trees to background floating platforms
*/
import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.controlsfx.control.action.Action;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class gameController implements Initializable {

    @FXML
    private Pane cloudPane, floatPane;

    @FXML
    private AnchorPane gamePane;

    private StackPane abyss;

    @FXML
    private Button pause_button, move_hero_button, shurikenButton, knifeButton;

    @FXML
    private Text score_text, coin_text;

    private GameObjectFactory factory = new GameObjectFactory();

    private ArrayList<GameObject> GameObjList = new ArrayList<GameObject>();
    private ArrayList<Orcs> orcList = new ArrayList<Orcs>();
    private ArrayList<Platform> platformList = new ArrayList<Platform>();
    private ArrayList<Chest> chestList = new ArrayList<Chest>();
    private ArrayList<Coin> coinList = new ArrayList<Coin>();
    private ArrayList<Weapon> weaponList = new ArrayList<Weapon>();
    private ArrayList<ImageView> BkgdObjList = new ArrayList<>();
    Timeline cloudTimer, floatLandTimer, platTimer, orcTimer, coinTimer;
    private Hero gameHero;
    private int userScore = 0, userCoin = 0, orc_per_plat = 2, coin_per_plat = 3;
    private Random rand = new Random();
    private boolean equiped_shuriken = false, equiped_knife = false;

    @FXML
    protected void clicked_pause(ActionEvent event) throws IOException {
        //TODO: cloudTimer is paused here. It needed to be resumed when the game is resumed/deserialized
        System.out.println("pause clicked");
        cloudTimer.pause();
        pause_button.getScene().setRoot(FXMLLoader.load(getClass().getResource("pause_menu.fxml")));
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        shurikenButton.setDisable(true);
        knifeButton.setDisable(true);

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
                if (BkgdObjList.get(i).getLayoutX() < 500){
                    this.killBkgdObj(BkgdObjList.get(i));
                }
            }
        }));
        floatLandTimer.setCycleCount(TranslateTransition.INDEFINITE);
        floatLandTimer.play();

//        if(userScore < )
        platTimer = new Timeline(new KeyFrame(Duration.millis(1000), e -> {
            boolean genPlat = true;
            for (GameObject o : GameObjList){
                if (o.getClass().equals(Platform.class) && o.getPane().getLayoutX() > rand.nextInt(2250, 2300)){
                    genPlat = false;
                    break;
                }
            }
//            if (genPlat && (userScore > 1 && userScore < 10)){
//                this.generateGameObj(4,2750,350);
//                System.out.println("hello");
//            }
            if (genPlat){
                this.generateGameObj(5, 2700,400);
            }

            for (int o = 0; o < GameObjList.size(); o++){
                if (GameObjList.get(o).getPane().getLayoutX() < 500){   //Possible BUG
                    this.killGameObj(GameObjList.get(o));
                }
            }
        }));
        platTimer.setCycleCount(TranslateTransition.INDEFINITE);
        platTimer.play();

//        int orc_per_plat = 3;
        orcTimer = new Timeline(new KeyFrame(Duration.millis(1000), e -> {
            boolean genOrc = true;
            for (GameObject o : GameObjList){
                if (o.getClass().equals(Orcs.class) && o.getPane().getLayoutX() > rand.nextInt(2250, 2300)){
                    genOrc = false;
                    break;
                }
            }
            if (genOrc) {
                orc_per_plat = 2;
                this.generateGameObj(1, 2700,400);
            }

            int rand_count = rand.nextInt(20);
            if (rand_count%2 == 0 && orc_per_plat > 0 && !(orcList.get(orcList.size() - 1).getPane().getLayoutX() > 2650)){
                this.generateGameObj(1, 2700, 400);
                orc_per_plat--;
            }


//            for (int o = 0; o < GameObjList.size(); o++){
//                if (GameObjList.get(o).getPane().getLayoutX() < 500){   //Possible BUG
//                    this.killGameObj(GameObjList.get(o));
//                }
//            }
        }));
        orcTimer.setCycleCount(TranslateTransition.INDEFINITE);
        orcTimer.play();

        coinTimer = new Timeline(new KeyFrame(Duration.millis(1000), e -> {
            boolean genCoin = true;
            for (GameObject o : GameObjList){
                if (o.getClass().equals(Coin.class) && o.getPane().getLayoutX() > rand.nextInt(2300, 2400)){
                    genCoin = false;
                    break;
                }
            }

            if (genCoin) {
                coin_per_plat = 2;
//                coinDepth = ((rand.nextInt(2)) * 66);
                this.generateGameObj(7, 2700,300);
            }

            int rand_count = rand.nextInt(2);
            if (rand_count%2 == 0 && coin_per_plat > 0 && !(coinList.get(coinList.size() - 1).getPane().getLayoutX() > 2675)){
                this.generateGameObj(7, 2700,300);
                coin_per_plat--;
            }
        }));
        coinTimer.setCycleCount(TranslateTransition.INDEFINITE);
        coinTimer.play();

        generateBkgdObj(1);
        generateBkgdObj(2);
        generateGameObj(5, 2700, 400);
        generateGameObj(1, 2700, 300);
        generateGameObj(7,2700,300);
        //Initial Work//
        /* x_coordinate = 1300
           y_coordinate = 100*/
        this.gameHero = Hero.getHero();
        gamePane.getChildren().add(gameHero.getPane());
        applyGravity(gameHero, false);
        for (int i = 0; i < 3; i++){
            generateGameObj(5,1200 + 500*i,400); //For generating first three platforms
            if(i == 2){
                this.generateGameObj(4,1250 + 500*i,350);
            }
            else if(i==1){
                this.generateGameObj(3,1250 + 500*i, 350);
            }
        }

        /*Generating Abyss*/
        generateGameObj(8,1000,625);


//        Windmill mill = new Windmill(1500, 100);
//        gamePane.getChildren().add(mill.getTower());
//        gamePane.getChildren().add(mill.getPane());
//        RotateTransition rotate = new RotateTransition();
//        rotate.setNode(mill.getPane());
//        rotate.setDuration(Duration.seconds(10));
//        rotate.setByAngle(360);
//        rotate.setCycleCount(RotateTransition.INDEFINITE);
//        rotate.setInterpolator(Interpolator.LINEAR);
//        rotate.play();
    }

    ImageView knife;
    ImageView shuriken;

//    public void sword_action(ActionEvent event) {
//        if (equiped_knife){
////            gameHero.getPane().getChildren().remove(2);
//            knife.setVisible(false);
//        }
//        if (!equiped_sword){
//            equiped_sword = true;
//            equiped_knife = false;
//            Image swordImg = new Image(String.valueOf(getClass().getResource("Sword2.png")));
//            ImageView sword = new ImageView(swordImg);
//            sword.setFitWidth(100.0);
//            sword.setFitHeight(25.0);
//            sword.setLayoutX(gameHero.getPane().getLayoutX() - sword.getFitWidth() + 10);
//            sword.setLayoutY(gameHero.getPane().getLayoutY());
//            sword.setTranslateY(gameHero.getPane().getTranslateY());
////            weaponList.add(0,sword);
//            gamePane.getChildren().add(sword);
//        }
//        Hero.getHero().changeWeapon(0);
//
//        // TODO: Remove sword image from scene
//    }

    public void shuriken_action(ActionEvent event){
        if (equiped_knife){
//            gameHero.getPane().getChildren().remove(2);
            equiped_shuriken = true;
            equiped_knife = false;
            shuriken.setVisible(true);
        }
        else if (!equiped_shuriken){
            equiped_knife = false;
            equiped_shuriken = true;
            Image shurikenImg = new Image(String.valueOf(getClass().getResource("Shuriken.png")));
            shuriken = new ImageView(shurikenImg);
            shuriken.setFitWidth(20.0);
            shuriken.setFitHeight(20.0);
            gameHero.getPane().setAlignment(shuriken, Pos.BOTTOM_LEFT);
            gameHero.getPane().getChildren().add(shuriken);
        }
        Hero.getHero().changeWeapon(0);
    }

    public void knife_action(ActionEvent event) {
        if (equiped_shuriken){
//            gameHero.getPane().getChildren().remove(2);
            equiped_shuriken = false;
            equiped_knife = true;
            knife.setVisible(true);
        }
        else if (!equiped_knife){
            equiped_shuriken = false;
            equiped_knife = true;
            Image knifeImg = new Image(String.valueOf(getClass().getResource("knife_eq.png")));
            knife = new ImageView(knifeImg);
            knife.setFitWidth(20.0);
            knife.setFitHeight(20.0);
            gameHero.getPane().setAlignment(knife, Pos.BOTTOM_LEFT);
            gameHero.getPane().getChildren().add(knife);
        }
        Hero.getHero().changeWeapon(1);
        // TODO: Remove sword image from scene
    }

//    ThrowingKnives t1 = ThrowingKnives.getInstance();

    public void move_hero(ActionEvent event) {
        this.userScore++;
        score_text.setText("" + this.userScore);
        for (GameObject s: GameObjList){
            if (s instanceof Abyss){continue;}
            else{
                s.getPane().setLayoutX(s.getPane().getLayoutX() - 50);
            }

        }

        for (ImageView i: BkgdObjList){
            i.setLayoutX(i.getLayoutX() - 50);
            if (i.getParent().equals(cloudPane)){
                move_cloud(i);
            }
        }

        if (equiped_shuriken){
//            RotateTransition rotate = new RotateTransition();
//            rotate.setNode(gameHero.getPane().getChildren().get(2));
//            rotate.setDuration(Duration.millis(100));
//            rotate.setCycleCount(1);
//            rotate.setInterpolator(Interpolator.LINEAR);
//            rotate.setByAngle(180);
//            rotate.play();
//
//            rotate.setOnFinished(ActionEvent -> {
//                RotateTransition rotateBack = new RotateTransition();
//                rotateBack.setNode(gameHero.getPane().getChildren().get(2));
//                rotateBack.setDuration(Duration.millis(1));
//                rotateBack.setCycleCount(10);
//                rotateBack.setInterpolator(Interpolator.LINEAR);
//                rotateBack.setByAngle(-180);
//                rotateBack.play();
//            });
            Weapon shuriken = (Weapon) factory.createObject(9,gameHero.getPane().getLayoutX() + (gameHero.getPane().getWidth() / 2), Hero.getHero().getPane().getLayoutY() + (Hero.getHero().getPane().getHeight()/2));
            if (!(gamePane.getChildren().contains(shuriken.getPane()))){
                gamePane.getChildren().add(shuriken.getPane());
                weaponList.add(shuriken);
            }
            shuriken.use_weapon();
        }

        if (equiped_knife){
            Weapon kn = (Weapon) factory.createObject(6,gameHero.getPane().getLayoutX() + (gameHero.getPane().getWidth() / 2), Hero.getHero().getPane().getLayoutY() + (Hero.getHero().getPane().getHeight()/2));
            if (!(gamePane.getChildren().contains(kn.getPane()))){
                gamePane.getChildren().add(kn.getPane());
                weaponList.add(kn);
            }
//            try {
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
            kn.use_weapon();
//            checkCollision(kn,0,0);
//            TranslateTransition translate = new TranslateTransition();
//            gameHero.getPane().getChildren().get(1).setVisible(true);
//            translate.setNode(gameHero.getPane().getChildren().get(1));
//            translate.setDuration(Duration.millis(100));
//            translate.setCycleCount(1);
//            translate.setByX(500);
//            translate.setInterpolator(Interpolator.LINEAR);
//            translate.play();
//            translate.setOnFinished(ActionEvent -> {
//                gameHero.getPane().getChildren().get(1).setVisible(false);
//                TranslateTransition returnBack = new TranslateTransition();
////                gameHero.getPane().getChildren().get(1).setVisible(true);
//                returnBack.setNode(gameHero.getPane().getChildren().get(1));
//                returnBack.setDuration(Duration.millis(0.1));
//                returnBack.setCycleCount(1);
//                returnBack.setByX(-500);
////                returnBack.setInterpolator(Interpolator.LINEAR);
//                returnBack.play();
//            });


        }

        //        System.gc();
        //        System.runFinalization();
    }

    private void generateGameObj(int objno, double x, double y) {
        GameObject obj = factory.createObject(objno,x,y);
        GameObjList.add(obj);
        checkCategory(obj);
        gamePane.getChildren().add(obj.getPane());
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
        orcList.remove(obj);
        chestList.remove(obj);
        platformList.remove(obj);
        coinList.remove(obj);
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

    private void applyGravity(GameObject gameItem, boolean gCondition ){
        AnimationTimer timer = new AnimationTimer() {
            double time = 0;
            double velocityY = 0;
            final double gravity = 15.8;
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
//                if(gCondition){
//                    this.stop();
//                    if (gameItem instanceof Hero){
//                        gameHero.die();
//                    }
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
            if (!orc.isDisableCollision()){

                if (orc.getPane().getBoundsInParent().intersects(abyss.getBoundsInParent())){
                    System.out.println(orc.getId() + " fell in Abyss!");
                    orc.die();
                    this.userCoin++;
                    coin_text.setText("" + this.userCoin);
                    killGameObj(orc);

                }

                for(int i = 0; i < platformList.size(); i++){

                    if (orc.getPane().getBoundsInParent().intersects(platformList.get(i).getPane().getBoundsInParent())) {
                        velocityY = -4.5;
                        time = 0.13;
                        collision = 1;
                        return new double[]{collision,velocityY,time};
                    }
                }

                for (int i = 0; i < weaponList.size(); i++){
                    if (weaponList.get(i).getPane().isVisible() && weaponList.get(i).getPane().getBoundsInParent().intersects(orc.getPane().getBoundsInParent())){
                        orc.die();
                        this.userCoin++;
                        coin_text.setText("" + userCoin);
                        weaponList.get(i).getPane().setVisible(false);
                        //TODO: Kill instance of orc and remove from scene one dead orc touches abyss
                    }
                }
            }
        }
        else if (object instanceof Chest){
            Chest chest = (Chest) object;
            for(int p = 0; p < platformList.size(); p++){
                if (chest.getPane().getBoundsInParent().intersects(platformList.get(p).getPane().getBoundsInParent())){
                    velocityY = -0.1;
                    time = 0.1;
                    collision = 1;
                    return new double[]{collision,velocityY,time};
                }
            }
        }

        else if (object instanceof Hero){
            gameHero = (Hero) object;
            if (!gameHero.isDisableCollision()) {
                for (int i = 0; i < platformList.size(); i++) {
//                CODE 1: Checking Collision using Rectangle inside StackPane
                    if (gameHero.getPane().getBoundsInParent().intersects(platformList.get(i).getPane().getBoundsInParent()) && ((platformList.get(i).get_Y() - gameHero.get_Y()) > 40)) {
                        velocityY = -5.5;
                        time = 0.13;
                        collision = 1;
                        return new double[]{collision, velocityY, time};
                    }
                }

                for (int o = 0; o < orcList.size(); o++) {
                    if ((!orcList.get(o).isDisableCollision()) && !(orcList.get(o).getPane().getLayoutX() < gameHero.get_X() - 200 && orcList.get(o).getPane().getLayoutX() > gameHero.get_X() + 200)) {
                        if (gameHero.getPane().getBoundsInParent().intersects(orcList.get(o).getPane().getBoundsInParent()) && ((orcList.get(o).get_Y() - gameHero.get_Y()) > 25)) {
                            velocityY = -5.5;//5.5 (just for testing)
                            time = 0.13;
                            collision = 1;
                            return new double[]{collision, velocityY, time};
                        } else if (gameHero.getPane().getBoundsInParent().intersects(orcList.get(o).getPane().getBoundsInParent()) && ((gameHero.get_Y()) - orcList.get(o).get_Y() < 42)) {
                            System.out.println("orcY: " + orcList.get(o).get_Y() + "\norcX: " + orcList.get(o).get_X() + "\nheroY: " + gameHero.get_Y() + "\nheroX: " + gameHero.get_X());
                            boolean oCollision = false;
                            int shiftX = 0;
                            int totalShift = 0;
                            while (!oCollision) {
                                shiftX++;
                                totalShift += shiftX;
                                if (totalShift >= 100) {
                                    break;
                                }
                                orcList.get(o).getPane().setLayoutX(orcList.get(o).getPane().getLayoutX() + shiftX);
                                oCollision = checkObjtoObjCollision(orcList.get(o));
                            }
                        }
//                        else if (gameHero.getPane().getBoundsInParent().intersects(orcList.get(o).getPane().getBoundsInParent())){
//                            gameHero.die();
//                        }
                    }
                }

                for (int c = 0; c < chestList.size(); c++){
                    if ((!chestList.get(c).isDisableCollision()) && !(chestList.get(c).getPane().getLayoutX() < gameHero.get_X() - 200 && chestList.get(c).getPane().getLayoutX() > gameHero.get_X() + 200)){
                        if(gameHero.getPane().getBoundsInParent().intersects(chestList.get(c).getPane().getBoundsInParent())){
                            // chestList.get(c).give_hero(gameHero);


                            // below code will be inside give_hero() function;
                            if (chestList.get(c) instanceof CoinChest){
                                CoinChest c_Chest = (CoinChest) chestList.get(c);
                                c_Chest.give_hero(gameHero);
                                this.userCoin += 10;
                                coin_text.setText("" + userCoin);
                            }
                            else{
                                WeaponChest w_Chest = (WeaponChest) chestList.get(c);
                                w_Chest.give_hero(gameHero);
                                if (w_Chest.getWeapon().equals("ThrowingKnife")){
                                    knifeButton.setDisable(false);
                                    equiped_knife = true;
                                    equiped_shuriken = false;
                                }
                                else{
                                    shurikenButton.setDisable(false);
                                    equiped_knife = false;
                                    equiped_shuriken = true;
                                }
                            }
                        }
                    }
                }

                for (int i = 0; i < coinList.size(); i++) {
                    if (coinList.get(i).getPane().isVisible() && coinList.get(i).getPane().getBoundsInParent().intersects(gameHero.getPane().getBoundsInParent())) {
                        coinList.get(i).getPane().setVisible(false);
                        userCoin++;
                        coin_text.setText("" + this.userCoin);
                    }
                }
            }
        }
        else if (object instanceof Boss){

        }
        else if (object instanceof Platform){
            Platform platform = (Platform) object;
            gamePane.setBottomAnchor(platform.getPane(), 0.0);
        }
        return new double[]{0,velocityY,time};
    }

    private void checkCategory(GameObject object){
        if (object instanceof Orcs){
            Orcs orc = (Orcs) object;
            orcList.add(orc);
            applyGravity(orc,false);
        }
        else if (object instanceof Boss){

        }
        else if (object instanceof WeaponChest){
            WeaponChest wChest =  (WeaponChest) object;
            chestList.add(wChest);
            applyGravity(wChest,false);
        }
        else if (object instanceof CoinChest){
            CoinChest cChest = (CoinChest) object;
            chestList.add(cChest);
            applyGravity(cChest,false);
        }
        else if (object instanceof Platform){
            Platform platform = (Platform) object;
            platformList.add(platform);
        }
        else if (object instanceof Abyss){
            Abyss gameAbyss = (Abyss) object;
            this.abyss = gameAbyss.getPane();
        }
        else if (object instanceof ThrowingKnives){

        }
        else if (object instanceof Coin){
            Coin coin = (Coin) object;
            coinList.add(coin);
        }

    }

    private boolean checkObjtoObjCollision(GameObject object){

        if(object instanceof Orcs){
            Orcs orc = (Orcs) object;
            for (int o = 0; o < orcList.size(); o++){
                if (orc.getId().equals(orcList.get(o).getId())){
                    continue;
                }
                else if (orc.getPane().getBoundsInParent().intersects(orcList.get(o).getPane().getBoundsInParent())){
                    orcList.get(o).getPane().setLayoutX(orcList.get(o).getPane().getLayoutX() + 100);
                    return true;
                }
            }
        }
        return false;
    }
}