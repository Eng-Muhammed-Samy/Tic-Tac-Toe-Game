package com.example.demo3.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class WinController {
    @FXML
    protected void playAgain(ActionEvent event){
        GlobalOperation.changeScene(event, "onlinegame");
    }

    @FXML
    protected void mainMenu(ActionEvent event){
        GlobalOperation.changeScene(event, "main_menu");
    }
}
