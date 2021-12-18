package com.example.willhero;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Game extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Game.class.getResource("main_menu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 600);
        stage.setTitle("WILL HERO");
        stage.getIcons().add(new Image("https://play-lh.googleusercontent.com/Y07T-_5gdE7aUVAgAegAKzeULKTOpXrt4cL9SlKnfnl2qKvBG5oUTNhSb69bEwiLQ4Y"));
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}