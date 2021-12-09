package com.example.willhero;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Game extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Game.class.getResource("Game.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 600);
        stage.setTitle("WILL HERO");
//        Image gameIcon = new Image(getClass().getResourceAsStream("gameIcon.png"));
//        stage.getIcons().add(gameIcon);
//        stage.getIcons().add(new Image(getClass().getResourceAsStream("gameIcon.png")));
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}