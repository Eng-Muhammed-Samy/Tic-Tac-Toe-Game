package com.example.demo3.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class GameStatusController implements Initializable {
    @FXML
    private Button offline;

    @FXML
    private Button online;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        offline.setOnAction((e)->{
         GlobalOperation.changeScene(e,"offlinegame");
            });
        online.setOnAction((e)->{
            GlobalOperation.changeScene(e,"onlinegame");
        });

    }
}
