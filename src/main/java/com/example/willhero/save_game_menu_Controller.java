package com.example.willhero;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;

import java.io.IOException;

public class save_game_menu_Controller {
    @FXML
    private Button slot1, slot2, slot3;

    @FXML
    private void clicked_slot1(ActionEvent event) throws IOException {
        System.out.println("slot 1");
        //TODO: Serialize the game
        slot1.getScene().setRoot(FXMLLoader.load(getClass().getResource("main_menu.fxml")));
    }

    @FXML
    private void clicked_slot2(ActionEvent event) throws IOException {
        System.out.println("slot 2");
        //TODO: Serialize the game
        slot2.getScene().setRoot(FXMLLoader.load(getClass().getResource("main_menu.fxml")));
    }

    @FXML
    private void clicked_slot3(ActionEvent event) throws IOException {
        System.out.println("slot 3");
        //TODO: Serialize the game
        slot3.getScene().setRoot(FXMLLoader.load(getClass().getResource("main_menu.fxml")));
    }
}
