package com.example.willhero;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;

import java.io.IOException;

public class load_saved_game_Controller {
    @FXML
    private Button back_button;

    @FXML
    protected void clicked_back(ActionEvent event) throws IOException {
        System.out.println("back");
        back_button.getScene().setRoot(FXMLLoader.load(getClass().getResource("main_menu.fxml")));
    }
}
