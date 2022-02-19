package com.example.demo3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class LoginController {

@FXML
    protected void loginfun(ActionEvent event){
    GlobalOperation.changeScene(event, "main_menu.fxml");
    }

}
