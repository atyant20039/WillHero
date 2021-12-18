package com.example.willhero;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import org.controlsfx.control.action.Action;

import java.io.IOException;

import static java.lang.System.exit;

public class main_menuController {
    @FXML
    private Button load_game_button, play_game_button, exit_game_button;

    @FXML
    protected void clicked_load_game_button(ActionEvent event) throws IOException {
        System.out.println("load game clicked");
        load_game_button.getScene().setRoot(FXMLLoader.load(getClass().getResource("load_saved_game.fxml")));
    }

    @FXML
    protected void clicked_play_game_button() throws IOException {
        System.out.println("play game clicked");
        play_game_button.getScene().setRoot(FXMLLoader.load(getClass().getResource("Game.fxml")));
    }

    @FXML
    protected void clicked_exit_game_button(){
        System.out.println("exit game clicked");
        exit(0);
    }
}
