package com.example.willhero;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;



public class Game extends Application {

    private Stage myStage;

    private void setStage(Stage stage){
        this.myStage = stage;
    }

    public Stage getStage(){
        return this.myStage;
    }
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Game.class.getResource("loading-screen.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 600);
        stage.setTitle("WILL HERO");
        stage.getIcons().add(new Image("https://play-lh.googleusercontent.com/Y07T-_5gdE7aUVAgAegAKzeULKTOpXrt4cL9SlKnfnl2qKvBG5oUTNhSb69bEwiLQ4Y"));
        stage.setScene(scene);
        setStage(stage);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}