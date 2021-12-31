package com.example.willhero;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.Objects;


public class Game extends Application {

    private Stage myStage;
    MediaPlayer mediaPlayer;

    private void setStage(Stage stage){
        this.myStage = stage;
    }

    public Stage getStage(){
        return this.myStage;
    }
    @Override
    public void start(Stage stage) throws IOException {
        music();

        FXMLLoader fxmlLoader = new FXMLLoader(Game.class.getResource("loading_screen.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 600);
        stage.setTitle("WILL HERO");
        stage.getIcons().add(new Image("https://play-lh.googleusercontent.com/Y07T-_5gdE7aUVAgAegAKzeULKTOpXrt4cL9SlKnfnl2qKvBG5oUTNhSb69bEwiLQ4Y"));
        stage.setScene(scene);
        setStage(stage);
        stage.show();
    }

    public void music(){
        String sound = "YouSeeBIGGIRLTT.mp3";
        Media musicc = new Media(getClass().getResource("YouSeeBIGGIRLTT.mp3").toString());
        mediaPlayer = new MediaPlayer(musicc);
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();

    }

    public static void main(String[] args) {
        launch();
    }
}