package com.example.willhero;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;

import java.io.IOException;

public class pause_menu_Controller {
    @FXML
    private Button to_main_menu, save_and_quit;

    @FXML
    protected void clicked_to_main_menu(ActionEvent event) throws IOException {
        System.out.println("to main menu");
        to_main_menu.getScene().setRoot(FXMLLoader.load(getClass().getResource("main_menu.fxml")));
    }

    @FXML
    protected void clicked_save_and_quit(ActionEvent event) throws IOException {
        System.out.println("save and quit");
        save_and_quit.getScene().setRoot(FXMLLoader.load(getClass().getResource("save_game_menu.fxml")));
    }
}
