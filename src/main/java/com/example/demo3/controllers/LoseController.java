package com.example.demo3.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LoseController {
    @FXML
    private AnchorPane root;


    @FXML
    protected void playAgain(ActionEvent event){
        GlobalOperation.changeScene(event, "onlinegame");
    }

    @FXML
    protected void mainMenu(ActionEvent event){
        GlobalOperation.changeScene(event, "main_menu");
    }
}
